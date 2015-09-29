
package gameMaker.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

import gameMaker.util.Constants;

import org.apache.log4j.Logger;

public class Main implements Constants {

	final static Logger log = Logger.getLogger(Main.class);
    private static JFrame mainFrame;
    private static Dimension dim;
   
	public static void main(String[] args) {
		
	        // Set look and feel to that of OS
	        try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } 
	        catch (Exception e) {
	        	 log.error("Error Message : ", e);
	        }
	        
	        mainFrame = new JFrame("GameMaker 1.0");
	        mainFrame.setSize(windowWidth, windowHeight);
	        mainFrame.setResizable(false);
	        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        /*Place mainFrame in the middle of the screen*/
	        try {
	    		dim = Toolkit.getDefaultToolkit().getScreenSize();
	    		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
	        } 
	        catch (Exception e) {
	            log.error("Error Message : ", e);
	        }
	        
	        Overseer overseerObj = new Overseer(mainFrame);
	        overseerObj.init();

	        mainFrame.setVisible(true);
	}
}
