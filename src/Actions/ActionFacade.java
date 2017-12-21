package Actions;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Extensions.StringExtension;
import Factories.RailwayFactory;
import Factories.TrainFactory;
import Model.IItem;
import Core.RichRail;
import Model.Train;

public class ActionFacade
{
	private RichRail _richRail;

	public ActionFacade()
	{
		_richRail = RichRail.getInstance();
	}

	/**
	 * Add a train with a name
	 *
	 * @param train The name of the train
	 */
	public boolean addTrain(String train)
	{
		if (StringExtension.stringIsNullOrEmpty(train))
			return false;

		//Check if a train with name exists
		for (IItem i : _richRail.getAllItems())
		{
			if (!i.getName().equals(train))
				continue;
			return false;
		}

		//Create a new train and add to the list
		RailwayFactory factory = new TrainFactory();
		IItem t = factory.createTrain(train);
		_richRail.AddOrUpdateItem(t);
		return true;
	}

	/**
	 * Add a new wagon with a name and seats
	 *
	 * @param name  The name of the wagon
	 * @param seats The amount of seats
	 */
	public void addWagon(String name, int seats)
	{
		if (StringExtension.stringIsNullOrEmpty(name))
			return;

		TrainFactory factory = new TrainFactory();
		IItem wagon = factory.createWagon(name, seats);
		_richRail.AddOrUpdateItem(wagon);
	}

	public void addWagon(String wagon, String trainName)
	{
		if (StringExtension.stringIsNullOrEmpty(wagon))
			return;

		Train train = GetTrainByName(trainName);

		if (train == null)
			return;

		for (IItem i : _richRail.getAllItems())
		{
			if (i.getName().equals(wagon))
			{
				System.out.println("Wagon already exists");
				return;
			}
		}

		TrainFactory factory = new TrainFactory();
		IItem newItem = factory.createWagon(wagon, 10);
		newItem.SetParent(train.getId());
		_richRail.AddOrUpdateItem(newItem);
	}

	/**
	 * Remove the items of a parent
	 *
	 * @param parentName the name of the train
	 */
	public void RemoveItem(String parentName, String childName)
	{
		Train train = GetTrainByName(parentName);

		if (train == null)
			return;

		IItem toRemove = null;
		for(IItem item : _richRail.getAllItems())
		{
			if(item.GetParent() != train.getId())
				continue;

			if(!item.getName().equals(childName))
				continue;
			toRemove = item;
			break;
		}

		if(toRemove == null)
			return;

		_richRail.removeItem(toRemove);
	}

	/**
	 * Remove all the child of a parent
	 *
	 * @param parentName the name of the train
	 */
	public void RemoveAllChild(String parentName)
	{
		IItem parent = GetItemByName(parentName);

		if (parent == null)
			return;

		for(IItem item : _richRail.getAllItems())
		{
			if(item.GetParent() != parent.getId())
				continue;

			//possible array modified exception
			_richRail.removeItem(item);
			break;
		}
	}

	/**
	 * Removes a train with its wagons
	 *
	 * @param trainName The name of the train
	 */
	public void removeTrain(String trainName)
	{
		Train train = GetTrainByName(trainName);

		if (train == null)
			return;

		_richRail.removeItem(train);
	}

	/**
	 * Get a train by its name
	 *
	 * @param name The name of the train
	 * @return IItem as a train
	 */
	private Train GetTrainByName(String name)
	{
		for (IItem item : _richRail.getAllItems())
		{
			if (!item.getName().equals(name))
				continue;

			if (!(item instanceof Train))
				continue;

			return (Train) item;
		}

		return null;
	}

	/**
	 * Get any item by its name
	 *
	 * @param name The name of the item
	 * @return IItem
	 */
	public IItem GetItemByName(String name)
	{
		List<IItem> items = _richRail.getAllItems();
		for (IItem item : items)
		{
			if (!item.getName().equals(name))
				continue;

			return item;
		}
		return null;
	}

	/**
	 * Remove any item by it's name
	 *
	 * @param name The name of the item
	 */
	public void Remove(String name)
	{
		IItem item = GetItemByName(name);

		if (item == null)
			return;

		for(IItem child : _richRail.getAllItems())
		{
			if(child.GetParent() != child.getId())
				continue;

			_richRail.removeItem(child);
		}

		_richRail.removeItem(item);
	}

	/**
	 * Assign a item to another item
	 *
	 * @param parentName Name of the parent
	 * @param childName  The name of the child
	 */
	public void AssignItemToItem(String parentName, String childName)
	{
		IItem parent = GetItemByName(parentName);

		if (parent == null)
			return;

		IItem child = GetItemByName(childName);

		if (child == null)
			return;

		child.SetParent(parent.getId());
		_richRail.AddOrUpdateItem(child);
	}

	public void updateComboBoxes(JComboBox<String> cbAllTrains, JComboBox<String> cbAllWagons)
	{
		List<String> wagonNames = new ArrayList<>();

		for (IItem item : _richRail.getAllItems())
		{
			if (item.getName().equals(cbAllTrains.getSelectedItem()))
			{
				for (IItem i : _richRail.getAllItems())
				{
					if(i.GetParent() != item.getId())
						continue;

					wagonNames.add(i.getName());
				}

				cbAllWagons.setModel(new DefaultComboBoxModel(wagonNames.toArray()));
			}
		}
	}
}