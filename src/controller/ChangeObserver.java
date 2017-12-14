package controller;

import java.awt.Graphics;
import java.util.ArrayList;

import Model.IItem;
import Model.RichRail;
import Model.Train;

public class ChangeObserver extends Observer {

	private Graphics _graphics;
	
	public ChangeObserver(RichRail rr, Graphics _graphics) {
		this.rr = rr;
		this.rr.attach(this);
		this._graphics = _graphics;
	}
	
	@Override
	public void update() {		
		if(RichRail.getInstance().getAllItems() != null) {
			ArrayList<IItem> items = RichRail.getInstance().getAllItems();
			for(IItem item : items)
	        {
				if(((Train)item).getWagons().isEmpty()) {
					item.draw(_graphics);
				}else {
					item.draw(_graphics);
					for(IItem i : ((Train)item).getWagons()) {
						i.draw(_graphics);
					}
				}
	        }
		}else{
			return;
		}
	}
}
