package controller;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Model.IItem;
import Model.RichRail;

public class ChangeObserver extends Observer {

	private Graphics _graphics;
	private JComboBox _cb;
	
	public ChangeObserver(RichRail rr, Graphics _graphics, JComboBox cbAllTrains) {
		this.rr = rr;
		this.rr.attach(this);
		this._graphics = _graphics;
		this._cb = cbAllTrains;
	}
	
	@Override
	public void update() {
		RichRail instance = RichRail.getInstance();
        ArrayList<IItem> items = instance.getAllItems();

        for(IItem item : items)
        {
            item.draw(_graphics);
        }
        
        items.forEach(a -> {
        	_cb.addItem(a.getName());
        });
	}

}
