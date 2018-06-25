package Prestentation;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Business.*;
import Business.Motorbike;
import DTO.*;

/**
 * ClientController class
 * @author Miruku
 * contains the gui
 */
@SuppressWarnings("serial")
public class ClientController extends JFrame implements ActionListener, MouseListener
{
	private ClientHelper CH = new ClientHelper();
	
	private JFrame mainWnd;
	private JList<String> vehicleList;
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JScrollPane scrollPane;
	
	private JButton add, bSave, bDel;
	private JLabel garage, type, lTypeData, brand, lBrandData, model, lModelData, 
				   price, lPriceData, ps, lPSData, km, lKMData, csp, lCSPData, col,
				   lColData, lAdd, addOption, laddOptionData;
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
		gar = new Garage();
		index = 1;
		createInterface();
		createFormularItems();
	}
	
	/**
	 * create the interface
	 */
	private void createInterface()
	{
		mainWnd = new JFrame();
		mainWnd.setLayout(null);
		mainWnd.setSize(910,600);
		mainWnd.setLocation(400,300);	
		
		vehicleList = new JList<String>();
		scrollPane = new JScrollPane(vehicleList);
		scrollPane.setBounds(50,100,350,400);
		vehicleList.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
		vehicleList.setModel(listModel);
		
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
		mainWnd.add(scrollPane);
		
		mainWnd.setResizable(false);	
		mainWnd.setVisible(true);
		
		add.addActionListener(this);
		vehicleList.addMouseListener(this);
	}
	
	/**
	 * create formular
	 */
	private void createFormularItems()
	{
		brand = new JLabel("Marke:");
		brand.setBounds(470,140,150,35);
		brand.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		lBrandData = new JLabel();
		lBrandData.setBounds(630,140,220,35);
		lBrandData.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tBrand = new JTextField();
		tBrand.setBounds(630,140,220,35);
		tBrand.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		model = new JLabel("Model/Name:");
		model.setBounds(470,180,150,35);
		model.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		lModelData = new JLabel();
		lModelData.setBounds(630,180,220,35);
		lModelData.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tModel = new JTextField();
		tModel.setBounds(630,180,220,35);
		tModel.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		price = new JLabel("Neupreis(CHF):");
		price.setBounds(470,220,150,35);
		price.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		lPriceData = new JLabel();
		lPriceData.setBounds(630,220,220,35);
		lPriceData.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tPrice = new JTextField();
		tPrice.setBounds(630,220,220,35);
		tPrice.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		ps = new JLabel("Leistung(PS):");
		ps.setBounds(470,260,150,35);
		ps.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		lPSData = new JLabel();
		lPSData.setBounds(630,260,220,35);
		lPSData.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tPS = new JTextField();
		tPS.setBounds(630,260,220,35);
		tPS.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		csp = new JLabel("Verbrauch(l/h):");
		csp.setBounds(470,300,150,35);
		csp.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		lCSPData = new JLabel();
		lCSPData.setBounds(630,300,220,35);
		lCSPData.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tCSP = new JTextField();
		tCSP.setBounds(630,300,220,35);
		tCSP.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		km = new JLabel("KM-Stand(km):");
		km.setBounds(470,340,150,35);
		km.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		lKMData = new JLabel();
		lKMData.setBounds(630,340,220,35);
		lKMData.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tKM = new JTextField();
		tKM.setBounds(630,340,220,35);
		tKM.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		col = new JLabel("Color:");
		col.setBounds(470,380,150,35);
		col.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		lColData = new JLabel();
		lColData.setBounds(630,380,220,35);
		lColData.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		tCol = new JTextField();
		tCol.setBounds(630,380,220,35);
		tCol.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		bSave = new JButton("Speichern");
		bSave.setBounds(550,470,250,50);
		bSave.setBackground(Color.BLACK);
		bSave.setForeground(Color.WHITE);
		bSave.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
		
		bDel = new JButton("Löschen");
		bDel.setBounds(550,470,250,50);
		bDel.setBackground(Color.RED);
		bDel.setForeground(Color.BLACK);
		bDel.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
		
		lAdd = new JLabel("Hinzufügen");
		lAdd.setBounds(470,10,300,80);
		lAdd.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
		
		type = new JLabel("Typ:");
		type.setBounds(470,100,150,35);
		type.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		lTypeData = new JLabel();
		lTypeData.setBounds(630,100,220,35);
		lTypeData.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		String[] raceStr = {"Auto","Quad","Motorrad"};
		cbType = new JComboBox<String>(raceStr);
		cbType.setBounds(630,100,100,35);
		cbType.setSelectedIndex(index);
		cbType.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		addOption = new JLabel("Bodenfreiheit:");
		addOption.setBounds(470,420,150,35);
		addOption.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		laddOptionData = new JLabel();
		laddOptionData.setBounds(630,420,220,35);
		laddOptionData.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		taddOption = new JTextField();
		taddOption.setBounds(630,420,220,35);
		taddOption.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		mainWnd.add(lAdd);
		mainWnd.add(type);
		mainWnd.add(cbType);
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
		mainWnd.add(addOption);
		mainWnd.add(taddOption);
		mainWnd.add(lTypeData);
		mainWnd.add(lBrandData);
		mainWnd.add(lModelData);
		mainWnd.add(lPriceData);
		mainWnd.add(lPSData);
		mainWnd.add(lKMData);
		mainWnd.add(lCSPData);
		mainWnd.add(lColData);
		mainWnd.add(laddOptionData);
		mainWnd.add(bDel);
		
		bDel.addActionListener(this);
		bSave.addActionListener(this);
		cbType.addActionListener(this);
	}
	
	/**
	 * show add formular
	 */
	private void showAddFormular()
	{
		/*Labels*/
		if(lAdd != null)
			lAdd.setVisible(true);
		if(type != null)
			type.setVisible(true);
		if(brand != null)
			brand.setVisible(true);
		if(model != null)
			model.setVisible(true);
		if(price != null)
			price.setVisible(true);
		if(ps != null)
			ps.setVisible(true);
		if(csp != null)
			csp.setVisible(true);
		if(km != null)
			km.setVisible(true);
		if(col != null)
			col.setVisible(true);
		if(addOption != null)
			addOption.setVisible(true);
		if(lAdd != null)
			lAdd.setVisible(true);
		
		/*TextFields*/
		if(tBrand != null)
			tBrand.setVisible(true);
		if(tModel != null)
			tModel.setVisible(true);
		if(tPrice != null)
			tPrice.setVisible(true);
		if(tPS != null)
			tPS.setVisible(true);
		if(tCSP != null)
			tCSP.setVisible(true);
		if(tKM != null)
			tKM.setVisible(true);
		if(tCol != null)
			tCol.setVisible(true);
		if(taddOption != null)
			taddOption.setVisible(true);
		
		/*ComboBox*/
		if(cbType != null)
			cbType.setVisible(true);
		if(bSave != null)
			bSave.setVisible(true);
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
			if(addOption !=null)
			{
				addOption.setVisible(true);
				addOption.setText("Anzahl Türen:");
			}
			if(addOption !=null)
				taddOption.setVisible(true);
		}	
		
		/*Quad*/
		else if(index == 1)
		{
			if(addOption !=null)
			{
				addOption.setVisible(true);
				addOption.setText("Bfreiheit(cm):");
			}
			if(addOption !=null)
				taddOption.setVisible(true);
		}
		
		/*Motorbike*/
		else if(index == 2)
		{
			if(addOption !=null)
			{
				addOption.setVisible(true);
				addOption.setText("Gewicht(kg):");
			}
			if(addOption !=null)
				taddOption.setVisible(true);
		}
	}
	
	/**
	 * Check the values
	 * @return true if checks are successful and false if not 
	 */
	private boolean CheckValues()
	{
		boolean brand = false, model = false,price = false,ps = false, 
				km = false,csp = false,color = false,addoption = false;
		
		/*Brand*/
		if(tBrand.getText().equals(""))
			tBrand.setBorder(new LineBorder(Color.RED));
		else
		{
			tBrand.setBorder(new LineBorder(Color.GRAY));
			brand = true;
		}
		/*Model*/
		if(tModel.getText().equals(""))
			tModel.setBorder(new LineBorder(Color.RED));
		else
		{
			tModel.setBorder(new LineBorder(Color.GRAY));
			model = true;
		}	
		/*Price*/
		if(!(tPrice.getText().matches("\\b([0-9]{1,7})(\\.([0-9]{1,2}))?\\b")) || tPrice.getText().equals(""))
			tPrice.setBorder(new LineBorder(Color.RED));
		else
		{
			tPrice.setBorder(new LineBorder(Color.GRAY));
			price = true;
		}	
		/*PS*/
		if(!(tPS.getText().matches("[0-9]*")) || tPS.getText().equals(""))
			tPS.setBorder(new LineBorder(Color.RED));
		else
		{
			tPS.setBorder(new LineBorder(Color.GRAY));
			ps = true;
		}
		/*KM*/
		if(!(tKM.getText().matches("[0-9]*")) || tKM.getText().equals(""))
			tKM.setBorder(new LineBorder(Color.RED));
		else
		{
			tKM.setBorder(new LineBorder(Color.GRAY));
			km = true;
		}	
		/*Consumption*/
		if(!(tCSP.getText().matches("\\b([0-9]{1,7})(\\.([0-9]{1,2}))?\\b")) || tCSP.getText().equals(""))
			tCSP.setBorder(new LineBorder(Color.RED));
		else
		{
			tCSP.setBorder(new LineBorder(Color.GRAY));
			csp = true;
		}	
		/*Color*/
		if(tCol.getText().equals(""))
			tCol.setBorder(new LineBorder(Color.RED));
		else
		{
			tCol.setBorder(new LineBorder(Color.GRAY));	
			color = true;
		}		
		/*Additional Option Quad (double)*/
		if(index == 2 || index == 1) 
		{
			if(!(taddOption.getText().matches("\\b([0-9]{1,5})(\\.([0-9]))?\\b")) || taddOption.getText().equals(""))
				taddOption.setBorder(new LineBorder(Color.RED));
			else
			{
				taddOption.setBorder(new LineBorder(Color.GRAY));
				addoption = true;
			}
		}
		/*Additional Option Car and Motorbike (int)*/ 
		else if(index == 0)
		{
			if(!(taddOption.getText().matches("\\b([0-9]{1,3})\\b")) || taddOption.getText().equals(""))
				taddOption.setBorder(new LineBorder(Color.RED));
			else
			{
				taddOption.setBorder(new LineBorder(Color.GRAY));
				addoption = true;
			}	
		}
		
		if(brand == true && model == true && price == true && ps == true && 
		   km == true && csp == true && color == true && addoption == true)
			return true;
		else
			return false;
	}
	
	private void hideAddFormular()
	{
		/*Labels*/
		if(brand != null)
			brand.setVisible(false);
		if(model != null)
			model.setVisible(false);
		if(price != null)
			price.setVisible(false);
		if(ps != null)
			ps.setVisible(false);
		if(csp != null)
			csp.setVisible(false);
		if(km != null)
			km.setVisible(false);
		if(col != null)
			col.setVisible(false);
		if(addOption != null)
			addOption.setVisible(false);
		if(lAdd != null)
			lAdd.setVisible(false);
		if(type != null)
			type.setVisible(false);
		
		/*TextFields*/
		if(tBrand != null)
			tBrand.setVisible(false);
		if(tModel != null)
			tModel.setVisible(false);
		if(tPrice != null)
			tPrice.setVisible(false);
		if(tPS != null)
			tPS.setVisible(false);
		if(tCSP != null)
			tCSP.setVisible(false);
		if(tKM != null)
			tKM.setVisible(false);
		if(tCol != null)
			tCol.setVisible(false);
		if(taddOption != null)
			taddOption.setVisible(false);
		
		/*Button & combobox*/
		if(cbType != null)
			cbType.setVisible(false);
		if(bSave != null)
			bSave.setVisible(false);
	}
	
	/**
	 * update and show the vehicle data
	 */
	private void showVehicleData()
	{
		int listIndex = vehicleList.getSelectedIndex();
		if(listIndex >= 0)
		{
			Vehicle vehicle = gar.getVehicleObjFromListByID(listIndex);
		
			if(bDel != null)
				bDel.setVisible(true);
			if(brand != null)
				brand.setVisible(true);
			if(model != null)
				model.setVisible(true);
			if(price != null)
				price.setVisible(true);
			if(ps != null)
				ps.setVisible(true);
			if(csp != null)
				csp.setVisible(true);
			if(km != null)
				km.setVisible(true);
			if(col != null)
				col.setVisible(true);
			if(type != null)
				type.setVisible(true);
			
			if(vehicle != null);
			{
				if(vehicle.getType() == "Car")
				{
					if(addOption !=null)
					{
						addOption.setVisible(true);
						addOption.setText("Anzahl Türen:");
						laddOptionData.setText(String.valueOf(vehicle.getDoorAmount()));
					}
				}
				
				else if(vehicle.getType() == "Quad")
				{
					if(addOption !=null)
					{
						addOption.setVisible(true);
						addOption.setText("Bodenfreiheit:");
						laddOptionData.setText(String.valueOf(vehicle.getGroundClearance()));
					}
				}
				
				else if(vehicle.getType() == "Motorbike")
				{
					if(addOption !=null)
					{
						addOption.setVisible(true);
						addOption.setText("Gewicht:");
						laddOptionData.setText(String.valueOf(vehicle.getWeight()));
					}
				}
				
				if(lTypeData != null)
				{
					lTypeData.setVisible(true);
					lTypeData.setText(vehicle.getType());
				}
					
				if(lBrandData != null)
				{
					lBrandData.setVisible(true);
					lBrandData.setText(vehicle.getBrand());
				}
				
				if(lModelData != null)
				{
					lModelData.setVisible(true);
					lModelData.setText(vehicle.getModel());
				}
					
				if(lPriceData != null)
				{
					lPriceData.setVisible(true);
					lPriceData.setText(String.valueOf(vehicle.getCalculatedPrice()));
				}
				
				if(lPSData != null)
				{
					lPSData.setVisible(true);
					lPSData.setText(String.valueOf(vehicle.getHp()));
				}
					
				if(lKMData != null)
				{
					lKMData.setVisible(true);
					lKMData.setText(String.valueOf(vehicle.getMileage()));
				}
				if(lCSPData != null)
				{
					lCSPData.setVisible(true);
					lCSPData.setText(String.valueOf(vehicle.getConsumption()));
				}
					
				if(lColData != null)
				{
					lColData.setVisible(true);
					lColData.setText(vehicle.getColor());
				}
			}

		}
		else
		{
			if(bDel != null)
				bDel.setVisible(false);
			if(brand != null)
				brand.setVisible(false);
			if(model != null)
				model.setVisible(false);
			if(price != null)
				price.setVisible(false);
			if(ps != null)
				ps.setVisible(false);
			if(csp != null)
				csp.setVisible(false);
			if(km != null)
				km.setVisible(false);
			if(col != null)
				col.setVisible(false);
			if(type != null)
				type.setVisible(false);
			if(addOption != null)
				addOption.setVisible(false);
			if(lBrandData != null)
				lBrandData.setVisible(false);
			if(lModelData != null)
				lModelData.setVisible(false);
			if(lPriceData != null)
				lPriceData.setVisible(false);
			if(lPSData != null)
				lPSData.setVisible(false);
			if(lCSPData != null)
				lCSPData.setVisible(false);
			if(lKMData != null)
				lKMData.setVisible(false);
			if(lColData != null)
				lColData.setVisible(false);
			if(lTypeData != null)
				lTypeData.setVisible(false);
			if(laddOptionData != null)
				laddOptionData.setVisible(false);
		}
	}
	
	/**
	 * updates the vehicle list
	 */
	private void updateList()
	{	
		if(listModel != null)
			listModel.removeAllElements();
		
		int lastIndex = 0;
		for(Vehicle vehicle : gar.getVehicleList())
		{
			lastIndex++;
			listModel.addElement(vehicle.getModel());
		}	
		vehicleList.setSelectedIndex(lastIndex-1);
	}
	
	/**
	 * actionPerformer 
	 */
	public void actionPerformed(ActionEvent event) 
	{
		/**
		 * add button
		 */
		if(event.getSource() == add)
		{
			if(isAddMode == false)
			{	
				isAddMode = true;
				price.setText("Neupreis(CHF):");
				showAddFormular();
				index = cbType.getSelectedIndex();
				createAdditionalOptions(index);	
				mainWnd.repaint();
			}
		}
		
		/**
		 * onUpdate type Combobox
		 */
		if(event.getSource() == cbType)
		{	
			index = cbType.getSelectedIndex();
			createAdditionalOptions(index);	
			mainWnd.repaint();
		}
		
		/**
		 * Value Checks and vehicle creation
		 */
		if(event.getSource() == bSave)
		{
			if(CheckValues() == true)
			{
				/*Car*/
				if(index == 0)
				{
					Vehicle vehicle = new Car("Car", tBrand.getText(), tModel.getText(), Double.parseDouble(tPrice.getText()), 
											   Integer.parseInt(tPS.getText()), Integer.parseInt(tCSP.getText()), Integer.parseInt(tKM.getText()), 
											   tCol.getText(), Integer.parseInt(taddOption.getText())); 
					gar.addVehicle(vehicle);
				}
				
				/*Quad*/
				if(index == 1)
				{
					Vehicle vehicle = new Quad("Quad", tBrand.getText(), tModel.getText(), Double.parseDouble(tPrice.getText()), 
											   Integer.parseInt(tPS.getText()), Integer.parseInt(tCSP.getText()), Integer.parseInt(tKM.getText()),  
											   tCol.getText(), Double.parseDouble(taddOption.getText())); 
					gar.addVehicle(vehicle);
				}
				
				/*Motorbike*/
				if(index == 2)
				{
					Vehicle vehicle = new Motorbike("Motorbike", tBrand.getText(), tModel.getText(), Double.parseDouble(tPrice.getText()), 
											   Integer.parseInt(tPS.getText()), Integer.parseInt(tCSP.getText()), Integer.parseInt(tKM.getText()),
											   tCol.getText(), Double.parseDouble(taddOption.getText())); 
					gar.addVehicle(vehicle);
				}
				
				hideAddFormular();
				updateList();
				price.setText("Preis(CHF):");
				showVehicleData();
				isAddMode = false;
				mainWnd.repaint();
			}	
		}
		
		/**
		 * Delete the Selected Object
		 */
		if(event.getSource() == bDel)
		{
			if(vehicleList.getSelectedIndex() >= 0)
			{
				gar.delVehicleByIndex(vehicleList.getSelectedIndex());
				updateList();
				showVehicleData();
				mainWnd.repaint();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) 
	{
		if(event.getSource() == vehicleList)
		{
			
			if(vehicleList.getSelectedIndex() >= 0)
			{
				if(isAddMode == true)
				{
					hideAddFormular();
					isAddMode = false;
				}
				showVehicleData();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}