
package controller;

import java.awt.Graphics;
import Model.ObserverValues;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Model.RichRail;

public class ObserverController
{
	public ObserverController(JPanel drawPanel, ObserverValues cbAllTrains, JComboBox<String> cbAllWagons)
	{
		new ChangeObserver(RichRail.getInstance(), drawPanel);
		new TrainCBObserver(RichRail.getInstance(), cbAllTrains);
		new WagonCBObserver(RichRail.getInstance(), cbAllWagons);
	}
}