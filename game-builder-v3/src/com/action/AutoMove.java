/**
 * 
 */
package com.action;

import java.util.Map;

import com.launcher.Constants;
import com.model.Sprite;

/**
 * This class should be used to implement move action for the specified sprite.
 * 
 * @author team5
 *
 */
public class AutoMove implements Action {

	@Override
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {
		Sprite sprite = spriteArray[0];
		sprite.setX(sprite.getX() + sprite.getxDir());
		sprite.setY(sprite.getY() + sprite.getyDir());

		if (sprite.getX() < 0) {
			sprite.setX(0);
			sprite.setxDir(1);
		}

		if (sprite.getX() + sprite.getRectangle().getWidth() >= Constants.GAME_PLAY_PANEL_WIDTH) {
			sprite.setX((int) (Constants.GAME_PLAY_PANEL_WIDTH - sprite.getRectangle().getWidth()));
			sprite.setxDir(-1);
		}

		if (sprite.getY() < 0) {
			sprite.setY(0);
			sprite.setyDir(1);
		}
		
		if(sprite.getY() + sprite.getRectangle().getHeight() >= Constants.GAME_PLAY_PANEL_HEIGHT) {
			sprite.setY((int) (Constants.GAME_PLAY_PANEL_HEIGHT - sprite.getRectangle().getHeight()));
			sprite.setyDir(-1);
		}
	}

}
