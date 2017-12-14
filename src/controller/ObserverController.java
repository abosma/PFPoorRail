package controller;

import java.awt.Graphics;

import javax.swing.JComboBox;

import Model.RichRail;
import javafx.scene.control.ComboBox;

public class ObserverController {
	public ObserverController(Graphics _graphics, JComboBox cbAllTrains) {
		ChangeObserver co = new ChangeObserver(RichRail.getInstance(), _graphics, cbAllTrains);
		RichRail.getInstance().attach(co);
	}
}
