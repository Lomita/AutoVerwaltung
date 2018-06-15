package Business;

import java.util.ArrayList;

import DTO.Vehicle;
import Data.VehicleDAO;
import Data.VehicleList;

public class Garage {
	VehicleDAO list;

	public Garage() {
		VehicleDAO list = new VehicleList();
	}
	
	public void addVehicle(Vehicle vehicle){
		list.addVehicle(vehicle);
	}
	
	public ArrayList<Vehicle> getVehicleList(){
		return list.getVehicleList();
	}

	public void delVehicle(Vehicle vehicle) {
		list.removeVehicle(vehicle);
	}
}