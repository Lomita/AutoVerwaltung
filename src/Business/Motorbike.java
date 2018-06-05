package Business;
import DTO.Vehicle;

/**
  * Motorbike class
  * @author Miruku
  * contains the motorbike definition
  */
public class Motorbike extends Vehicle
{
	/**
	 * Constructor
	 */
	public Motorbike()
	{
	
	
	}
	
	/**
	 *  calculates the effective price 
	 * @return returns the effective price 
	 */
	protected float getCalculatedPrice()
	{	
		float price;
		price = this.getOriginalPrice();
		return price;
	}
}
