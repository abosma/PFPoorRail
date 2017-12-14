package controller;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import Model.ObserverValues;
import Model.IItem;
import Model.RichRail;
import Model.Train;

public class WagonCBObserver extends Observer
{

	private ObserverValues cb;
	private String name;

	public WagonCBObserver(RichRail rr, ObserverValues cb)
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
			ArrayList<String> wagonNamen = new ArrayList<String>();

			if (name == null)
			{
				//        		name = RichRail.getInstance().getAllItems().get(0).getName();
				System.out.println(name);
			}

			for (IItem i : items)
			{
				if (i.getName().equals(name))
				{
					for (IItem w : ((Train) i).getWagons())
					{
						wagonNamen.add(w.getName());
					}
				}
			}
			cb.SetValue(wagonNamen.toArray());
			wagonNamen.clear();
		}
	}
}
