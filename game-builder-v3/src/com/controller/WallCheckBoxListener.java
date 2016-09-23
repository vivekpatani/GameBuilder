package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.launcher.Constants;

/**
 * This class is a collective listener for all Wall CheckBoxes in GameMakerPanel
 * 
 * @author Team5 (Assignment #5)
*/
public class WallCheckBoxListener implements ActionListener {

	private GameController gameControllerObj;
	private WallConfig wallConfigObj;
	
	public WallCheckBoxListener(GameController gameController) {
		this.gameControllerObj = gameController;
		wallConfigObj = gameControllerObj.getGameContainer().getGamePlayPanel().getSavableGameObject().getWallConfig();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox checkBoxObj = (JCheckBox) e.getSource();
		if(checkBoxObj.getText() == Constants.LEFT_WALL) {
			if(checkBoxObj.isSelected())
				wallConfigObj.setLeftWall(true);
			else
				wallConfigObj.setLeftWall(false);
		} else if(checkBoxObj.getText() == Constants.RIGHT_WALL) {
			if(checkBoxObj.isSelected())
				wallConfigObj.setRightWall(true);
			else
				wallConfigObj.setRightWall(false);
		} else if(checkBoxObj.getText() == Constants.TOP_WALL) {
			if(checkBoxObj.isSelected())
				wallConfigObj.setTopWall(true);
			else
				wallConfigObj.setTopWall(false);
		} else if (checkBoxObj.getText() == Constants.BOTTOM_WALL) {
			if(checkBoxObj.isSelected()) 
				wallConfigObj.setBottomWall(true);
			else
				wallConfigObj.setBottomWall(false);
		}
		
		gameControllerObj.getGameContainer().getGamePlayPanel().getSavableGameObject().setWallConfig(wallConfigObj);
	}

}
