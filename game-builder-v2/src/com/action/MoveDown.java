package com.action;

import java.util.Map;

import com.model.Sprite;

public class MoveDown implements Action {
	@Override
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {
		Sprite sprite = spriteArray[0];
		sprite.setY(sprite.getY() + sprite.getyDir());

		if (sprite.getY() <= 0) {
			sprite.setyDir(1);
		}
	}
}
