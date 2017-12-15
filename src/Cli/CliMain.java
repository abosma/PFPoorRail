package Cli;

import javax.swing.*;

public class CliMain
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            JFrame inst = new CliController("RichRail cli");
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
        });
    }
}
