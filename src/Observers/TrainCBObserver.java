package Observers;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.IItem;
import Core.RichRail;

public class TrainCBObserver implements Observer
{

	private JComboBox<String> _comboBoxes;
	private Subject rr;

	public TrainCBObserver(Subject rr, JComboBox<String> comboBoxes)
	{
		this.rr = rr;
		this.rr.registerObserver(this);
		
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