package Model;

import java.util.*;

public class RichRail
{
	private static RichRail _instance;

	public static RichRail getInstance()
	{
		if (_instance == null)
			_instance = new RichRail();

		return _instance;
	}

	private ArrayList<IItem> _allItems = new ArrayList<IItem>();

	public ArrayList<IItem> getAllItems()
	{
		return _allItems;
	}

	public void setAllItems(ArrayList<IItem> at)
	{
		_allItems = at;
	}

	public void addItem(IItem it)
	{
		_allItems.add(it);
	}

	public void removeItem(IItem it)
	{
		_allItems.remove(it);
	}

	public IItem getItemByID(int id)
	{
		for (IItem a : _allItems)
		{
			if (a.getId() != id)
		 		continue;

			return a;
		}

		return null;
	}

	public int getLastId()
	{
		return (_allItems.get(_allItems.size() - 1).getId());
	}
}