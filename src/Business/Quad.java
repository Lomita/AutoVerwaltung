package Business;

import DTO.Vehicle;

/**
 * Quad class
 * contains the quad definition
 */
public class Quad extends Vehicle {
	private double groundClearance;
	/**
	 * Constructor
	 * @param type
	 * @param brand
	 * @param model
	 * @param originalPrice
	 * @param hp
	 * @param consumption
	 * @param mileage
	 * @param color
	 * @param groundClearance
	 */
	public Quad(String type, String brand, String model, double originalPrice, int hp, double consumption, int mileage,
			String color, double groundClearance) {
		super(type, brand, model, originalPrice, hp, consumption, mileage, color);
		this.groundClearance = groundClearance;
	}
	/**
	 * Returns the calculated Price
	 */
	public double getCalculatedPrice() {
		double price = this.getOriginalPrice();
		int numberOfDeduction = mileage / 10000;
		price = price - (numberOfDeduction * (price / 100 * 7));
		return price < 0 ? 0 : price;
	}

	public double getGroundClearance() {
		return groundClearance;
	}

	public void setGroundClearance(double groundClearance) {
		this.groundClearance = groundClearance;
	}

	@Override
	public String toString() {
		return "Quad [groundClearance=" + groundClearance + ", type=" + type + ", brand=" + brand + ", model=" + model
				+ ", originalPrice=" + originalPrice + ", hp=" + hp + ", consumption=" + consumption + ", mileage="
				+ mileage + ", color=" + color + ", getCalculatedPrice()=" + getCalculatedPrice()
				+ ", getGroundClearance()=" + getGroundClearance() + ", getOriginalPrice()=" + getOriginalPrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public double getWeight() {
		return 0;
	}

	@Override
	public int getDoorAmount() {
		return 0;
	}
}
