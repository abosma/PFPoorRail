package Actions;

import java.util.ArrayList;

import javax.swing.JTextField;

import Extensions.HasObjectType;
import Extensions.StringExtension;
import Factories.RailwayFactory;
import Factories.TrainFactory;
import Model.IItem;
import Model.RichRail;

public class ActionController {
	
	public void addTrain(JTextField _textField)
    {
        String train = _textField.getText();
        if (StringExtension.stringIsNullOrEmpty(train))
            return;
        RailwayFactory factory = new TrainFactory();
        RichRail.getInstance().addItem(factory.createTrain(train));
    }
	
	public void addWagon(JTextField _textField) {
		if(HasObjectType.hasTrain()) {
			String wagon = _textField.getText();
	        if (StringExtension.stringIsNullOrEmpty(wagon))
	            return;
	        TrainFactory factory = new TrainFactory();
	        RichRail.getInstance().addItem(factory.createWagon(wagon, 10));
		}else {
			return;
		}
	}
}
