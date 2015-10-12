/**
 * 
 */
package com.action;

import java.util.Map;

import com.launcher.Constants;
import com.model.Sprite;

/**
 * FireAction shoots a bullet sprite from the middle of the parent Sprite.
 * 
 * @author {Ankit, Harini, Jash, Vivek}
 * @file FireAction.java
 * 
 */
public class FireAction implements Action {
	private Sprite spriteObj, bulletSprite;

	private double xCord, yCord, bulletXCord, bulletYCord;
	private double width, height;
	private double angle, spriteCenter;
	private int space = 20;
	private Sprite bulletObj;
	
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {
		spriteObj = spriteArray[0];
		int data = Integer.parseInt(paramMap.get(Constants.DATA).toString());
		xCord = spriteObj.getX();
		yCord = spriteObj.getY();
		width = spriteObj.getImage().getWidth(null);
		height = spriteObj.getImage().getHeight(null);
		bulletXCord = (xCord + width/2); 
		bulletYCord = yCord - space;
		bulletObj = spriteObj.getAttachTo();
		
		if (data == Constants.EVENT_KEY_SPACE) {
			
			bulletObj.setX((int) bulletXCord);
			bulletObj.setY((int) bulletYCord);
			bulletObj.setDestroyed(false);
		}

		
	}

}
