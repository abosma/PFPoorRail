package Model;

import Core.RichRail;

import java.util.*;


@SuppressWarnings("serial")
public class Train implements IItem
{
	private List<IItem> allComponents = new ArrayList<>();
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
	public int GetParent()
	{
		return -1;
	}

	@Override
	public void SetParent(int id)
	{

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

	public List<IItem> getComponents()
	{
		return allComponents;
	}

	public void setComponents(List<IItem> wag)
	{
		allComponents = wag;
		RichRail.getInstance().notifyObservers();
	}

	public void addComponents(IItem w)
	{
		allComponents.add(w);
		RichRail.getInstance().notifyObservers();
	}

	public void RemoveItem(IItem item)
	{
		allComponents.remove(item);
	}

	public void RemoveItemByName(String name)
	{
		IItem toRemove= null;
		for (IItem item : allComponents)
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