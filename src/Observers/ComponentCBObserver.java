package Observers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.IItem;
import Core.RichRail;
import Model.Train;

public class ComponentCBObserver implements Observer
{

	private JComboBox<String> _cbt;
	private JComboBox<String> _cbw;

	public ComponentCBObserver(Subject sub, JComboBox<String> cbt, JComboBox<String> cbw)
	{
		sub.registerObserver(this);

		_cbt = cbt;
		_cbw = cbw;
		update();
	}

	@Override
	public void update()
	{
		if (RichRail.getInstance().getAllItems() == null)
			return;

		List<IItem> items = RichRail.getInstance().getAllItems();
		List<String> wagonName = new ArrayList<String>();

		String selectedTrain = (String) _cbt.getSelectedItem();

		if (selectedTrain != null)
		{
			for (IItem i : items)
			{
				if (!(i instanceof Train))
					continue;

				if (i.getName().equals(selectedTrain))
				{
					for (IItem w : items)
					{
						if (w.GetParent() != i.getId())
							continue;

						wagonName.add(w.getName());
					}
				}
			}
			_cbw.setModel(new DefaultComboBoxModel(wagonName.toArray()));
			wagonName.clear();
		}
		else
		{
			_cbw.setModel(new DefaultComboBoxModel(new String[]{}));
		}
	}
}