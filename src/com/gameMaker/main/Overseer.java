package com.gameMaker.main;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import org.apache.log4j.Logger;

import com.gameMaker.listener.DropListener;
import com.gameMaker.util.Constants;
import com.gameMaker.util.KeyEventWrapper;

public class Overseer implements Constants {
	
	private final static Logger log = Logger.getLogger(Overseer.class);

	private JFrame mainFrame;
	private JPanel controlPanel;
	private JSplitPane splitFrame;

	private ControlView controlViewObj;
	private GameView gameViewObj;
	
	private KeyEventWrapper leftMoveKey, rightMoveKey;

	// Default folder for resource files
	public static File resourceFolder;

	// Constructor to initialize the mainFrame from main class
	public Overseer(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		gameViewObj = new GameView(this);
		controlPanel = new JPanel();
	}

	public void init() {

		controlPanel.setLayout(new BorderLayout());

		// Name of the folder is initialized to saveFolder
		resourceFolder = new File("resources");
		// If the directory isn't found in project space, it is created
		if (!resourceFolder.isDirectory()) {
			log.error ("Resouce folder not found");
		}
		
		// Splitting the mainFrame in two panels
		splitFrame = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlPanel, gameViewObj);
		// Setting the resize to false
		splitFrame.setEnabled(false);
		// Setting the location of the divider
		splitFrame.setDividerLocation(splitSize);

		controlViewObj = new ControlView(this, controlPanel);
		

		new DropListener(gameViewObj);
		/*
		leftMoveKey = (KeyEvent.class.getDeclaredField("VK_LEFT"));
		rightMoveKey = null;
		*/

		leftMoveKey = new KeyEventWrapper(new KeyEvent(controlPanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED));
		rightMoveKey = new KeyEventWrapper(new KeyEvent(controlPanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED));		
		
		mainFrame.getContentPane().add(splitFrame);
	}

	public JFrame getMainFrame() {
		return mainFrame;
		
	}

	public JPanel getControlPanel() {
		return controlPanel;
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
	
	public void setLeftMoveKey(KeyEventWrapper leftKey) {
		leftMoveKey = leftKey;
	}
	
	public KeyEventWrapper getLeftMoveKey() {
		return leftMoveKey;
	}
	
	public void setRightMoveKey(KeyEventWrapper rightKey) {
		rightMoveKey = rightKey;
	}
	
	public KeyEventWrapper getRightMoveKey() {
		return rightMoveKey;
	}
}
