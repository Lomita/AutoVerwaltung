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
	 *  calculates the effectiv price 
	 * @return returns the effectiv price 
	 */
	protected float getCalculatedPrice()
	{	
		return price;
	}
	
	/**
	 * get the original price
	 * @return returns the original price 
	 */
	protected float getOriginalPrice()
	{
	/*	float price;
		price = super.getCalculatedPrice();
	*/	return price;
	}
}
