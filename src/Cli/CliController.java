package Cli;
import javax.swing.*;

public class CliController extends JFrame
{
    public CliController(String title)
    {
        super();
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(800, 800);

        add(new CliPanel());
    }
}
