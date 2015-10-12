/**
 * 
 */
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class listens to actions on create button and redirects control to
 * create com.command to execute the request.
 * 
 * @author team5
 *
 */
public class CreateSpriteListener implements ActionListener {

	private GameController gameController;

	public CreateSpriteListener(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gameController.getCreateCommand().executeCommand();
	}

}
