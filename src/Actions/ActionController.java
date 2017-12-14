package Actions;

import javax.swing.JTextField;

import Extensions.StringExtension;
import Factories.RailwayFactory;
import Factories.TrainFactory;
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
	
}
