package gameMaker.main;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import gameMaker.util.Constants;
import gameMaker.util.DropListener;

public class Overseer implements Constants {

	private JFrame mainFrame;
	private JPanel controlPanel, gamePanel;
	private JSplitPane splitFrame;
	
	
	private ControlView controlViewObj;
	private GameView gameViewObj;

	// Constructor to initialize the mainFrame from main class
	public Overseer(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void init() {

		controlPanel = new JPanel();
		gamePanel = new JPanel();
		
		controlPanel.setLayout(new BorderLayout());
		gamePanel.setLayout(null);
		
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

}
