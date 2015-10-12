package com.action;

import java.util.Map;

import com.launcher.Constants;
import com.model.Sprite;

/* This class will help horizontal key press with A and D keys*/
public class MoveEvenWithAD implements Action {

	@Override
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {
		int data = Integer.parseInt(paramMap.get(Constants.DATA).toString());

		if (data == Constants.EVENT_KEY_A){
			for (Sprite sprite : spriteArray) {
				if (sprite.getX() - Constants.HORIZONTAL_DISPLACEMENT < 0)
					sprite.setX(sprite.getX()
							- ((sprite.getX() - Constants.HORIZONTAL_DISPLACEMENT) % Constants.GAME_PLAY_PANEL_WIDTH
									+ Constants.HORIZONTAL_DISPLACEMENT));
				else
					sprite.setX(sprite.getX() - Constants.HORIZONTAL_DISPLACEMENT);
			}
		}
		if (data == Constants.EVENT_KEY_D) {
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

