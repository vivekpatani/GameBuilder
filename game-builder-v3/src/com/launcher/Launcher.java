/**
 * 
 */
package com.launcher;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.apache.log4j.Logger;

import com.controller.GameController;
import com.ui.GameContainer;

/**
 * This class launches the game maker application.
 * 
 * @author Team5 (Assignment #5)
 *
 */
public class Launcher {

	private final static Logger log = Logger.getLogger(Launcher.class);
	public static void main(String[] args) {
		GameContainer gameContainer = new GameContainer();
		new GameController(gameContainer);
		gameContainer.setVisible(true);
		
		try {
			// Getting the screen size
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			// Placing the gameContainer (frame) in the middle of the screen
			gameContainer.setLocation(dim.width/2 - gameContainer.getSize().width/2, dim.height/2 - gameContainer.getSize().height/2);
			gameContainer.setTitle("GameMaker v1.8");
        } 
        catch (Exception e) {
            log.error("Error Message : ", e);
        }
	}
}
