package Business;

import DTO.Vehicle;

/**
 * Car class contains the car definition
 * 
 */
public class Car extends Vehicle {
	private int doorAmount;

	/**
	 * Constructor
	 */
	public Car(String type, String brand, String model, double originalPrice, int hp, int consumption, int mileage,
			String color, int doorAmount) {
		super(type, brand, model, originalPrice, hp, consumption, mileage, color);
		this.doorAmount = doorAmount;
	}

	public double getCalculatedPrice() {
		double price = this.getOriginalPrice();
		int numberOfDeduction= mileage / 10000;
		price = price- (numberOfDeduction * (price/100*5));
		return price < 0 ? 0 : price;
	}

	public int getDoorAmount() {
		return doorAmount;
	}

	public void setDoorAmount(int doorAmount) {
		this.doorAmount = doorAmount;
	}
}
