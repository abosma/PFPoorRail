package Model;

import java.util.*;

public class RichRail {

	public ArrayList<Train> alltrains = new ArrayList<Train>();

	public ArrayList<Train> getAllTrains() {
		return alltrains;
	}

	public void setAllTrainsInit(ArrayList<Train> at) {
		alltrains = at;
	}

	public void addTrainToStation(Train tr) {
		alltrains.add(tr);
	}
	
	public int getIDlastTrain(){
		Train e = alltrains.get(alltrains.size() - 1);
		return e.getId();
	}

}
