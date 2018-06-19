package Business;

import java.util.ArrayList;

import DTO.Vehicle;
import Data.VehicleDAO;
import Data.VehicleList;

public class Garage {
	VehicleDAO list;

	public void addVehicle(Vehicle vehicle){
		list.addVehicle(vehicle);
	}

	public Garage() {
		VehicleDAO list = new VehicleList();
	}	
}