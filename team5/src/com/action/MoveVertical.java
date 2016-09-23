package com.action;

import java.util.Map;

import com.launcher.Constants;
import com.model.Sprite;

public class MoveVertical implements Action {

	@Override
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {
		int data = Integer.parseInt(paramMap.get(Constants.DATA).toString());

		if (data == Constants.EVENT_KEY_UP) {
			for (Sprite sprite : spriteArray) {
				if ((sprite.getY() - Constants.VERTICAL_DISPLACEMENT) <= 0) {
					sprite.setY(0);
				} else {
					sprite.setY(sprite.getY() - Constants.VERTICAL_DISPLACEMENT);
				}

			}
		}
		if (data == Constants.EVENT_KEY_DOWN) {
			for (Sprite sprite : spriteArray) {
				if ((sprite.getY() + sprite.getRectangle().getHeight()
						+ Constants.VERTICAL_DISPLACEMENT) >= Constants.GAME_PLAY_PANEL_HEIGHT) {
					sprite.setY(Constants.GAME_PLAY_PANEL_HEIGHT - sprite.getImage().getHeight(null));
				} else {
					sprite.setY(sprite.getY() + Constants.VERTICAL_DISPLACEMENT);
				}
			}
		}
	}
}
