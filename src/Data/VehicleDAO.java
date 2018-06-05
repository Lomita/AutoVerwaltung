package Data;
import DTO.Vehicle;
import java.util.ArrayList;

public interface VehicleDAO 
{
	public ArrayList<Vehicle> getVehicleList();
	public void addVehicle(Vehicle vehicle);
	public void removeVehicle(Vehicle vehicle);
}
