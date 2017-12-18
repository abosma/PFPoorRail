package Observers;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Core.RichRail;

public class ObserverController {
	public ObserverController(JPanel drawPanel, JComboBox<String> _trainSelect, JComboBox<String> _wagonSelect) {
		new ChangeObserver(RichRail.getInstance(), drawPanel);
		new TrainCBObserver(RichRail.getInstance(), _trainSelect);
		new WagonCBObserver(RichRail.getInstance(), _trainSelect, _wagonSelect);
	}
}
