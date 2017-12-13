package Actions;

import Extensions.StringExtension;
import Factories.RailwayFactory;
import Factories.TrainFactory;
import Model.RichRail;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class NewTrainAction implements Action
{
    private JTextField _textField;

    public NewTrainAction(JTextField textField)
    {
        _textField = textField;
    }

    @Override
    public Object getValue(String key)
    {
        return null;
    }

    @Override
    public void putValue(String key, Object value)
    {

    }

    @Override
    public void setEnabled(boolean b)
    {

    }

    @Override
    public boolean isEnabled()
    {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String train = _textField.getText();
        if (!StringExtension.stringIsNullOrEmpty(train))
            return;
        RailwayFactory factory = new TrainFactory();
        RichRail.getInstance().addItem(factory.createTrain(train));
    }
}
