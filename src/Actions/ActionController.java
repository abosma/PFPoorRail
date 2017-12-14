package Actions;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Extensions.HasObjectType;
import Extensions.StringExtension;
import Factories.RailwayFactory;
import Factories.TrainFactory;
import Model.IItem;
import Model.RichRail;
import Model.Train;

public class ActionController {
	
	public void addTrain(JTextField _textField)
    {
        String train = _textField.getText();
        if (StringExtension.stringIsNullOrEmpty(train))
            return;
        RailwayFactory factory = new TrainFactory();
        IItem t = factory.createTrain(train);
        RichRail.getInstance().addItem(t);
    }
	
	public void addWagon(JTextField _textField, String selectedTrain) {
		String wagon = _textField.getText();
        if (StringExtension.stringIsNullOrEmpty(wagon))
            return;
        TrainFactory factory = new TrainFactory();
        for(IItem i : RichRail.getInstance().getAllItems()) {
        	if(i.getName().equals(selectedTrain)) {
        		((Train) i).addWagon(factory.createWagon(wagon, 10));
        	}
        }
	}
	
	public void removeWagon(String selectedTrain, String selectedWagon) {
		for(IItem i : RichRail.getInstance().getAllItems()) {
        	if(i.getName().equals(selectedTrain)) {
        		for(IItem wagon : ((Train) i).getWagons()) {
        			((Train) i).removeWagon(wagon);
        			return;
        		}
        	}
		}
	}
	
	public void removeTrain(String selectedTrain) {
		for(IItem i : RichRail.getInstance().getAllItems()) {
        	if(i.getName().equals(selectedTrain)) {
        		RichRail.getInstance().removeItem(i);
        		return;
        	}
		}
	}
	
	public void updateComboBoxes(JComboBox cbAllTrains, JComboBox cbAllWagons) {
		
		ArrayList<IItem> items = RichRail.getInstance().getAllItems();
		ArrayList<String> wagonNames = new ArrayList<String>();
		
		for(IItem item : items)
        {
			if(item.getName().equals(cbAllTrains.getSelectedItem())) {
				for(IItem i : ((Train) item).getWagons()) {
					wagonNames.add(i.getName());
				}
				
				cbAllWagons.setModel(new DefaultComboBoxModel(wagonNames.toArray()));
	        }
        }
	}
	
}
