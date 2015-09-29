package gameMaker.main;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import org.apache.log4j.Logger;

import gameMaker.listener.DropListener;
import gameMaker.util.Constants;

public class Overseer implements Constants {
	
	private final static Logger log = Logger.getLogger(Overseer.class);

	private JFrame mainFrame;
	private JPanel controlPanel, gamePanel;
	private JSplitPane splitFrame;

	private ControlView controlViewObj;
	private GameView gameViewObj;

	// Default folder for resource files
	public static File resourceFolder;

	// Constructor to initialize the mainFrame from main class
	public Overseer(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void init() {

		controlPanel = new JPanel();
		gamePanel = new JPanel();

		controlPanel.setLayout(new BorderLayout());
		gamePanel.setLayout(null);

		// Name of the folder is initialized to saveFolder
		resourceFolder = new File("resources");
		// If the directory isn't found in project space, it is created
		if (!resourceFolder.isDirectory()) {
			log.error ("Resouce folder not found");
		}

		// Splitting the mainFrame in two panels
		splitFrame = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlPanel, gamePanel);
		// Setting the resize to false
		splitFrame.setEnabled(false);
		// Setting the location of the divider
		splitFrame.setDividerLocation(splitSize);

		controlViewObj = new ControlView(this, controlPanel);
		gameViewObj = new GameView(gamePanel);

		new DropListener(gamePanel);

		mainFrame.getContentPane().add(splitFrame);
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public JPanel getControlPanel() {
		return controlPanel;
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public ControlView getControlView() {
		return controlViewObj;
	}

	public GameView getGameView() {
		return gameViewObj;
	}

	public void addToGameView(JComponent component) {
		gameViewObj.addToPanel(component);
	}

	public File getResourceFolder() {
		return resourceFolder;
	}
	
}
