package Model;

import Dao.TrainDao;

public class Main {
	

	public static void main(String[] args) {
		TrainDao dao = new TrainDao();
		
		Station s1 = new Station("Station1");
		
		Train t1 = new Train("Ronald");
		
		Component c1 = new Component(1, 1);
		Component c2 = new Component(2, 2);
		
		t1.addWagon(c1);
		t1.addWagon(c2);
		
		dao.addTrain(s1,t1);

		
		
	Train t2 = new Train("R");
		
		
		t2.addWagon(c1);
		t2.addWagon(c2);
		
		dao.addTrain(s1,t2);
		
		for (Train t: dao.deserializeTrains()) {
			System.out.println(t.getName());
			
		}
		
	}

}
