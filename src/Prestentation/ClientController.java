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
	
	private JButton add, bSave;
	private JLabel garage, type, brand, model, price, ps, km, csp, col, lAdd, addOption;
	private JTextField tBrand, tModel, tPrice, tPS, tKM, tCSP, tCol, taddOption;
	private JComboBox<String> cbType;
	private int index;
	
	private boolean isAddMode = false;
	
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
		lAdd = new JLabel("Hinzufügen");
		lAdd.setBounds(560,10,300,80);
		lAdd.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
		
		type = new JLabel("Typ:");
		type.setBounds(470,100,150,35);
		type.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		String[] raceStr = {"Auto","Quad","Motorrad"};
		cbType = new JComboBox<String>(raceStr);
		cbType.setBounds(630,100,100,35);
		cbType.setSelectedIndex(index);
		cbType.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		mainWnd.add(lAdd);
		mainWnd.add(type);
		mainWnd.add(cbType);
		
		cbType.addActionListener(this);
		
		mainWnd.repaint();
	}
	
	/**
	 * create formular
	 */
	private void createFormular()
	{
		brand = new JLabel("Marke:");
		brand.setBounds(470,140,150,35);
		brand.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		tBrand = new JTextField();
		tBrand.setBounds(630,140,220,35);
		tBrand.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		model = new JLabel("Model/Name:");
		model.setBounds(470,180,150,35);
		model.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		tModel = new JTextField();
		tModel.setBounds(630,180,220,35);
		tModel.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		price = new JLabel("Preis:");
		price.setBounds(470,220,150,35);
		price.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		tPrice = new JTextField();
		tPrice.setBounds(630,220,220,35);
		tPrice.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		ps = new JLabel("Leistung(PS):");
		ps.setBounds(470,260,150,35);
		ps.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		tPS = new JTextField();
		tPS.setBounds(630,260,220,35);
		tPS.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		csp = new JLabel("Verbrauch:");
		csp.setBounds(470,300,150,35);
		csp.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		tCSP = new JTextField();
		tCSP.setBounds(630,300,220,35);
		tCSP.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		km = new JLabel("KM-Stand:");
		km.setBounds(470,340,150,35);
		km.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		tKM = new JTextField();
		tKM.setBounds(630,340,220,35);
		tKM.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		col = new JLabel("Farbe:");
		col.setBounds(470,380,150,35);
		col.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		tCol = new JTextField();
		tCol.setBounds(630,380,220,35);
		tCol.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		bSave = new JButton("Speichern");
		bSave.setBounds(560,470,250,50);
		bSave.setBackground(Color.BLACK);
		bSave.setForeground(Color.WHITE);
		bSave.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
		
		mainWnd.add(brand);
		mainWnd.add(tBrand);
		mainWnd.add(model);
		mainWnd.add(tModel);
		mainWnd.add(price);
		mainWnd.add(tPrice);
		mainWnd.add(ps);
		mainWnd.add(tPS);
		mainWnd.add(csp);
		mainWnd.add(tCSP);
		mainWnd.add(km);
		mainWnd.add(tKM);
		mainWnd.add(col);
		mainWnd.add(tCol);
		mainWnd.add(bSave);
		
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
			addOption = new JLabel("Anzhal Türen:");
			addOption.setBounds(470,420,150,35);
			addOption.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
			
			taddOption = new JTextField();
			taddOption.setBounds(630,420,220,35);
			taddOption.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		}	
		
		/*Quad*/
		else if(index == 1)
		{
			addOption = new JLabel("Bodenfreiheit:");
			addOption.setBounds(470,420,150,35);
			addOption.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
			
			taddOption = new JTextField();
			taddOption.setBounds(630,420,220,35);
			taddOption.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		}
		
		/*Motorbike*/
		else if(index == 2)
		{
			addOption = new JLabel("Gewicht:");
			addOption.setBounds(470,420,150,35);
			addOption.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
			
			taddOption = new JTextField();
			taddOption.setBounds(630,420,220,35);
			taddOption.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		}
		
		mainWnd.add(addOption);
		mainWnd.add(taddOption);
	}
	
	/**
	 * actionPerformer 
	 */
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == add)
		{
			if(isAddMode == false)
			{	
				isAddMode = true;
				addTypeBox();
				createFormular();
				createAdditionalOptions(cbType.getSelectedIndex());	
			}
		}
		if(event.getSource() == cbType)
		{
			if(addOption != null)
				mainWnd.remove(addOption);
			if(taddOption != null)
				mainWnd.remove(taddOption);
			
			createAdditionalOptions(cbType.getSelectedIndex());	
			mainWnd.repaint();
		}
	}
}
