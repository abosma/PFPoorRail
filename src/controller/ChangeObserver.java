package controller;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Model.IItem;
import Model.RichRail;
import Model.Train;

public class ChangeObserver extends Observer {

	private Graphics _graphics;
	private JComboBox<String> cb;
	
	public ChangeObserver(RichRail rr, Graphics _graphics, JComboBox<String> cbAllTrains) {
		this.rr = rr;
		this.rr.attach(this);
		this._graphics = _graphics;
		this.cb = cbAllTrains;
	}
	
	@Override
	public void update() {
		ArrayList<IItem> items = RichRail.getInstance().getAllItems();
		for(IItem item : items)
        {
			if(item.getName().equals(cb.getSelectedItem())) {
				if(((Train)item).getWagons().isEmpty()) {
					item.draw(_graphics);
				}else {
					item.draw(_graphics);
					for(IItem i : ((Train)item).getWagons()) {
						i.draw(_graphics);
					}
				}
	        }
        }
	}
}
