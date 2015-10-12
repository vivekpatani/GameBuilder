/**
 * 
 */
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class listens to attach button actions and directs control to attach
 * com.command to associate events and actions to a given sprite.
 * 
 * @author team5
 *
 */
public class AttachButtonListener implements ActionListener {
	private GameController gameController;

	public AttachButtonListener(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameController.getAttachCommand().executeCommand();
	}

}
