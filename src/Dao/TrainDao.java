package Dao;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import Model.IItem;
import Model.RichRail;
import Model.Train;

public class TrainDao {

	private static TrainDao _instance;

	public static TrainDao getInstance() {
		if (_instance == null)
			_instance = new TrainDao();

		return _instance;
	}

	File logFile = new File("all_trains");
	ArrayList<IItem> alltrains = new ArrayList<IItem>();

	 // Call deserializeTrains on initialization program
	@SuppressWarnings("unchecked")
	public ArrayList<IItem> deserializeTrains() {
		ArrayList<IItem> trains = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(logFile));
			trains = (ArrayList<IItem>) in.readObject();
			in.close();
		} catch (Exception e) {
		}
		return trains;
	}

	// Each time a train gets added overwrite logFile
	public void addTrain(RichRail ri, IItem tr) {

		alltrains.add(tr);

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
