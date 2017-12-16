package Observers;

import Core.RichRail;

public abstract class Observer
{
	protected RichRail rr;
	public abstract void update();
}