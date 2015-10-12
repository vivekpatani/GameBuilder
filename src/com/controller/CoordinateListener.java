package com.controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CoordinateListener implements DocumentListener {

	private GameController gameControllerObj;
	private int xCord, yCord;
	private String xString, yString;
	
	public CoordinateListener (GameController gameControllerObj) {
		this.gameControllerObj = gameControllerObj;
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		xString = gameControllerObj.getGameContainer().getGameMakerPanel().getxPositionTextField().getText();
		yString = gameControllerObj.getGameContainer().getGameMakerPanel().getyPositionTextField().getText();
		if(!xString.isEmpty() && !yString.isEmpty()) {
			xCord = Integer.parseInt(xString);
			yCord = Integer.parseInt(yString);
			gameControllerObj.getGameContainer().getGamePlayPanel().drawCordinates(xCord, yCord);
		}
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
