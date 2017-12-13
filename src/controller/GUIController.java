package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class GUIController extends javax.swing.JFrame implements ActionListener {

	private JPanel jPanel1;
	private JPanel pnlWagons;
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
			tpTextTrain.setText("Train name:");
			tpTextTrain.setEditable(false);
			
			jPanel2.add(tpTextTrain, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel2.setBounds(10, 10, 100, 15);
			jPanel2Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel2Layout.rowHeights = new int[] {7, 7, 7, 7};
			jPanel2Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel2Layout.columnWidths = new int[] {7, 7, 7, 7};
			
			tfNewTrain = new JTextField(20);
			jPanel2.add(tfNewTrain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			
			JButton createTrain = createButton(2, 0, 1, 1, jPanel2, "Create Train");
			createTrain.addActionListener(a -> 
				System.out.println("test")
			);
			
			JComboBox cbAllTrains = createComboBox(1, 1, 1, 2, jPanel2);
			cbAllTrains.addActionListener(a -> 
				System.out.println("Test")
			);
			
			JButton deleteTrain = createButton(2, 2, 1, 1, jPanel2, "Delete Train");
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
			
			JTextField tfNewWagon = new JTextField(20);
			pnlWagons.add(tfNewWagon, new GridBagConstraints(1, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			
			JTextPane tfCreateWagon = new JTextPane();
			pnlWagons.add(tfCreateWagon, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			tfCreateWagon.setText("Wagon Name: ");
			tfCreateWagon.setEditable(false);
			
			JButton addWagon = createButton(1, 1, 1, 1, pnlWagons,"Add Wagon");
			addWagon.addActionListener(a -> 
				System.out.println("Test")
			);
			
			JComboBox cbAllWagons = createComboBox(1, 2, 1, 2, pnlWagons);
			cbAllWagons.addActionListener(a -> 
				System.out.println("Test")
			);
			
			
			JButton deleteWagon = createButton(1, 3, 1, 1, pnlWagons, "Delete Wagon");
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
