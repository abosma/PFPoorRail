package Observers;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Core.RichRail;

public class ObserverController
{
	public ObserverController(JPanel drawPanel, JComboBox<String> cbAllTrains, JComboBox<String> cbAllWagons)
	{
		new ChangeObserver(RichRail.getInstance(), drawPanel);
		new TrainCBObserver(RichRail.getInstance(), cbAllTrains);
		new WagonCBObserver(RichRail.getInstance(), cbAllTrains, cbAllWagons);
	}
}