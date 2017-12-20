package Model;

import Core.RichRail;

import java.util.*;


public class Train implements IItem
{
	private List<IItem> allWagons = new ArrayList<>();
	private int _id;
	private String _name;

	public Train()
	{

	}

	public Train(String name)
	{
		_name = name;
	}

	public String getName()
	{
		return _name;
	}

	public int getId()
	{
		return _id;
	}

	@Override
	public void SetName(String name)
	{
		_name = name;

	}

	@Override
	public void SetId(int id)
	{
		_id = id;

	}

	public List<IItem> getWagons()
	{
		return allWagons;
	}

	public void setWagons(List<IItem> wag)
	{
		allWagons = wag;
		RichRail.getInstance().notifyObservers();
	}

	public void addWagon(IItem w)
	{
		allWagons.add(w);
		RichRail.getInstance().notifyObservers();
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
		RichRail.getInstance().notifyObservers();
	}
}