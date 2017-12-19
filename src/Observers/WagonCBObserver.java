package Observers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.IItem;
import Core.RichRail;
import Model.Train;

public class WagonCBObserver implements Observer
{

	private JComboBox<String> cbt;
	private JComboBox<String> cbw;
	private Subject sub;

	public WagonCBObserver(Subject sub, JComboBox<String> cbt, JComboBox<String> cbw)
	{
		this.sub = sub;
		this.sub.registerObserver(this);
		
		this.cbt = cbt;
		this.cbw = cbw;
	}

	@Override
	public void update()
	{
		if (RichRail.getInstance().getAllItems() != null)
		{
			List<IItem> items = RichRail.getInstance().getAllItems();
			List<String> wagonNamen = new ArrayList<String>();

			String selectedTrain = (String) cbt.getSelectedItem();

			if (selectedTrain != null)
			{
				for (IItem i : items)
				{
					if (i.getName().equals(selectedTrain))
					{
						for (IItem w : ((Train) i).getWagons())
						{
							wagonNamen.add(w.getName());
						}
					}
				}

				cbw.setModel(new DefaultComboBoxModel(wagonNamen.toArray()));
				wagonNamen.clear();
			}
			else
			{
				cbw.setModel(new DefaultComboBoxModel(new String[]{}));
			}
		}
	}
}