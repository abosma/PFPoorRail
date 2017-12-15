package Observers;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.IItem;
import Core.RichRail;
import Model.Train;

public class WagonCBObserver extends Observer
{

	private JComboBox<String> cbt;
	private JComboBox<String> cbw;

	public WagonCBObserver(RichRail rr, JComboBox<String> cbt, JComboBox<String> cbw)
	{
		this.rr = rr;
		this.rr.attach(this);
		this.cbt = cbt;
		this.cbw = cbw;
	}

	@Override
	public void update()
	{
		if (RichRail.getInstance().getAllItems() != null)
		{
			ArrayList<IItem> items = RichRail.getInstance().getAllItems();
			ArrayList<String> wagonNamen = new ArrayList<String>();

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