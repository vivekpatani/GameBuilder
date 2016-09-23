/**
 * 
 */
package com.action;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Map;

import com.event.Events;
import com.model.Sprite;

/**
 * This class implements vanish action on specified sprite so that the sprite
 * will not appear in the game panel on canvas repaint.
 * 
 * @author team5
 *
 */
public class Vanish implements Action {
	
	private Animation animation;
	
	@Override
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {
		for (Sprite sprite : spriteArray) {
			if (sprite.getEventActionMap().get(Events.COLLISION).contains(Actions.VANISH)) {
				sprite.setDestroyed(true);
				try {
					this.animation = new Animation(sprite.getX(), sprite.getY());
					sprite.setAnimation(this.animation);
				} catch (IOException e) {
					
				}
			}
		}
	}
	
	public void draw(Graphics g, Sprite sprite) {
		sprite.getAnimation().draw(g);
	}

}
