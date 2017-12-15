package controller;

import Actions.ActionController;
import Dao.TrainDao;
import Model.RichRail;
import Model.Train;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class GUIController extends javax.swing.JFrame implements ActionListener
{
	public JComboBox cbAllTrains;
	public JComboBox cbAllWagons;
	
	public GUIController() 
	{
		super();
		initGUI();
		RichRail.getInstance().setAllItems(TrainDao.getInstance().deserializeTrains());
	}
	
	private void initGUI() 
	{
		try 
		{
			ActionController ac = new ActionController();
			
			this.setTitle("RichRail");
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			thisLayout.rowHeights = new int[] {7, 7, 7, 7};
			thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			thisLayout.columnWidths = new int[] {7, 7, 7, 7};
			getContentPane().setLayout(thisLayout);
			
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BorderLayout());
			getContentPane().add(mainPanel, new GridBagConstraints(0, 0, 4, 2, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			
			JPanel drawPanel = new JPanel();
//			drawPanel.setBackground(Color.WHITE);
			mainPanel.add(drawPanel,BorderLayout.CENTER);

			JPanel trainPanel = createJPanel(0, 2, 1, 1);
			
			JTextPane tpTextTrain = new JTextPane();
			tpTextTrain.setText("Train name:");
			tpTextTrain.setEditable(false);
			trainPanel.add(tpTextTrain, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			trainPanel.setBounds(10, 10, 100, 15);


			JTextField tfNewTrain = new JTextField(20);
			trainPanel.add(tfNewTrain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

			JButton addTrain = createButton(2, 0, 1, 1, trainPanel, "Create Train");
			addTrain.addActionListener(a -> 
				ac.addTrain(tfNewTrain.getText())
			);
			
			
			cbAllTrains = createComboBox(1, 1, 1, 2, trainPanel);
			cbAllTrains.addActionListener(a -> 
				ac.updateComboBoxes(cbAllTrains, cbAllWagons)
			);

			JButton deleteTrain = createButton(2, 2, 1, 1, trainPanel, "Delete Train");
			deleteTrain.addActionListener(a -> 
				ac.removeTrain((String) cbAllTrains.getSelectedItem())
			);

			JPanel wagonPanel = createJPanel(1, 2, 2, 3);
			wagonPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			
			JTextField tfNewWagon = new JTextField(20);
			wagonPanel.add(tfNewWagon, new GridBagConstraints(1, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

			JTextPane tfCreateWagon = new JTextPane();
			wagonPanel.add(tfCreateWagon, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			tfCreateWagon.setText("Wagon Name: ");
			tfCreateWagon.setEditable(false);
			
			JButton addWagon = createButton(1, 1, 1, 1, wagonPanel,"Add Wagon");
			addWagon.addActionListener(a -> 
				ac.addWagon(tfNewWagon.getText(), (String)cbAllTrains.getSelectedItem())
			);
			
			cbAllWagons = createComboBox(1, 2, 1, 2, wagonPanel);
			cbAllWagons.addActionListener(a -> 
				ac.updateComboBoxes(cbAllTrains, cbAllWagons)
			);
			
			
			JButton deleteWagon = createButton(1, 3, 1, 1, wagonPanel, "Delete Wagon");
			deleteWagon.addActionListener(a -> 
				ac.removeWagon((String)cbAllTrains.getSelectedItem(), (String)cbAllWagons.getSelectedItem())
			);
			
			JFrame.getFrames()[0].addWindowListener(new WindowListener() {
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowClosing(WindowEvent e) {
					TrainDao.getInstance().serializeItems();
				}

				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
			});

			pack();
			setSize(800, 800);
			
			new ObserverController(drawPanel, cbAllTrains, cbAllWagons);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private JButton createButton(int x, int y, int width, int height, JPanel panel, String txt) {
		JButton tempButton = new JButton();
		tempButton.setText(txt);
		panel.add(tempButton, new GridBagConstraints(x, y, width, height, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		return tempButton;
	}
	
	private JComboBox createComboBox(int x, int y, int width, int height, JPanel panel) {
		ComboBoxModel cbTempModel = new DefaultComboBoxModel(new String[] {});
		JComboBox cbTempComboBox = new JComboBox();
		panel.add(cbTempComboBox, new GridBagConstraints(x, y, width, height, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		cbTempComboBox.setModel(cbTempModel);
		return cbTempComboBox;
	}
	
	private JPanel createJPanel(int x, int y, int width, int height) {
		JPanel tempPanel = new JPanel();
		GridBagLayout tempLayout = new GridBagLayout();
		tempLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
		tempLayout.rowHeights = new int[] {7, 7, 7, 7};
		tempLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
		tempLayout.columnWidths = new int[] {7, 7, 7, 7};
		tempPanel.setLayout(tempLayout);
		getContentPane().add(tempPanel, new GridBagConstraints(x, y, width, height, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		return tempPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
