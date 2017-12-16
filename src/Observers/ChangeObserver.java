package Observers;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.IItem;
import Core.RichRail;
import Model.Train;
import Model.Wagon;

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
		//Clear the panel
		drawPanel.removeAll();
		ArrayList<IItem> items = RichRail.getInstance().getAllItems();
		if (items == null)
			return;

		ArrayList<IItem> drawnItems = new ArrayList<>();
		for (IItem item : items)
		{
			if(drawnItems.contains(item))
				continue;

			if (!(item instanceof Train))
				continue;

			JLabel itemImage = new JLabel(new ImageIcon(item.getImage()));
			Label labelButtonPressHeading = new Label();
			labelButtonPressHeading.setText(item.getName());

			drawPanel.add(labelButtonPressHeading);
			drawPanel.add(itemImage);
			drawnItems.add(item);

			Train train = (Train)item;
			if (train.getWagons().isEmpty())
				continue;

			int index = 0;
			for (IItem child : train.getWagons())
			{
				if (train.getWagons().size() - 1 == index++)
				{
					JLabel wagonImage = new JLabel(new ImageIcon(child.getImage()));
					drawPanel.add(wagonImage, BorderLayout.LINE_END);
					drawPanel.add(Box.createRigidArea(new Dimension(75, 0)));
				}
				else
				{
					JLabel wagonImage = new JLabel(new ImageIcon(child.getImage()));
					drawPanel.add(wagonImage, BorderLayout.LINE_END);
				}
				drawnItems.add(child);
			}
		}
		for (IItem item : items)
		{
			if(drawnItems.contains(item))
				continue;

			if (!(item instanceof Model.Component))
				continue;

			JLabel itemImage = new JLabel(new ImageIcon(item.getImage()));
			Label labelButtonPressHeading = new Label();
			labelButtonPressHeading.setText(item.getName());

			drawPanel.add(labelButtonPressHeading);
			drawPanel.add(itemImage);
			drawnItems.add(item);
		}
	}
}