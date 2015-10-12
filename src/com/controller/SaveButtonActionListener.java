/**
 * 
 */
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class listens to actions on save button and directs control to save
 * command.
 * 
 * @author team5
 *
 */
public class SaveButtonActionListener implements ActionListener {

	private GameController gameController;

	public SaveButtonActionListener(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameController.getSaveCommand().executeCommand();
	}
}
