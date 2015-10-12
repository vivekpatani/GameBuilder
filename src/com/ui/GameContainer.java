/**
 * 
 */
package com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import org.apache.log4j.Logger;

import com.launcher.Constants;

/**
 * This class represents the JFrame containing user editor panel and game play
 * panel and acts as the container of whole UI.
 * 
 * @author Team5 (Assignment #5)
 *
 */
@SuppressWarnings("serial")
public class GameContainer extends JFrame {

	final static Logger log = Logger.getLogger(GameContainer.class);
	private GameMakerPanel gameMakerPanel;
	private GamePlayPanel gamePlayPanel;
	private JPanel gameBoardPanel;
	private ClockPanel clockPanel;
	private JSplitPane splitFrame;

	public GameContainer() {
		
		setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		gameMakerPanel = new GameMakerPanel();
		gamePlayPanel = new GamePlayPanel();
		clockPanel = new ClockPanel();
		createGameBoardPanel();
		
		// Add gameMakerPanel as left side, and gameBoardPanel as right
		splitFrame = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gameMakerPanel, gameBoardPanel);
		// Setting the resize to false
		splitFrame.setEnabled(false);
		// Setting the location of the divider
		splitFrame.setDividerLocation(Constants.splitFrameSize);
		this.add(splitFrame);
	
	}

	/**
	 * @return the gameMakerPanel
	 */
	public GameMakerPanel getGameMakerPanel() {
		return gameMakerPanel;
	}

	/**
	 * @param gameMakerPanel
	 *            the gameMakerPanel to set
	 */
	public void setGameMakerPanel(GameMakerPanel gameMakerPanel) {
		this.gameMakerPanel = gameMakerPanel;
	}

	/**
	 * @return the gamePlayPanel
	 */
	public GamePlayPanel getGamePlayPanel() {
		return gamePlayPanel;
	}

	/**
	 * @param gamePlayPanel
	 *            the gamePlayPanel to set
	 */
	public void setGamePlayPanel(GamePlayPanel gamePlayPanel) {
		this.gamePlayPanel = gamePlayPanel;
	}

	/**
	 * @return the clockPanel
	 */
	public ClockPanel getClockPanel() {
		return clockPanel;
	}

	/**
	 * @param clockPanel
	 *            the clockPanel to set
	 */
	public void setClockPanel(ClockPanel clockPanel) {
		this.clockPanel = clockPanel;
	}

	/**
	 * This method creates a bordered and titled placeholder for the game
	 * screen.
	 */
	private void createGameBoardPanel() {
		gameBoardPanel = new JPanel();
		gameBoardPanel.setLayout(new BorderLayout());
		gameBoardPanel.setBorder(BorderFactory.createTitledBorder("Game Panel"));
		gameBoardPanel.setPreferredSize(new Dimension(Constants.GAME_BOARD_PANEL_WIDTH, Constants.GAME_BOARD_PANEL_HEIGHT));
		gameBoardPanel.setBackground(Constants.defaultColor);
		gameBoardPanel.add(gamePlayPanel, BorderLayout.NORTH);
		gameBoardPanel.add(clockPanel, BorderLayout.SOUTH);
	}
}
