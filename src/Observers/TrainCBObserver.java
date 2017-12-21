package Observers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.IItem;
import Model.Train;
import Core.RichRail;

public class TrainCBObserver implements Observer
{
	private JComboBox<String> _comboBoxes;

	public TrainCBObserver(Subject sub, JComboBox<String> comboBoxes)
	{
		sub.registerObserver(this);
		
		_comboBoxes = comboBoxes;
		update();
	}

	@Override
	public void update()
	{
		if (RichRail.getInstance().getAllItems() == null)
			return;

		List<IItem> items = RichRail.getInstance().getAllItems();
		List<String> names = new ArrayList<>();

		for (IItem i : items)
		{
			if(!(i instanceof Train))
				continue;
			names.add(i.getName());
		}

		_comboBoxes.setModel(new DefaultComboBoxModel(names.toArray()));
		names.clear();
	}
}