/**
 * 
 */
package com.action;

import java.awt.Rectangle;
import java.util.Map;

import com.model.Sprite;

/**
 * This class should implement the direction change functionality to be
 * performed on related event occurrence.
 * 
 * @author team5
 *
 */
public class ChangeDirection implements Action {

	@Override
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {

		Sprite sprite1 = spriteArray[0];
		Sprite sprite2 = spriteArray[1];

		Rectangle r1 = sprite1.getRectangle();
		double x1 = r1.getX();
		double y1 = r1.getY();
		double width1 = r1.getWidth();
		double height1 = r1.getHeight();

		Rectangle r2 = sprite2.getRectangle();
		double x2 = r2.getX();
		double y2 = r2.getY();
		double width2 = r2.getWidth();
		double height2 = r2.getHeight();

		int collisionIdentifier = 0;
		// check is sprite1 collides with Bottom of sprite2
		if ((x1 + width1 >= x2) && (x1 <= x2 + width2) && (y1 + 1 == y2 + height2)) {
			collisionIdentifier = 1;
		}
		// check is sprite1 collides with Top of sprite2
		if ((x1 + width1 >= x2) && (x1 <= x2 + width2) && (y1 + height1 == y2 + 1)) {
			collisionIdentifier = 1;
		}
		// check is sprite1 collides with Left of sprite2
		if ((y1 + height1 >= y2) && (y1 <= y2 + height2) && (x1 + width1 == x2 + 1)) {
			collisionIdentifier = 2;
		}
		// check is sprite1 collides with Right of sprite2
		if ((y1 + height1 >= y2) && (y1 <= y2 + height2) && (x1 + 1 == x2 + width2)) {
			collisionIdentifier = 2;
		}

		if (collisionIdentifier == 1) {
			sprite1.setyDir(-1 * sprite1.getyDir());
		} else if (collisionIdentifier == 2) {
			sprite1.setxDir(-1 * sprite1.getxDir());
		} else if (collisionIdentifier == 3) {
			sprite1.setxDir(-1 * sprite1.getxDir());
			sprite1.setyDir(-1 * sprite1.getyDir());
		}
	}
}
