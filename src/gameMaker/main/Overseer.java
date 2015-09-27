package gameMaker.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import gameMaker.util.Constants;
import gameMaker.util.DropListener;
import gameMaker.view.AccordionUI;

public class Overseer implements Constants {

	private JFrame mainFrame;
	private JPanel controlPanel, gamePanel;
	private JSplitPane splitFrame;
	

	private ControlView controlViewObj;
	private GameView gameViewObj;

	AccordionUI accordionUI = new AccordionUI();

	// Constructor to initialize the mainFrame from main class
	public Overseer(JFrame mainFrame) {
		this.mainFrame = mainFrame;		

	}

	public void init() {

		controlPanel = new JPanel(new GridLayout(1, 1));

		gamePanel = new JPanel();

		// Splitting the mainFrame in two panels
		splitFrame = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlPanel, gamePanel);
		// Setting the resize to false
		splitFrame.setEnabled(false);
		// Setting the location of the divider
		splitFrame.setDividerLocation(splitSize);
		accordionUI.acordionMaker();

		controlPanel.add(accordionUI);

		JPanel addedSpritePanel = new JPanel(new BorderLayout());
		addedSpritePanel.add(new JLabel("Added Sprites"), BorderLayout.NORTH);
		addedSpritePanel.add(new JScrollPane(), BorderLayout.CENTER);
		gamePanel.setLayout(null);

		controlViewObj = new ControlView(this, controlPanel);
		gameViewObj = new GameView(gamePanel);

		new DropListener(gamePanel);

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
