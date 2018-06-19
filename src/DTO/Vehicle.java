package DTO;

import java.util.ArrayList;

/**
 * Vehicle class contains the vehicle definition
 */
public abstract class Vehicle {
	protected String type;
	protected String brand;
	protected String model;
	protected double originalPrice;
	protected int hp;
	protected int consumption;
	protected int mileage;
	protected String color;

	/**
	 * Constructor
	 */

	public Vehicle(String type, String brand, String model, double originalPrice, int hp, int consumption, int mileage,
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
