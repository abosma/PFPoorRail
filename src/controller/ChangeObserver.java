package controller;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.IItem;
import Model.RichRail;
import Model.Train;

public class ChangeObserver extends Observer
{
	private JPanel drawPanel;

	public ChangeObserver(RichRail rr, JPanel panel)
	{
		this.rr = rr;
		this.rr.attach(this);
		this.drawPanel = panel;
	}

	@Override
	public void update()
	{
		drawPanel.removeAll();
		if (RichRail.getInstance().getAllItems() == null)
			return;
		ArrayList<IItem> items = RichRail.getInstance().getAllItems();
		for (IItem item : items)
		{
			JLabel trainImage = new JLabel(new ImageIcon(item.getImage()));

			Label labelButtonPressHeading = new Label();
			labelButtonPressHeading.setText(item.getName());

			drawPanel.add(labelButtonPressHeading, BorderLayout.LINE_START);
			drawPanel.add(trainImage);

			if(!(item instanceof  Train))
				continue;

			if (((Train) item).getWagons().isEmpty())
				continue;
			int index = 0;
			for (IItem i : ((Train) item).getWagons())
			{
				if (index++ == ((Train) item).getWagons().size() - 1)
				{
					JLabel wagonImage = new JLabel(new ImageIcon(i.getImage()));

					drawPanel.add(wagonImage, BorderLayout.LINE_END);
					drawPanel.add(Box.createRigidArea(new Dimension(75, 0)));
				}
				else
				{

					JLabel wagonImage = new JLabel(new ImageIcon(i.getImage()));

					drawPanel.add(wagonImage, BorderLayout.LINE_END);
				}
			}
		}
	}
}