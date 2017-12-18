package controller;

import Actions.ActionFacade;
import Actions.CloseAction;
import Dao.Factories.DatabaseFactory;
import Dao.Factories.DatabaseFactoryBase;
import Dao.IDao;
import Dao.TrainDao;
import Core.RichRail;
import Observers.ObserverController;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class GUIController extends javax.swing.JFrame implements ActionListener
{
	private JComboBox _trainSelect;
	private JComboBox _wagonSelect;
	
	public GUIController(String title)
	{
		super();
		setTitle(title);
		initGUI();
		DatabaseFactoryBase dbFactory = new DatabaseFactory();
		IDao doa = dbFactory.GetDoa();
		RichRail.getInstance().setAllItems(doa.GetAll());
	}
	
	private void initGUI() 
	{
		try 
		{
			ActionFacade ac = new ActionFacade();
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
			mainPanel.add(drawPanel);

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
			{
				if (!ac.addTrain(tfNewTrain.getText()))
					System.out.println("Trein bestaat al");
			});
			
			
			_trainSelect = createComboBox(1, 1, 1, 2, trainPanel);
			_trainSelect.addActionListener(a ->
				ac.updateComboBoxes(_trainSelect, _wagonSelect)
			);

			JButton deleteTrain = createButton(2, 2, 1, 1, trainPanel, "Delete Train");
			deleteTrain.addActionListener(a -> 
				ac.removeTrain((String) _trainSelect.getSelectedItem())
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
				ac.addWagon(tfNewWagon.getText(), (String) _trainSelect.getSelectedItem())
			);
			
			_wagonSelect = createComboBox(1, 2, 1, 2, wagonPanel);
			_wagonSelect.addActionListener(a ->
				ac.updateComboBoxes(_trainSelect, _wagonSelect)
			);
			
			
			JButton deleteWagon = createButton(1, 3, 1, 1, wagonPanel, "Delete Wagon");
			deleteWagon.addActionListener(a -> 
				ac.RemoveWagon((String) _trainSelect.getSelectedItem(),(String)_wagonSelect.getSelectedItem())
			);
			
			JFrame.getFrames()[0].addWindowListener(new CloseAction());

			pack();
			setSize(800, 800);
			
			new ObserverController(drawPanel, _trainSelect, _wagonSelect);

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
