/**
 * 
 */
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class listens to actions on display clock checkbox
 * 
 * @author team5
 *
 */
public class AddClockListener implements ActionListener {

	private GameController gameController;

	public AddClockListener(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameController.getAddClockCommand().executeCommand();
	}
}
