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
            GUIController inst = new GUIController();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
        });
    }
}
