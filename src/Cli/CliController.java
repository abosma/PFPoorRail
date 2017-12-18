package Cli;
import Cli.Logic.CliParser;
import Cli.Logic.IParser;

import javax.swing.*;

public class CliController extends JFrame
{
    public CliController(String title)
    {
        super();
        IParser parser = new CliParser();

        setTitle(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(800, 800);

        add(new CliPanel(parser));
    }
}
