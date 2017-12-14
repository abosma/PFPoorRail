package controller;

import java.awt.Graphics;

import Model.RichRail;

public class ChangeObserver extends Observer {

	private Graphics _graphics;
	
	public ChangeObserver(RichRail rr, Graphics _graphics) {
		this.rr = rr;
		this.rr.attach(this);
		this._graphics = _graphics;
	}
	
	@Override
	public void update() {
		DrawController dc = new DrawController(_graphics);
		dc.draw();
	}

}
