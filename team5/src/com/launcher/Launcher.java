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
 * @author team5
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	final static Logger log = Logger.getLogger(Launcher.class);
	public static void main(String[] args) {
		GameContainer gameContainer = new GameContainer();
		new GameController(gameContainer);
		gameContainer.setVisible(true);
		
		try {
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			gameContainer.setLocation(dim.width/2 - gameContainer.getSize().width/2, dim.height/2 - gameContainer.getSize().height/2);
        } 
        catch (Exception e) {
            log.error("Error Message : ", e);
        }
	}
}
