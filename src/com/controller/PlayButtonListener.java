/**
 * 
 */
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author team5
 *
 */
public class PlayButtonListener implements ActionListener {

	private GameController gameController;

	public PlayButtonListener(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameController.getPlayCommand().executeCommand();
	}
}
