package Business;

import DTO.Vehicle;

/**
 * Quad class
 * contains the quad definition
 */
public class Quad extends Vehicle {
	private double groundClearance;

	public Quad(String type, String brand, String model, double originalPrice, int hp, int consumption, int mileage,
			String color, double groundClearance) {
		super(type, brand, model, originalPrice, hp, consumption, mileage, color);
		this.groundClearance = groundClearance;
	}

	public double getCalculatedPrice() {
		double price = this.getOriginalPrice();
		int numberOfDeduction = mileage / 10000;
		price = price - (numberOfDeduction * (price / 100 * 5));
		return price < 0 ? 0 : price;
	}

	public double getGroundClearance() {
		return groundClearance;
	}

	public void setGroundClearance(double groundClearance) {
		this.groundClearance = groundClearance;
	}

}
