package Model;

import java.io.Serializable;

public abstract class Component implements Serializable, IRoll {
	private int number_of_seats,id;
	
	public Component(int seats, int co_id){
		number_of_seats = seats;
		id = co_id;
	}
	
	public int getSeats(){
		return number_of_seats;
	}
	
	public int getId(){
		return id;
	}
	

}
