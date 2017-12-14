package controller;

import Model.RichRail;

public abstract class Observer {
	protected RichRail rr;
	public abstract void update();
}
