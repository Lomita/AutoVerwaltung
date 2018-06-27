package Tests;

import static org.junit.Assert.*;
import org.junit.*;
import Business.*;
import DTO.Vehicle;

public class TestBusiness 
{
	Garage gar;
	int index;
	
	/**
	 * Vorbereitung für die Tests
	 */
	@Before
	public void init()
	{
		gar = new Garage();
		index = 0;
	}
	
	/**
	 * Hinzufügen eines Fahrzeugs testen
	 */
	@Test
	public void testAddVehicle() 
	{
		Vehicle vehicle = new Car("Car","Honda","Auto1",2000,300,20,10000,"Blau",4); 
		gar.addVehicle(vehicle);
		assertEquals(vehicle, gar.getVehicleObjFromListByID(index));
	}
	
	/**
	 * Preisberechnung testen
	 */
	@Test
	public void testCalculatedPrice() 
	{
		Vehicle vehicle = new Car("Car","Honda","Auto1",2000,300,20,30000000,"Blau",4); 
		gar.addVehicle(vehicle);
		int price = 0;
		assertTrue(price == gar.getVehicleObjFromListByID(index).getCalculatedPrice());
	}
	
	@After
	public void dispose()
	{
		gar = null;
	}
}
