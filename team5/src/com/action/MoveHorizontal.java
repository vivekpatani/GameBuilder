/**
 * 
 */
package com.action;

import java.util.Map;

import com.launcher.Constants;
import com.model.Sprite;

/**
 * This class should be used to implement horizontal movement action for the
 * specified sprite.
 * 
 * @author team5
 *
 */
public class MoveHorizontal implements Action {

	@Override
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {
		int data = Integer.parseInt(paramMap.get(Constants.DATA).toString());

		if (data == Constants.EVENT_KEY_LEFT) {
			for (Sprite sprite : spriteArray) {
				if (sprite.getX() - Constants.HORIZONTAL_DISPLACEMENT < 0)
					sprite.setX(sprite.getX()
							- ((sprite.getX() - Constants.HORIZONTAL_DISPLACEMENT) % Constants.GAME_PLAY_PANEL_WIDTH
									+ Constants.HORIZONTAL_DISPLACEMENT));
				else
					sprite.setX(sprite.getX() - Constants.HORIZONTAL_DISPLACEMENT);
			}
		}
		if (data == Constants.EVENT_KEY_RIGHT) {
			for (Sprite sprite : spriteArray) {
				if (sprite.getX() + Constants.HORIZONTAL_DISPLACEMENT
						+ sprite.getImage().getWidth(null) > Constants.GAME_PLAY_PANEL_WIDTH)
					sprite.setX(sprite.getX() + Constants.HORIZONTAL_DISPLACEMENT
							- ((sprite.getX() + Constants.HORIZONTAL_DISPLACEMENT + sprite.getImage().getWidth(null))
									% Constants.GAME_PLAY_PANEL_WIDTH));
				else
					sprite.setX(sprite.getX() + Constants.HORIZONTAL_DISPLACEMENT);
			}
		}
	}
}
