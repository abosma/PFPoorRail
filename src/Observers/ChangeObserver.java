package Observers;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.IItem;
import Core.RichRail;
import Model.Train;
import Model.Wagon;

public class ChangeObserver implements Observer
{
	private JPanel _drawPanel;
	private Map<Class,String> _images;

	public ChangeObserver(Subject subject, JPanel drawPanel)
	{
		_images = new HashMap<>();
		_images.put(Train.class,"src/images/train.png");
		_images.put(Wagon.class,"src/images/wagon.png");

		subject.registerObserver(this);
		
		_drawPanel = drawPanel;
		
		this.update();
	}

	@Override
	public void update()
	{
		//Clear the panel
		_drawPanel.removeAll();
		List<IItem> items = RichRail.getInstance().getAllItems();
		if (items == null)
			return;

		List<IItem> drawnItems = new ArrayList<>();
		for (IItem item : items)
		{
			if(drawnItems.contains(item))
				continue;

			if (!(item instanceof Train))
				continue;

			BufferedImage itemPath = getImage(_images.get(item.getClass()));
			if(itemPath == null)
				continue;

			JLabel itemImage = new JLabel(new ImageIcon(itemPath));
			Label labelButtonPressHeading = new Label();
			labelButtonPressHeading.setText(item.getName());

			_drawPanel.add(labelButtonPressHeading);
			_drawPanel.add(itemImage);
			drawnItems.add(item);

			Train train = (Train)item;
			if (train.getWagons().isEmpty())
				continue;

			int index = 0;
			for (IItem child : train.getWagons())
			{
				BufferedImage childPath = getImage(_images.get(child.getClass()));

				if(childPath == null)
					continue;

				if (train.getWagons().size() - 1 == index++)
				{
					JLabel wagonImage = new JLabel(new ImageIcon(childPath));
					_drawPanel.add(wagonImage, BorderLayout.LINE_END);
					_drawPanel.add(Box.createRigidArea(new Dimension(75, 0)));
				}
				else
				{
					JLabel wagonImage = new JLabel(new ImageIcon(childPath));
					_drawPanel.add(wagonImage, BorderLayout.LINE_END);
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

			BufferedImage itemPath = getImage(_images.get(item.getClass()));
			if(itemPath == null)
				continue;

			JLabel itemImage = new JLabel(new ImageIcon(itemPath));
			Label labelButtonPressHeading = new Label();
			labelButtonPressHeading.setText(item.getName());

			_drawPanel.add(labelButtonPressHeading);
			_drawPanel.add(itemImage);
			drawnItems.add(item);
		}
	}

	private BufferedImage getImage(String path)
	{
		try
		{
			return ImageIO.read(new File(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}