package Prestentation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import Business.Garage;
import DTO.Vehicle;

/**
 * ClientController class
 * @author Miruku
 * contains the gui
 */
@SuppressWarnings("serial")
public class ClientController extends JFrame implements ActionListener
{
	private ClientHelper CH = new ClientHelper();
	private int ScreenWidth = (int)(CH.getScreenResolution().getWidth());
	private int ScreenHeight = (int)(CH.getScreenResolution().getHeight());
	
	private JFrame mainWnd;
	private JList<Vehicle> vehicleList;
	
	private JButton add;
	private JLabel garage, type, brand, model, price, ps;
	private JTextField tBrand, tModel, tPrice, tPS;
	private JComboBox<String> cbType;
	private int index;
	
	private Garage gar;
	
	/**
	 * Constructor
	 */
	public ClientController()
	{
		index = 1;
		createInterface();
	}
	
	/**
	 * create the interface
	 */
	private void createInterface()
	{
		mainWnd = new JFrame();
		mainWnd.setLayout(null);
		mainWnd.setSize(ScreenWidth / 2, ScreenHeight / 2);
		mainWnd.setLocation(ScreenWidth / 4, ScreenHeight / 4);
		mainWnd.setUndecorated(true);
		
		vehicleList = new JList<Vehicle>();
		vehicleList.setLocation(50,100);
		vehicleList.setSize(350,400);
		vehicleList.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
		
		add = new JButton ();
		add.setBounds(350,35,40,40);
		add.setIcon(CH.loadImg("../images/add.png"));
		add.setContentAreaFilled(false);
		add.setBorder(null);
		
		garage = new JLabel("Garage");
		garage.setBounds(60,10,400,80);
		garage.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
		
		mainWnd.add(add);
		mainWnd.add(garage);
		mainWnd.add(vehicleList);
		
		mainWnd.setResizable(false);	
		mainWnd.setVisible(true);
		
		add.addActionListener(this);
	}
	
	/**
	 * Creat the type ComboBox
	 */
	private void addTypeBox()
	{
		type = new JLabel("Typ:");
		type.setBounds(440,100,150,35);
		type.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		String[] raceStr = {"Auto","Quad","Motorrad"};
		cbType = new JComboBox<String>(raceStr);
		cbType.setBounds(560,100,100,35);
		cbType.setSelectedIndex(index);
		cbType.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		mainWnd.add(type);
		mainWnd.add(cbType);
		mainWnd.repaint();
	}
	
	/**
	 * create formular
	 */
	private void createFormular()
	{
		brand = new JLabel("Marke:");
		brand.setBounds(440,140,150,35);
		brand.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tBrand = new JTextField();
		tBrand.setBounds(560,140,180,35);
		tBrand.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		model = new JLabel("Model/Name:");
		model.setBounds(440,180,150,35);
		model.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tModel = new JTextField();
		tModel.setBounds(560,180,180,35);
		tModel.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		price = new JLabel("Preis:");
		price.setBounds(440,220,150,35);
		price.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tPrice = new JTextField();
		tPrice.setBounds(560,220,180,35);
		tPrice.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		ps = new JLabel("Leistung:");
		ps.setBounds(440,260,150,35);
		ps.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tPS = new JTextField();
		tPS.setBounds(560,260,180,35);
		tPS.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		ps = new JLabel("Leistung:");
		ps.setBounds(440,260,150,35);
		ps.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tPS = new JTextField();
		tPS.setBounds(560,260,180,35);
		tPS.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		mainWnd.add(brand);
		mainWnd.add(tBrand);
		mainWnd.add(model);
		mainWnd.add(tModel);
		mainWnd.add(price);
		mainWnd.add(tPrice);
		mainWnd.add(ps);
		mainWnd.add(tPS);
		
		
		mainWnd.repaint();
	}
	
	/**
	 * create additional options
	 * Index:
	 * 0 = Car
	 * 1 = Quad
	 * 2 = Motorbike 
	 * @param index
	 */
	private void createAdditionalOptions(int index)
	{
		/*Car*/
		if(index == 0)
		{
			
		}	
		
		/*Quad*/
		else if(index == 1)
		{
			
		}
		
		/*Motorbike*/
		else if(index == 2)
		{
			
		}
	}
	
	/**
	 * actionPerformer 
	 */
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == add)
		{
			addTypeBox();
			createFormular();
			createAdditionalOptions(cbType.getSelectedIndex());	
		}
		if(event.getSource() == cbType)
		{
			createAdditionalOptions(cbType.getSelectedIndex());	
		}
	}
}
