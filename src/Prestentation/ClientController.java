package Prestentation;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Business.*;
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
		mainWnd.setSize(910,550);
		mainWnd.setLocation(400,300);	
		mainWnd.setUndecorated(true);
		
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
		
		col = new JLabel("Color:");
		col.setBounds(470,380,150,35);
		col.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		tCol = new JTextField();
		tCol.setBounds(630,380,220,35);
		tCol.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		bSave = new JButton("Speichern");
		bSave.setBounds(550,470,250,50);
		bSave.setBackground(Color.BLACK);
		bSave.setForeground(Color.WHITE);
		bSave.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
		
		lAdd = new JLabel("Hinzufügen");
		lAdd.setBounds(470,10,300,80);
		lAdd.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
		
		type = new JLabel("Typ:");
		type.setBounds(470,100,150,35);
		type.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		String[] raceStr = {"Auto","Quad","Motorrad"};
		cbType = new JComboBox<String>(raceStr);
		cbType.setBounds(630,100,100,35);
		cbType.setSelectedIndex(index);
		cbType.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		addOption = new JLabel("Bodenfreiheit:");
		addOption.setBounds(470,420,150,35);
		addOption.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
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
				addOption.setText("Bodenfreiheit:");
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
				addOption.setText("Gewicht:");
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
		if(index == 1) 
		{
			if(!(taddOption.getText().matches("\\b([0-9]{1,3})(\\.([0-9]))?\\b")) || taddOption.getText().equals(""))
				taddOption.setBorder(new LineBorder(Color.RED));
			else
			{
				taddOption.setBorder(new LineBorder(Color.GRAY));
				addoption = true;
			}
		}
		/*Additional Option Car and Motorbike (int)*/ 
		else if(index == 2 || index == 0)
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
	
	private void showVehicleData()
	{
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
		
		int listIndex = vehicleList.getSelectedIndex();
		
		Vehicle vehicle = gar.getVehicleObjFromListByID(listIndex);
		if(vehicle != null);
		{
			if(vehicle.getType() == "Car")
			{
				if(addOption !=null)
				{
					addOption.setVisible(true);
					addOption.setText("Anzahl Türen:");
				}
			}
			
			else if(vehicle.getType() == "Quad")
			{
				if(addOption !=null)
				{
					addOption.setVisible(true);
					addOption.setText("Bodenfreiheit:");
				}
			}
			
			else if(vehicle.getType() == "Motorbike")
			{
				if(addOption !=null)
				{
					addOption.setVisible(true);
					addOption.setText("Gewicht:");
				}
			}
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
											   tCol.getText(), Integer.parseInt(taddOption.getText())); 
					gar.addVehicle(vehicle);
				}
				
				hideAddFormular();
				updateList();
				isAddMode = false;
				mainWnd.repaint();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) 
	{
		if(event.getSource() == vehicleList)
		{
			hideAddFormular();
			showVehicleData();
			isAddMode = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}