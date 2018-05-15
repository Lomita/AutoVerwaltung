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
		
		mainWnd.setVisible(true);
	}
}
