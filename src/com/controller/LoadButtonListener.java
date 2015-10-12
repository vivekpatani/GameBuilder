/**
 * 
 */
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class listens to actions on load button and directs control to load
 * command.
 * 
 * @author team5
 *
 */
public class LoadButtonListener implements ActionListener {

	private GameController gameController;

	public LoadButtonListener(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameController.getLoadCommand().executeCommand();
	}
}
