package controller;

import java.awt.Graphics;

import Model.RichRail;

public class ObserverController {
	public ObserverController(Graphics _graphics) {
		ChangeObserver co = new ChangeObserver(RichRail.getInstance(), _graphics);
		RichRail.getInstance().attach(co);
	}
}
