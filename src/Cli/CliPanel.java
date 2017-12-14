package Cli;

import Cli.Logic.CliParser;
import controller.ObserverController;

import javax.swing.*;
import java.awt.*;

public class CliPanel extends JPanel
{
    private CliParser _cliParser;
    private JTextField _input;
    private JTextArea _textArea;

    public CliPanel()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints constrains = new GridBagConstraints();

        constrains.fill = GridBagConstraints.HORIZONTAL;
        constrains.gridy = 0;
        constrains.gridx = 0;
        CreateDrawPanel(constrains);
        constrains.gridy++;
        createTextArea(constrains);
        _cliParser = new CliParser(_textArea);
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

        new ObserverController(drawPanel, null, null);
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
