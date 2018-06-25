package Business;
import DTO.Vehicle;

/**
  * Motorbike class
  * @author Miruku
  * contains the motorbike definition
  */
public class Motorbike extends Vehicle
{
	private double weight;
	
	/**
	 * Constructor
	 */
	public Motorbike(String type, String brand, String model, double originalPrice, int hp, double consumption, int mileage,
			String color, double weight) {
		super(type, brand, model, originalPrice, hp, consumption, mileage, color);
		this.weight = weight;
	}
	
	/**
	 *  calculates the effective price 
	 * @return returns the effective price 
	 */
	public double getCalculatedPrice()
	{	
		double price = this.getOriginalPrice();
		int numberOfDeduction= mileage / 10000;
		price = price- (numberOfDeduction * (price/100*5));
		return price < 0 ? 0 : price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public double getGroundClearance() {
		return 0;
	}

	@Override
	public int getDoorAmount() {
		return 0;
	}
}
