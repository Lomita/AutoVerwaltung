package DTO;
import java.util.ArrayList;

/**
 * Vehicle class
 * contains the vehicle definition
 */
public class Vehicle 
{	
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
	public Vehicle(String type, String brand, String model, double originalPrice, int hp, int consumption, int mileage, String color)
	{
		this.type=type;
	}
	
	/**
	 * get the original price
	 * @return returns the original price 
	 */
	protected double getOriginalPrice()
	{
		return this.originalPrice;
	}
}
