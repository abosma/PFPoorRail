package Model;

import java.util.*;
import controller.Observer;

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
	private List<Observer> observers = new ArrayList<Observer>();
	private IItem selectedTrain;

	public ArrayList<IItem> getAllItems()
	{
		return _allItems;
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
		if(!_allItems.isEmpty()) {
			return (_allItems.get(_allItems.size() - 1).getId());
		}else {
			return 0;
		}
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyAllObservers() {
		for(Observer o : observers) {
			o.update();
		}
	}
}