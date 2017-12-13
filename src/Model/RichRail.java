package Model;

import java.util.*;

public class RichRail {

	private static RichRail _instance;

	public static RichRail getInstance()
	{
		if(_instance == null)
			_instance = new RichRail();

		return _instance;
	}


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
