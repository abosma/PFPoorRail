package controller;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Model.IItem;
import Model.RichRail;
import Model.Train;

public class WagonCBObserver extends Observer {

	private JComboBox<String> cb;
	private String treinNaam;
	
	public WagonCBObserver(RichRail rr, JComboBox<String> cb, String naam) {
		this.rr = rr;
		this.rr.attach(this);
		this.cb = cb;
		this.treinNaam = naam;
	}
	
	@Override
	public void update() {
        if(RichRail.getInstance().getAllItems() != null) {
        	ArrayList<IItem> items = RichRail.getInstance().getAllItems();
        	ArrayList<String> wagonNamen = new ArrayList<String>();
        	
        	
        	for(IItem i : items) {
        		if(i.getName().equals(treinNaam)) {
        			for(IItem w : ((Train)i).getWagons()) {
            			wagonNamen.add(w.getName());
            		}
        		}
        	}
        	
        	cb.setModel(new DefaultComboBoxModel(wagonNamen.toArray()));
        	wagonNamen.clear();
        }
	}
}
