package Observers;

import java.util.ArrayList;
import java.util.List;

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
		this.update();
	}

	@Override
	public void update()
	{
		if (RichRail.getInstance().getAllItems() != null)
		{
			List<IItem> items = RichRail.getInstance().getAllItems();
			List<String> names = new ArrayList<String>();

			for (IItem i : items)
			{
				names.add(i.getName());
			}

			_comboBoxes.setModel(new DefaultComboBoxModel(names.toArray()));
			names.clear();
		}
	}
	

}