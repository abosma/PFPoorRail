package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;

import Model.IItem;
import Model.RichRail;

public class TrainCBObserver extends Observer {

	private JComboBox<String> cb;
	
	public TrainCBObserver(RichRail rr, JComboBox<String> cb) {
		this.rr = rr;
		this.rr.attach(this);
		this.cb = cb;
	}
	
	@Override
	public void update() {
        if(RichRail.getInstance().getAllItems() != null) {
        	ArrayList<IItem> items = RichRail.getInstance().getAllItems();
	        for(IItem item : items)
	        {
	            cb.addItem(item.getName());
	        }
        }
	}
}
