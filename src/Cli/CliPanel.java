package Cli;

import Cli.Logic.IParser;
import Core.RichRail;
import Observers.ChangeObserver;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class CliPanel extends JPanel
{
    private IParser _cliParser;
    private JTextField _input;
    private JTextArea _textArea;

    public CliPanel(IParser parser)
    {
        _cliParser = parser;
        setLayout(new GridBagLayout());
        GridBagConstraints constrains = new GridBagConstraints();
        constrains.gridy = 0;
        constrains.gridx = 0;
        constrains.fill = GridBagConstraints.HORIZONTAL;
        CreateDrawPanel(constrains);
        constrains.gridy++;
        createTextArea(constrains);
        parser.SetTextField(_textArea);
        constrains.gridy++;

        CreateInput( constrains);

        constrains.gridx = 0;
        constrains.gridy++;
        constrains.fill = GridBagConstraints.NONE;
        constrains.gridwidth = 2;

        CreateButton(constrains);
    }

    private void CreateDrawPanel( GridBagConstraints constrains)
    {
        JPanel drawPanel = new JPanel();
        drawPanel.setBackground(Color.WHITE);
        add(drawPanel, constrains);
        new ChangeObserver(RichRail.getInstance(), drawPanel);
    }

    private void CreateButton(GridBagConstraints constrains)
    {
        JButton button = new JButton("Click");
        button.addActionListener(x ->{
            _cliParser.OnCommand(_input.getText());
            _input.setText("");
        });
        add(button, constrains);
    }

    private void CreateInput(GridBagConstraints constrains)
    {
        _input = new JTextField("");
        add(_input,constrains);
    }

    private void createTextArea(GridBagConstraints constrains)
    {
        _textArea = new JTextArea();
        _textArea.setFont(new Font("Serif", Font.PLAIN, 16));
        _textArea.setLineWrap(true);
        _textArea.setWrapStyleWord(true);
        _textArea.setEditable(false);
        add(_textArea, constrains);
    }
}
