package controller;

import java.awt.*;
import java.util.ArrayList;

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
		int yPos = 0;
		GridBagConstraints constraints = new GridBagConstraints();
		for (IItem item : items)
		{
			System.out.println(item.getName());
			JLabel trainImage = new JLabel(new ImageIcon(item.getImage()));
			drawPanel.add(trainImage,constraints);
			constraints.gridy++;
			if(!(item instanceof Train))
				continue;
			if (((Train) item).getWagons().isEmpty())
				continue;

			for (IItem i : ((Train) item).getWagons())
			{
				JLabel wagonImage = new JLabel(new ImageIcon(i.getImage()));

				drawPanel.add(wagonImage,constraints);
			}
		}
	}
}
