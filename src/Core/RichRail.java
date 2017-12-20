package Core;

import java.util.*;

import Dao.Factories.DatabaseFactory;
import Dao.Factories.DatabaseFactoryBase;
import Dao.IDao;
import Model.IItem;
import Model.Train;
import Observers.Observer;
import Observers.Subject;

public class RichRail implements Subject
{
	private static volatile RichRail _instance;
	
	private List<IItem> _allItems = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();
	private IDao _itemDoa;

	private RichRail()
	{
		DatabaseFactoryBase dbFactory = new DatabaseFactory();
		_itemDoa = dbFactory.GetDoa();
		setAllItems(_itemDoa.GetAll());
	}
	
	public static RichRail getInstance()
	{
		if(_instance == null) {
			synchronized(RichRail.class) {
				if(_instance == null) {
					_instance = new RichRail();
				}
			}
		}
		return _instance;
	}
	
	private void listChanged() {
		notifyObservers();
	}

	public List<IItem> getAllItems()
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

	public void setAllItems(List<IItem> at)
	{
		_allItems = at;
		listChanged();
	}

	public void addItem(IItem it)
	{
		_allItems.add(it);
		it.SetId(_itemDoa.Store(it));
		listChanged();
	}

	public void removeItem(IItem it)
	{
		_allItems.remove(it);
		_itemDoa.Remove(it);
		listChanged();
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