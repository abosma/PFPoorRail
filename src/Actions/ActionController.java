package Actions;

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
	
}
