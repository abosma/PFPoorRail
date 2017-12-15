import Cli.CliController;
import controller.GUIController;

import javax.swing.*;

import Model.Train;

public class Main
{
    /**
     * On application start
     * @param args event args
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            JFrame inst = new CliController("RichRail cli");
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
        });

        SwingUtilities.invokeLater(() ->
        {
            GUIController inst = new GUIController("RichRail");
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
        });


    }
}
