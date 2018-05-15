import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Interface class
 * @author Miruku
 * contains the interface 
 */
@SuppressWarnings("serial")
public class Interface extends JFrame
{
	private InterfaceHelper IFH = new InterfaceHelper();
	private int ScreenWidth = (int)(IFH.getScreenResolution().getWidth());
	private int ScreenHeight = (int)(IFH.getScreenResolution().getHeight());
	
	private JFrame mainWnd;
	private JList<Vehicle> vehicleList;
	
	private JButton add;
	private JLabel garage;
	
	/**
	 * Constructor
	 */
	public Interface()
	{
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
		add.setIcon(IFH.loadImg("images/add.png"));
		add.setContentAreaFilled(false);
		add.setBorder(null);
		
		garage = new JLabel("Garage");
		garage.setBounds(60,10,400,80);
		garage.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
		
		mainWnd.add(add);
		mainWnd.add(garage);
		mainWnd.add(vehicleList);
		mainWnd.setVisible(true);
	}
}
