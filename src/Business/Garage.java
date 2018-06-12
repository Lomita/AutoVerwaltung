package Business;

import java.util.ArrayList;

import DTO.Vehicle;
import Data.VehicleDAO;

public class Garage {
	VehicleDAO list = new VehicleList();

	public void addVehicle(Vehicle vehicle){
		list.addVehicle(vehicle);
	}
	
	
}