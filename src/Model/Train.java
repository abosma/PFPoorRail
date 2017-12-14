package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.*;

public class Train implements Serializable, IItem {

	private int _id;
	private String _name;
	private ArrayList<IItem> allWagons = new ArrayList<IItem>();

	public Train(String name, int id) {
		this._name = name;
		this._id = id;
	}

	public void addWagon(IItem w) {
		allWagons.add(w);
		RichRail.getInstance().notifyAllObservers();
	}

	public String getName() {
		return _name;
	}

	public int getId() {
		return _id;
	}

	public ArrayList<IItem> getWagons() {
		return allWagons;
	}

	public void setWagons(ArrayList<IItem> wag) {
		allWagons = wag;
		RichRail.getInstance().notifyAllObservers();
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(30, 80 + _id * 100, 80, 40);
		graphics.fillRect(80, 60 + _id * 100, 30, 30);
		graphics.drawRoundRect(85, 40 + _id * 100, 20, 20, 20, 20);
		graphics.drawRoundRect(85, _id * 100, 40, 40, 40, 40);
		graphics.setColor(Color.BLACK);
		graphics.fillRoundRect(35, 120 + _id * 100, 20, 20, 20, 20);
		graphics.fillRoundRect(80, 120 + _id * 100, 20, 20, 20, 20);
		graphics.drawString(_name, 40, 105 + _id * 100);
	}
}