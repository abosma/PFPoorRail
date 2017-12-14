
package controller;

import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Model.RichRail;

public class ObserverController {
	public ObserverController(JPanel drawPanel, JComboBox<String> cbAllTrains, JComboBox<String> cbAllWagons) {
		new ChangeObserver(RichRail.getInstance(), drawPanel);
		new TrainCBObserver(RichRail.getInstance(), cbAllTrains);
		new WagonCBObserver(RichRail.getInstance(), cbAllWagons, (String) cbAllTrains.getSelectedItem());
	}
}

