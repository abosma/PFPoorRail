package Model;

import java.io.Serializable;
import java.util.*;

public class Train implements Serializable {

	private int id;

	private String name;
	private ArrayList<Component> allWagons = new ArrayList<Component>();

	public Train(String nametrain, int idtrain) {
		name = nametrain;
		id = idtrain;
	}

	public void addWagon(Component w) {
		allWagons.add(w);
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Component> getWagons() {
		return allWagons;
	}

	public void setWagons(ArrayList<Component> wag) {
		allWagons = wag;
	}
}
