package Business;

import java.util.ArrayList;

import DTO.Vehicle;

public class Garage {
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public void addVehicle(Vehicle vehicle){
		vehicleList.add(vehicle);
	}
	
}
