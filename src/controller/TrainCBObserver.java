package controller;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.IItem;
import Model.RichRail;

public class TrainCBObserver extends Observer
{

	private JComboBox<String> _comboBoxes;

	public TrainCBObserver(RichRail richRail, JComboBox<String> comboBoxes)
	{
		this.rr = richRail;
		this.rr.attach(this);
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