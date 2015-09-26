package gameMaker.main;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import gameMaker.util.Constants;

public class Overseer implements Constants{

	private JFrame mainFrame;
	private JPanel controlPanel, gamePanel;
	private JSplitPane splitFrame;
	
	private ControlView controlViewObj;
	private GameView gameViewObj;
	
	// Constructor to initialize the mainFrame from main class
	public Overseer (JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void init() {
		
		controlPanel = new JPanel();
		gamePanel = new JPanel();
		
		// Splitting the mainFrame in two panels
		splitFrame = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT, controlPanel, gamePanel);
		// Setting the resize to false
		splitFrame.setEnabled(false);
		// Setting the location of the divider
		splitFrame.setDividerLocation(splitSize);
		
		//To-do decide on layouts for both
		controlPanel.setLayout(null);
		gamePanel.setLayout(null);
		
		controlViewObj = new ControlView (this, controlPanel);
		gameViewObj = new GameView (gamePanel);
		
		mainFrame.getContentPane().add(splitFrame);
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
	
}
