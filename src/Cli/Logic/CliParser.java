package Cli.Logic;

import Actions.ActionController;
import Extensions.ArrayExtensions;
import Extensions.IntExtensions;
import Extensions.StringExtension;
import Model.IItem;
import Model.Wagon;

import javax.swing.*;

public class CliParser
{
    private JTextArea _textArea;
    private ActionController _action;

    public CliParser(JTextArea textArea)
    {
        _action = new ActionController();
        _textArea = textArea;
    }

    public void OnCommand(String command)
    {
        command = command.trim().toLowerCase();
        String[] values = StringExtension.Split(command," ",true);
        if(values.length == 0)
            return;

        String commandType = values[0];
        String[] data = ArrayExtensions.Skip(values,1);
        switch (commandType)
        {
            case "new":
                New(data);
                break;
            case "add":
                AddTrain(data);
                break;
            case "getnumseats":
                Get(data);
                break;
            case "delete":
                Delete(data);
                break;
            case "remove":
                Remove(data);
                break;
        }

        _textArea.append("\n"+command);
    }

    private void New(String[] values)
    {
        switch (values[0])
        {
            case "train":
                if(values.length < 2)
                    return;

                _action.addTrain(values[1]);
                break;
            case "wagon":
                if(values.length < 3)
                    return;

                if(!IntExtensions.IsInt(values[2]))
                    return;

                _action.addWagon(values[1],Integer.parseInt(values[2]));
                break;
        }
    }

    private void Delete(String[] values)
    {
        if(values.length < 2)
            return;

        switch (values[0])
        {
            case "train":
                _action.removeTrain(values[1]);
                break;
            case "wagon":
                _action.Remove(values[1]);
                break;
        }
    }

    private void Remove(String[] values)
    {
        if(values.length < 3)
            return;

        _action.RemoveAllWagons(values[0]);
    }

    private void Get(String[] values)
    {
        if(values.length < 2)
            return;
        IItem item = _action.GetItemByName(values[1]);
        switch (values[0])
        {
            case "wagon":
            {
                if(!(item instanceof Wagon))
                    return;

                _textArea.append("\nSeats = "+ ((Wagon)item).getSeats());
                break;
            }
        }
    }

    private void AddTrain(String[] values)
    {
        if(values.length < 2)
            return;

        String wagon = values[0];
        String train = values[2];

        _action.AssignWagonToTrain(train,wagon);
    }
}
