/**
 * 
 */
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author {Abhijeet, Ankit, Jaini, Rohith, Vivek}
 * @file DeleteButtonListener.java
 * {GameBuilder 0.9 : Living in Beta}
 */
public class DeleteButtonListener implements ActionListener {

	private GameController gameController;

	public DeleteButtonListener(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gameController.getDeleteCommand().executeCommand();
	}
}