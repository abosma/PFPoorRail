import Cli.CliController;
import Dao.Factories.DatabaseFactory;
import Dao.Factories.DatabaseFactoryBase;
import controller.GUIController;

import javax.swing.*;

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

            GUIController gui = new GUIController("RichRail");
            gui.setLocationRelativeTo(null);
            gui.setVisible(true);
        });
    }
}
