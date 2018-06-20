package Business;

import java.util.ArrayList;

import DTO.Vehicle;
import Data.VehicleDAO;
import Data.VehicleList;

public class Garage {
	private VehicleDAO list;

	public void addVehicle(Vehicle vehicle){
		list.addVehicle(vehicle);
	}

	public Garage() {
		list = new VehicleList();
	}	
	
	public ArrayList<Vehicle> getVehicleList(){
		return list.getVehicleList();
	}
	public void delVehicle(Vehicle vehicle) {
		list.removeVehicle(vehicle);
	}
	
}