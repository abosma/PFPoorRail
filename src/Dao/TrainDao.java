package Dao;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Station;
import Model.Train;

public class TrainDao  {

	File logFile = new File("all_trains");
	ArrayList<Train> alltrains = new ArrayList<Train>();

	
	//Call deserializeTrains on initialization program
	@SuppressWarnings("unchecked")
	public ArrayList<Train> deserializeTrains() {
		ArrayList<Train> trains = null;
	    try {
	        ObjectInputStream in = new ObjectInputStream(new FileInputStream(logFile));
	        trains = (ArrayList<Train>) in.readObject(); 
	        in.close();
	    }
	    catch(Exception e) {}
	    return trains;
	}

	//Each time a train gets added overwrite logFile
	public void addTrain (Station station,Train tr) {

		alltrains =  station.getAllTrains();
		station.addTrainToStation(tr);

		System.out.println(alltrains.size());
		
		try {
			
			FileOutputStream fileOut = new FileOutputStream(logFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(alltrains);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

}
