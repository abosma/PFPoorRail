package Actions;

import java.util.ArrayList;

import javax.swing.JTextField;

import Dao.TrainDao;
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
        RichRail.getInstance().addItem(factory.createTrain(train));
    }
	
	public void addWagon(JTextField _textField, String selectedTrain) {
		if(HasObjectType.hasTrain()) {
			String wagon = _textField.getText();
	        if (StringExtension.stringIsNullOrEmpty(wagon))
	            return;
	        TrainFactory factory = new TrainFactory();
	        for(IItem i : RichRail.getInstance().getAllItems()) {
	        	if(i.getName().equals(selectedTrain)) {
	        		((Train) i).addWagon(factory.createWagon(wagon, 10));
	        	}
	        }
		}else {
			return;
		}
	}
}
