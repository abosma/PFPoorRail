package Actions;

import javax.swing.JTextField;
import Extensions.StringExtension;
import Factories.RailwayFactory;
import Factories.TrainFactory;
import Model.IItem;
import Model.RichRail;
import Model.Train;

import java.util.ArrayList;

public class ActionController
{
	public void addTrain(String train)
	{
		if (StringExtension.stringIsNullOrEmpty(train))
			return;
		RailwayFactory factory = new TrainFactory();
		IItem t = factory.createTrain(train);
		RichRail.getInstance().addItem(t);
	}

	public void addWagon(String wagon, int seats)
	{
		if (StringExtension.stringIsNullOrEmpty(wagon))
			return;
		TrainFactory factory = new TrainFactory();

		RichRail.getInstance().addItem(factory.createWagon(wagon, seats));
	}

	public void addWagon(String wagon, String selectedTrain)
	{
		if (StringExtension.stringIsNullOrEmpty(wagon))
			return;
		TrainFactory factory = new TrainFactory();
		for (IItem i : RichRail.getInstance().getAllItems())
		{
			if (i.getName().equals(selectedTrain))
			{
				((Train) i).addWagon(factory.createWagon(wagon, 10));
			}
		}
	}

	public void removeWagon(String selectedTrain, String selectedWagon)
	{
		for (IItem i : RichRail.getInstance().getAllItems())
		{
			if (i.getName().equals(selectedTrain))
			{
				for (IItem wagon : ((Train) i).getWagons())
				{
					((Train) i).removeWagon(wagon);
				}
			}
		}
	}

	public void removeTrain(String selectedTrain)
	{
		for (IItem i : RichRail.getInstance().getAllItems())
		{
			if (i.getName().equals(selectedTrain))
			{
				RichRail.getInstance().removeItem(i);
				return;
			}
		}
	}

	public void Remove(String name)
	{
		ArrayList<IItem> items = RichRail.getInstance().getAllItems();
		IItem toRemove = null;
		for (IItem i : items)
		{
			if(!i.getName().equals(name))
				continue;
			toRemove = i;
			break;
		}
		if(toRemove == null)
			return;
		RichRail.getInstance().getAllItems().remove(toRemove);
	}
}