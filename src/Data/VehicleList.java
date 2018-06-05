package Data;

import java.util.ArrayList;

public class VehicleList implements VehicleDAO{
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	protected ArrayList<Vehicle> getVehicleList(){
		return vehicleList;
	}
	protected void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}
	protected void removeVehicle(Vehicle vehicle) {
		vehicleList.remove(vehicle);
	}
	
}
