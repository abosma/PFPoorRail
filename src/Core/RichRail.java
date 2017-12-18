package Core;

import java.util.*;

import Model.IItem;
import Model.Train;
import Model.Wagon;
import Observers.Observer;
import Observers.Subject;

public class RichRail implements Subject
{
	
	private static volatile RichRail _instance;
	
	private ArrayList<IItem> _allItems = new ArrayList<>();
	private List<Observer> observers = new ArrayList<Observer>();

	private RichRail() {
		
	}
	
	public static RichRail getInstance()
	{
		if(null == _instance) {
			synchronized(RichRail.class) {
				if(null == _instance) {
					_instance = new RichRail();
				}
			}
		}
		return _instance;
	}
	
	private void listChanged() {
		notifyObservers();
	}

	public ArrayList<IItem> getAllItems()
	{
		return _allItems;
	}

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
		listChanged();
	}

	public void addItem(IItem it)
	{
		_allItems.add(it);
		listChanged();
	}

	public void removeItem(IItem it)
	{
		_allItems.remove(it);
		listChanged();
	}

	public int getLastId()
	{
		if (!_allItems.isEmpty())
			return (_allItems.get(_allItems.size() - 1).getId());

		return 0;
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		
		if(i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update();
		}
	}
}