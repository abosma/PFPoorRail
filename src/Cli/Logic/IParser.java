package Cli.Logic;

import javax.swing.*;

public interface IParser
{
    void OnCommand(String command);
    void SetTextField(JTextArea area);
}
