package Model;

import java.util.*;

public class Station {
	public String name;
	public ArrayList<Train> alltrains = new ArrayList<Train>();
	
	public Station(String na){
		name = na;
	}
	
	public ArrayList<Train> getAllTrains(){
		return alltrains;
	}
	
	public void addTrainToStation(Train tr){
		alltrains.add(tr);
	}

}
