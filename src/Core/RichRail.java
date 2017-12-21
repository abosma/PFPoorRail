package Core;

import java.util.*;

import Dao.Factories.DatabaseFactory;
import Dao.Factories.DatabaseFactoryBase;
import Dao.IDao;
import Model.IItem;
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
		if (_instance == null)
		{
			synchronized (RichRail.class)
			{
				if (_instance == null)
				{
					_instance = new RichRail();
				}
			}
		}
		return _instance;
	}

	private void listChanged()
	{
		notifyObservers();
	}

	public List<IItem> getAllItems()
	{
		return _allItems;
	}

	public void setAllItems(List<IItem> at)
	{
		_allItems = at;
		listChanged();
	}

	/**
	 * Add or update an item
	 * @param item The item to add or update
	 */
	public void AddOrUpdateItem(IItem item)
	{
		if(!_allItems.contains(item))
			_allItems.add(item);
		item.SetId(_itemDoa.Store(item));
		listChanged();
	}

	public void removeItem(IItem it)
	{
		_allItems.remove(it);
		_itemDoa.Remove(it);
		listChanged();
	}

	@Override
	public void registerObserver(Observer o)
	{
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o)
	{
		int i = observers.indexOf(o);

		if (i >= 0)
		{
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers()
	{
		for (Observer o : observers)
		{
			o.update();
		}
	}
}