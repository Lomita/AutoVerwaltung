import java.util.ArrayList;

/**
 * Vehicle class
 * @author Miruku
 * contains the vehicle definition
 */
public class Vehicle 
{	
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private float price;
	
	protected String type;
	protected String brand;
	protected String model;
	protected int hp;
	protected int consumption;
	protected int km;
	protected int doorAmount;
	
	/**
	 * Constructor
	 */
	public Vehicle()
	{
		
	}
	
	
	/**
	 * get the original price
	 * @return returns the original price 
	 */
	protected float getOriginalPrice()
	{
	return price;
	}
}
