package Model;

import Core.RichRail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import javax.imageio.ImageIO;

public class Train implements Serializable, IItem
{
	private ArrayList<IItem> allWagons = new ArrayList<IItem>();
	private int _id;
	private String _name;

	public Train(String name, int id)
	{
		_name = name;
		_id = id;
	}

	public String getName()
	{
		return _name;
	}

	public int getId()
	{
		return _id;
	}

	public ArrayList<IItem> getWagons()
	{
		return allWagons;
	}

	public void setWagons(ArrayList<IItem> wag)
	{
		allWagons = wag;
		RichRail.getInstance().notifyAllObservers();
	}

	public void addWagon(IItem w)
	{
		allWagons.add(w);
		RichRail.getInstance().notifyAllObservers();
	}

	public void RemoveItem(IItem item)
	{
		allWagons.remove(item);
	}

	public void RemoveItemByName(String name)
	{
		IItem toRemove= null;
		for (IItem item : allWagons)
		{
			if (!item.getName().equals(name))
				continue;

			if(!(item instanceof Component))
				continue;

			toRemove = item;
			break;
		}

		if(toRemove == null)
			return;

		RemoveItem(toRemove);
		RichRail.getInstance().notifyAllObservers();
	}

	public BufferedImage getImage()
	{
		try
		{
			return ImageIO.read(new File("src/images/train.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}