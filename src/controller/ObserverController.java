package controller;

import java.awt.Graphics;

import javax.swing.JComboBox;

import Model.RichRail;

public class ObserverController {
	public ObserverController(Graphics _graphics, JComboBox<String> cbAllTrains, JComboBox<String> cbAllWagons) {
		new ChangeObserver(RichRail.getInstance(), _graphics);
		new TrainCBObserver(RichRail.getInstance(), cbAllTrains);
		new WagonCBObserver(RichRail.getInstance(), cbAllTrains, cbAllWagons);
	}
}
