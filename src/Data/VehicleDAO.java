package Data;
import DTO.Vehicle;
import java.util.ArrayList;

public interface VehicleDAO 
{
	/**
	 * Returns the Vehicle list
	 * @return
	 */
	public ArrayList<Vehicle> getVehicleList();
	/**
	 * Add a vehicle in list
	 * @param vehicle
	 */
	public void addVehicle(Vehicle vehicle);
	/**
	 * Delete a vehicle from list
	 * @param vehicle
	 */
	public void removeVehicle(Vehicle vehicle);
}
