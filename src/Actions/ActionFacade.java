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
	/**
	 * Add a train with a name
	 * @param train The name of the train
	 */
	public boolean addTrain(String train)
	{
		if (StringExtension.stringIsNullOrEmpty(train))
			return false;

		//Check if a train with name exists
		RichRail instance = RichRail.getInstance();
		for (IItem i : instance.getAllItems())
		{
			if (!i.getName().equals(train))
				continue;
			return false;
		}

		//Create a new train and add to the list
		RailwayFactory factory = new TrainFactory();
		IItem t = factory.createTrain(train);
		instance.addItem(t);
		return true;
	}

	/**
	 * Add a new wagon with a name and seats
	 * @param name The name of the wagon
	 * @param seats The amount of seats
	 */
	public void addWagon(String name, int seats)
	{
		if (StringExtension.stringIsNullOrEmpty(name))
			return;

		TrainFactory factory = new TrainFactory();
		IItem wagon = factory.createWagon(name, seats);
		RichRail.getInstance().addItem(wagon);
	}

	public void addWagon(String wagon, String trainName)
	{
		if (StringExtension.stringIsNullOrEmpty(wagon))
			return;

		Train train = GetTrainByName(trainName);

		if(train == null)
			return;
		
		for(IItem i : train.getComponents()) {
			if(i.getName().equals(wagon)) {
				System.out.println("Wagon already exists");
				return;
			}
		}

		TrainFactory factory = new TrainFactory();
		train.addComponents(factory.createWagon(wagon, 10));
	}

	/**
	 * Remove the wagons of a train
	 * @param trainName the name of the train
	 */
	public void RemoveWagon(String trainName,String wagonName)
	{
		Train train = GetTrainByName(trainName);

		if(train == null)
			return;

		train.RemoveItemByName(wagonName);
	}

	/**
	 * Remove all the wagons of a train
	 * @param trainName the name of the train
	 */
	public void RemoveAllWagons(String trainName)
	{
		Train train = GetTrainByName(trainName);

		if(train == null)
			return;

		train.setComponents(new ArrayList<>());
	}

	/**
	 * Removes a train with its wagons
	 * @param trainName The name of the train
	 */
	public void removeTrain(String trainName)
	{
		Train train = GetTrainByName(trainName);

		if(train == null)
			return;

		RichRail.getInstance().removeItem(train);
	}

	/**
	 * Get a train by its name
	 * @param name The name of the train
	 * @return IItem as a train
	 */
	private Train GetTrainByName(String name)
	{
		for (IItem item : RichRail.getInstance().getAllItems())
		{
			if (!item.getName().equals(name))
				continue;

			if(!(item instanceof Train))
				continue;

			return (Train)item;
		}

		return null;
	}

	/**
	 * Get any item by its name
	 * @param name The name of the item
	 * @return IItem
	 */
	public IItem GetItemByName(String name)
	{
		List<IItem> items = RichRail.getInstance().getAllItems();
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
	 * @param name The name of the item
	 */
	public void Remove(String name)
	{
		IItem item = GetItemByName(name);

		if(item == null)
			return;

		RichRail.getInstance().getAllItems().remove(item);
	}

	/**
	 * Assign a wagon to a train by name
	 * @param trainName Name of the train
	 * @param wagon The name of the wagon
	 */
	public void AssignWagonToTrain(String trainName, String wagon)
	{
		Train train = GetTrainByName(trainName);

		if(train == null)
			return;

		IItem item = GetItemByName(wagon);

		if(item == null)
			return;

		RemoveItemFromTrain(item);
		train.addComponents(item);
		item.SetParent(train.getId());

		RichRail.getInstance().addItem(item);
	}

	/**
	 * Removes an item from all the trains
	 * @param item The item to remove
	 */
	private void RemoveItemFromTrain(IItem item)
	{
		for(Train train : RichRail.getInstance().GetAllTrains())
		{
			train.RemoveItem(item);
		}
	}

	public void updateComboBoxes(JComboBox<String> cbAllTrains, JComboBox<String> cbAllWagons)
	{
		List<IItem> items = RichRail.getInstance().getAllItems();
		List<String> wagonNames = new ArrayList<>();

		for (IItem item : items)
		{
			if (item.getName().equals(cbAllTrains.getSelectedItem()))
			{
				for (IItem i : ((Train) item).getComponents())
				{
					wagonNames.add(i.getName());
				}

				cbAllWagons.setModel(new DefaultComboBoxModel(wagonNames.toArray()));
			}
		}
	}


}