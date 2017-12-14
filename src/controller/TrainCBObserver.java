package controller;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.IItem;
import Model.RichRail;

public class TrainCBObserver extends Observer
{

	private String[] cb;

	public TrainCBObserver(RichRail rr, String[] cb)
	{
		this.rr = rr;
		this.rr.attach(this);
		this.cb = cb;
	}

	@Override
	public void update()
	{
		if (RichRail.getInstance().getAllItems() != null)
		{
			ArrayList<IItem> items = RichRail.getInstance().getAllItems();
			ArrayList<String> namen = new ArrayList<String>();


			for (IItem i : items)
			{
				namen.add(i.getName());
			}

			cb.setModel(new DefaultComboBoxModel(namen.toArray()));
			namen.clear();
		}
	}
}