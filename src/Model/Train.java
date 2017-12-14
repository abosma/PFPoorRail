package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import javax.imageio.ImageIO;

public class Train implements Serializable, IItem {

	private int _id;
	private String _name;
	private ArrayList<IItem> allWagons = new ArrayList<IItem>();
	private transient BufferedImage img;

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

	public void removeWagon(IItem wag) {
		allWagons.remove(wag);
		RichRail.getInstance().notifyAllObservers();
	}

	public BufferedImage getImage() {
		try {
			img = ImageIO.read(new File("src/images/train.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
}