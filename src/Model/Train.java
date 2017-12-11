package Model;

import java.util.*;

public class Train {
	private String name;
	private int id;
	private ArrayList<Component> allWagons = new ArrayList<Component>();
	
	public Train (String nametrain){
		name = nametrain;
	}

	public void addWagon(Component w){
		allWagons.add(w);
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Component> getWagons(){
		return allWagons;
	}
}

