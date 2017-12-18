package Observers;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.IItem;
import Core.RichRail;

public class TrainCBObserver implements Observer
{

	private JComboBox<String> _comboBoxes;
	private Subject sub;

	public TrainCBObserver(Subject sub, JComboBox<String> comboBoxes)
	{
		this.sub = sub;
		this.sub.registerObserver(this);
		
		this._comboBoxes = comboBoxes;
	}

	@Override
	public void update()
	{
		if (RichRail.getInstance().getAllItems() != null)
		{
			ArrayList<IItem> items = RichRail.getInstance().getAllItems();
			ArrayList<String> names = new ArrayList<String>();

			for (IItem i : items)
			{
				names.add(i.getName());
			}

			_comboBoxes.setModel(new DefaultComboBoxModel(names.toArray()));
			names.clear();
		}
	}
}