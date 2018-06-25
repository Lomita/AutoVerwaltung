package DTO;

/**
 * Vehicle class
 * @author Samuel
 * contains the vehicle definition
 */
public abstract class Vehicle {
	protected String type;
	protected String brand;
	protected String model;
	protected double originalPrice;
	protected int hp;
	protected double consumption;
	protected int mileage;
	protected String color;

	/**
	 * Constructor
	 */
	public Vehicle(String type, String brand, String model, double originalPrice, int hp, double consumption, int mileage,
			String color) {
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.originalPrice = originalPrice;
		this.hp = hp;
		this.consumption = consumption;
		this.mileage = mileage;
		this.color = color;
	}

	public abstract  double getWeight();
	public abstract double getGroundClearance();
	public abstract int getDoorAmount();
	
	public String getType() {
		return type;
	}

	/**
	 *  get brand
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * get hp
	 * @return hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * get consumption
	 * @return consumption
	 */
	public double getConsumption() {
		return consumption;
	}

	/**
	 * get mileage
	 * @return mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * get color
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * get model
	 * @return model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * get the original price
	 * @return returns the original price
	 */
	protected double getOriginalPrice() {
		return this.originalPrice;
	}
	
	/**
	 * Return the calculated price
	 * @return
	 */
	public abstract double getCalculatedPrice();
}
