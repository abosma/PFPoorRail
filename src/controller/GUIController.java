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
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class GUIController extends javax.swing.JFrame implements ActionListener {

	private JPanel jPanel1;
	private JTextPane tpTextTrain;
	private JButton jButton1;
	private JPanel pnlWagons;
	private JTextField tfCurrentTrain;
	private JButton btnDeleteTrain;
	private JTextField tfNewTrain;
	private JPanel jPanel2;
	private JPanel drawPanel;
	
	private HashMap numberOfWagons;
	private int currentNumberOfWagons;
	private int currentTrain = -1;
	private int OFFSET = 100;
	private int TRAINLENGTH = 100;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				GUIController inst = new GUIController();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
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
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(new BorderLayout());
				getContentPane().add(jPanel1, new GridBagConstraints(0, 0, 4, 2, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					drawPanel = new JPanel();
					drawPanel.setBackground(Color.WHITE);
					jPanel1.add(drawPanel,BorderLayout.CENTER);
				}
			}
			{
				jPanel2 = new JPanel();
				GridBagLayout jPanel2Layout = new GridBagLayout();
				jPanel2.setLayout(jPanel2Layout);
				getContentPane().add(jPanel2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					tpTextTrain = new JTextPane();
					jPanel2.add(tpTextTrain, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel2.setBounds(10, 10, 100, 15);
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7, 7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jPanel2Layout.columnWidths = new int[] {7, 7, 7, 7};
					tpTextTrain.setText("train name:");
				}
				{
					tfNewTrain = new JTextField(20);
					jPanel2.add(tfNewTrain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					
					JButton createTrain = createButton("Create Train");
					jPanel2.add(createTrain, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
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
				}
				{
					JButton deleteTrain = createButton("Delete Train");
					jPanel2.add(deleteTrain, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					deleteTrain.addActionListener(a -> 
						System.out.println("Test")
					);
				}
			}
			{
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
				
				JButton addWagon = createButton("Add Wagon");
				pnlWagons.add(addWagon, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				addWagon.addActionListener(a -> 
					System.out.println("Test")
				);
				
				JButton deleteWagon = createButton("Delete Wagon");
				pnlWagons.add(deleteWagon, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				deleteWagon.addActionListener(a -> 
					System.out.println("Test")
				);
			}
			pack();
			setSize(800, 600);
			numberOfWagons = new HashMap();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private JButton createButton(String txt) {
		JButton tempButton = new JButton();
		tempButton.setText(txt);
		return tempButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
