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
	public Car(String type, String brand, String model, double originalPrice, int hp, double consumption, int mileage,
			String color, int doorAmount) {
		super(type, brand, model, originalPrice, hp, consumption, mileage, color);
		this.doorAmount = doorAmount;
	}

	public double getCalculatedPrice() {
		double price = this.getOriginalPrice();
		int numberOfDeduction= mileage / 10000;
		price = price- (numberOfDeduction * (price/100*3));
		return price < 0 ? 0 : price;
	}

	public int getDoorAmount() {
		return doorAmount;
	}

	public void setDoorAmount(int doorAmount) {
		this.doorAmount = doorAmount;
	}

	@Override
	public String toString() {
		return "Car [doorAmount=" + doorAmount + ", type=" + type + ", brand=" + brand + ", model=" + model
				+ ", originalPrice=" + originalPrice + ", hp=" + hp + ", consumption=" + consumption + ", mileage="
				+ mileage + ", color=" + color + ", getCalculatedPrice()=" + getCalculatedPrice() + ", getDoorAmount()="
				+ getDoorAmount() + ", getOriginalPrice()=" + getOriginalPrice() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public double getWeight() {
		return 0;
	}

	@Override
	public double getGroundClearance() {
		return 0;
	}
}
