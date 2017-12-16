package Core;

import java.util.*;

import Model.IItem;
import Model.Train;
import Model.Wagon;
import Observers.Observer;

public class RichRail
{
	private ArrayList<IItem> _allItems = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();
	private static RichRail _instance;

	public static RichRail getInstance()
	{
		if (_instance == null)
			_instance = new RichRail();

		return _instance;
	}

	public ArrayList<IItem> getAllItems()
	{
		return _allItems;
	}

	/**
	 * Omdat Java kut is dan maar zo
	 * @return
	 */
	public ArrayList<Train> GetAllTrains()
	{
		ArrayList<Train> items = new ArrayList<>();
		for(IItem item : _allItems)
		{
			if(!(item instanceof Train))
				continue;

			items.add((Train)item);
		}
		return items;
	}


	/**
	 * Omdat Java kut is dan maar zo
	 * @return
	 */
	public ArrayList<Wagon> GetAllWagons()
	{
		ArrayList<Wagon> items = new ArrayList<>();
		for(IItem item : _allItems)
		{
			if(!(item instanceof Wagon))
				continue;

			items.add((Wagon)item);
		}

		return items;
	}

	public void setAllItems(ArrayList<IItem> at)
	{
		_allItems = at;
		notifyAllObservers();
	}

	public void addItem(IItem it)
	{
		_allItems.add(it);
		notifyAllObservers();
	}

	public void removeItem(IItem it)
	{
		_allItems.remove(it);
		notifyAllObservers();
	}

	public int getLastId()
	{
		if (!_allItems.isEmpty())
			return (_allItems.get(_allItems.size() - 1).getId());

		return 0;
	}

	public void attach(Observer observer)
	{
		observers.add(observer);
	}

	public void notifyAllObservers()
	{
		for (Observer o : observers)
		{
			o.update();
		}
	}
}