import java.util.ArrayList;

import Business.Car;
import Business.Garage;
import Business.Quad;
import DTO.Vehicle;
import Data.VehicleDAO;
import Prestentation.ClientController;

/**
 * Launch class
 * @author Miruku
 * starts the programm
 */
public class Launch 
{
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ClientController infa = new ClientController();
		
//		Testing:
//		Garage garage=new Garage();
//		Vehicle vehicle=new Car("Car", "BMW", "X1", 50000, 300, 6, 58000, "Blue", 5);
//		garage.addVehicle(vehicle);
//		Vehicle vehicle2=new Quad("Quad", "Honda", "asdf", 30000, 200, 5, 58000, "Red", 600);
//		garage.addVehicle(vehicle2);
//
//		ArrayList<Vehicle> list=garage.getVehicleList();
//		for (Vehicle v : list) {
//			System.out.println(v);
//		}
	}
}
