package Business;

import java.util.ArrayList;

import DTO.Vehicle;
import Data.VehicleDAO;
import Data.VehicleList;
/**
 * Garage Class handles the vehicles 
 * @author samue
 *
 */
public class Garage {
	private VehicleDAO list;
	/**
	 * Adding a vehicle to List
	 * @param vehicle
	 */
	public void addVehicle(Vehicle vehicle){
		list.addVehicle(vehicle);
	}

	public Garage() {
		list = new VehicleList();
	}	
	/**
	 * Returns the list of all vehicles
	 * @return
	 */
	public ArrayList<Vehicle> getVehicleList(){
		return list.getVehicleList();
	}
	/**
	 * Returns the Vehicle from the List with its index
	 * @param index
	 * @return
	 */
	public Vehicle getVehicleObjFromListByID(int index)
	{
		ArrayList<Vehicle> vehicleList = list.getVehicleList();
		return vehicleList.get(index);
		
	}
	/**
	 * Deletes a vehicle by its index
	 * @param index
	 */
	public void delVehicleByIndex(int index) {
		ArrayList<Vehicle> vehicleList = list.getVehicleList();
		list.removeVehicle(vehicleList.get(index));
	}
}