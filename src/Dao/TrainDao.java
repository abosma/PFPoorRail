package Dao;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import Model.RichRail;
import Model.Train;

public class TrainDao {

	File logFile = new File("all_trains");
	ArrayList<Train> alltrains = new ArrayList<Train>();

	// Call deserializeTrains on initialization program
	@SuppressWarnings("unchecked")
	public ArrayList<Train> deserializeTrains() {
		ArrayList<Train> trains = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(logFile));
			trains = (ArrayList<Train>) in.readObject();
			in.close();
		} catch (Exception e) {
		}
		return trains;
	}
	// Each time a train gets added overwrite logFile
	public void addTrain(RichRail ri, Train tr) {

		//alltrains = ri.getAllItems();
		//ri.addItem(it);;

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

	@SuppressWarnings("unchecked")
	public int getLastId() {
		ArrayList<Train> trains = null;
		Train lasttrain = null;

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(logFile));
			trains = (ArrayList<Train>) in.readObject();
			in.close();

			lasttrain = trains.get(trains.size() - 1);
			System.out.println(lasttrain.getName());
			return lasttrain.getId() + 1;
		} catch (Exception e) {
			return 0;
		}

	}

}
