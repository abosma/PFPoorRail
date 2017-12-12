package Model;

import Dao.TrainDao;

public class Main {

	public static void main(String[] args) {
		TrainDao dao = new TrainDao();

		RichRail s1 = new RichRail() ;
		 
//		 Component c1 = new Wagon(1, 1);
//		 Component c2 = new Wagon(2, 2);
//		 t1.addWagon(c1);
//		 t1.addWagon(c2);
		 
		 
		 s1.setAllTrainsInit(dao.deserializeTrains());
		 
//		 dao.addTrain(s1,t2);
		 Train t4 = new Train("Ronald", dao.getLastId());
		 dao.addTrain(s1,t4);

		for (Train t : s1.getAllTrains()) {
			System.out.println(t.getId());

		}

	}

}
