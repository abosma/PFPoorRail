package Model;

import Dao.TrainDao;

public class Main {
	

	public static void main(String[] args) {
		TrainDao dao = new TrainDao();
		
		
		Train t1 = new Train("Ronald");
		
		Component c1 = new Component(1, 1);
		Component c2 = new Component(2, 2);
		
		
		t1.addWagon(c1);
		t1.addWagon(c2);
		
		dao.addTrain(t1);
		
	}

}
