package controller;

import Actions.NewTrainAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class GUIController extends javax.swing.JFrame implements ActionListener {

	private JPanel jPanel1;
	private JPanel pnlWagons;
	private JTextField tfCurrentTrain;
	private JTextField tfNewTrain;
	private JPanel jPanel2;
	private JPanel drawPanel;
	
	public GUIController() 
	{
		super();
		initGUI();
	}
	
	private void initGUI() 
	{
		try 
		{
			this.setTitle("RichRail");
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			thisLayout.rowHeights = new int[] {7, 7, 7, 7};
			thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			thisLayout.columnWidths = new int[] {7, 7, 7, 7};
			getContentPane().setLayout(thisLayout);
			
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BorderLayout());
			getContentPane().add(jPanel1, new GridBagConstraints(0, 0, 4, 2, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			
			drawPanel = new JPanel();
			drawPanel.setBackground(Color.WHITE);
			jPanel1.add(drawPanel,BorderLayout.CENTER);

			jPanel2 = new JPanel();
			GridBagLayout jPanel2Layout = new GridBagLayout();
			jPanel2.setLayout(jPanel2Layout);
			getContentPane().add(jPanel2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			
			JTextPane tpTextTrain = new JTextPane();
			jPanel2.add(tpTextTrain, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel2.setBounds(10, 10, 100, 15);
			jPanel2Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel2Layout.rowHeights = new int[] {7, 7, 7, 7};
			jPanel2Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel2Layout.columnWidths = new int[] {7, 7, 7, 7};
			tpTextTrain.setText("train name:");
			
			tfNewTrain = new JTextField(20);
			jPanel2.add(tfNewTrain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

			Action createAction = new NewTrainAction(tfNewTrain);
			JButton createTrain = createButton(2, 0, 1, 1, jPanel2, "Create Train",createAction);
			createTrain.addActionListener(a -> 
				System.out.println("Test")
			);
			
			ComboBoxModel cbAllTrainsModel = new DefaultComboBoxModel(new String[] {});
			JComboBox cbAllTrains = new JComboBox();
			jPanel2.add(cbAllTrains, new GridBagConstraints(1, 1, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			cbAllTrains.setModel(cbAllTrainsModel);
			cbAllTrains.addActionListener(a -> 
				System.out.println("Test")
			);

			Action deleteTrainAction = new NewTrainAction(tfNewTrain);
			JButton deleteTrain = createButton(2, 2, 1, 1, jPanel2, "Delete Train",deleteTrainAction);
			deleteTrain.addActionListener(a -> 
				System.out.println("Test")
			);

			pnlWagons = new JPanel();
			GridBagLayout jPanel3Layout = new GridBagLayout();
			getContentPane().add(pnlWagons, new GridBagConstraints(1, 2, 2, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7};
			jPanel3Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel3Layout.columnWidths = new int[] {7, 7, 7, 7};
			pnlWagons.setLayout(jPanel3Layout);
			pnlWagons.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			
			tfCurrentTrain = new JTextField();
			pnlWagons.add(tfCurrentTrain, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			tfCurrentTrain.setText("Selected: ");

			Action addAction = new NewTrainAction(tfNewTrain);
			JButton addWagon = createButton(1, 0, 1, 1, pnlWagons,"Add Wagon",addAction);
			addWagon.addActionListener(a -> 
				System.out.println("Test")
			);
			Action deleteAction = new NewTrainAction(tfNewTrain);
			JButton deleteWagon = createButton(1, 1, 1, 1, pnlWagons, "Delete Wagon",deleteAction);
			deleteWagon.addActionListener(a -> 
				System.out.println("Test")
			);
			pack();
			setSize(800, 600);
			new HashMap();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private JButton createButton(int x, int y, int width, int height, JPanel panel, String txt, Action action) {
		JButton tempButton = new JButton();
		tempButton.setText(txt);
		tempButton.setAction(action);
		panel.add(tempButton, new GridBagConstraints(x, y, width, height, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		return tempButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
