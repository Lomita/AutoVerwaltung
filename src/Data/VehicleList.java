package Data;
import DTO.Vehicle;
import java.util.ArrayList;

public class VehicleList implements VehicleDAO{
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public ArrayList<Vehicle> getVehicleList(){
		return vehicleList;
	}
	public void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}
	public void removeVehicle(Vehicle vehicle) {
		vehicleList.remove(vehicle);
	}
	
}
