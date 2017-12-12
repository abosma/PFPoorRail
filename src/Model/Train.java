package Model;

import java.io.Serializable;
import java.util.*;

public class Train implements Serializable {
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
	
	public int getId(){
		return id;
	}
	
	
	public ArrayList<Component> getWagons(){
		return allWagons;
	}
}

