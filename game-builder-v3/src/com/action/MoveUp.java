package com.action;

import java.util.Map;

import com.model.Sprite;


/**
 * @author {AnVivekkit, Harin, Jash, Vivek}
 * @file MoveUp.java - Used 
 * {GameBuilder 0.9 : Living in Beta}
 */

public class MoveUp implements Action {
		@Override
		public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {
			Sprite sprite = spriteArray[0];
			sprite.setY(sprite.getY() - sprite.getyDir());

				sprite.setyDir(1);
				
		}
	}