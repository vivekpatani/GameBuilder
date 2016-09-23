/**
 * 
 */
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class listens to actions on background comboo box selection  button and redirects control to
 * create com.command to execute the request.
 * 
 * @author team5
 *
 */
public class BackGroundChangeListener implements ActionListener {

	private GameController gameController;

	public BackGroundChangeListener(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameController.getBackGroundChangeCommand().executeCommand();

	}

}
