package Cli.Logic;

import Actions.ActionController;
import Extensions.ArrayExtensions;
import Extensions.IntExtensions;

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
        String[] values = command.toLowerCase().split(" ");
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
            case "delete":
                Delete(data);
                break;
            case "remove":
                Remove(data);
                break;
        }

        _textArea.append(command);
    }

    private void New(String[] values)
    {
        if(values.length < 2)
            return;

        switch (values[0])
        {
            case "train":
                _action.addTrain(values[0]);
                break;
            case "wagon":
                if(!IntExtensions.IsInt(values[1]))
                    return;

                _action.addWagon(values[0],Integer.parseInt(values[1]));
                break;
        }
    }

    private void Delete(String[] splitted)
    {
        if(splitted.length < 2)
            return;

        switch (splitted[0])
        {
            case "train":
                _action.removeTrain(splitted[1]);
                break;
            case "wagon":
                _action.Remove(splitted[1]);
                break;
        }
    }

    private void Remove(String[] splitted)
    {
        _action.removeWagon(splitted[0],splitted[1]);
    }

    private void AddTrain(String[] values)
    {
        if(values.length < 2)
            return;

        if(!IntExtensions.IsInt(values[1]))
            return;

        _action.addWagon(values[0],Integer.parseInt(values[1]));
    }
}
