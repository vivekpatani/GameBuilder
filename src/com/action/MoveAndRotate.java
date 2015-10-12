package com.action;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Map;

import com.launcher.Constants;
import com.model.Sprite;

/**
 * 
*/
public class MoveAndRotate implements Action {
	private double imageCenterX;
	private double imageCenterY;
	private double cordX;
	private double cordY;
	private double velocity = 2;
	private double currentAngle;
	private double setAngleDegree;
	private Sprite sprite;

	public MoveAndRotate(Sprite sprite) {
		this.sprite = sprite;
		cordY = sprite.getY();
		cordX = sprite.getX();
		imageCenterX = cordX + (sprite.getImage().getWidth(null)) / 2;
		imageCenterY = cordY + (sprite.getImage().getHeight(null)) / 2;
		currentAngle = sprite.getCurrentAngle();
	}

	public MoveAndRotate() {
	}

	@Override
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray) {
		int data = Integer.parseInt(paramMap.get(Constants.DATA).toString());
		if (data == Constants.EVENT_KEY_RIGHT) {
			for (Sprite sprite : spriteArray) {
				if (!sprite.getName().contains("bullet")) {
					cordY = sprite.getY();
					cordX = sprite.getX();
					imageCenterX = cordX + (sprite.getImage().getWidth(null)) / 2;
					imageCenterY = cordY + (sprite.getImage().getHeight(null)) / 2;
					currentAngle = sprite.getCurrentAngle();
					rotateRight();
					setValues(sprite);
				}
			}

		} else if (data == Constants.EVENT_KEY_LEFT) {
			for (Sprite sprite : spriteArray) {
				if (!sprite.getName().contains("bullet")) {
					rotateLeft();
					setValues(sprite);
				}
			}
		} else if (data == Constants.EVENT_KEY_UP) {
			for (Sprite sprite : spriteArray) {
				if (!sprite.getName().contains("bullet")) {
					translate();
					setValues(sprite);
				}
			}
		}

	}

	private void translate() {
		setAngleDegree = 90 - currentAngle;
		cordX += velocity * Math.cos(Math.toRadians(setAngleDegree));
		cordY -= velocity * Math.sin(Math.toRadians(setAngleDegree));
		imageCenterX += velocity * Math.cos(Math.toRadians(setAngleDegree));
		imageCenterY -= velocity * Math.sin(Math.toRadians(setAngleDegree));

	}

	private void rotateLeft() {
		currentAngle -= 5.0;
		if (currentAngle >= 360.0) {
			currentAngle = 0;
		}
	}

	private void rotateRight() {
		// rotate 5 degrees at a time
		currentAngle += 5.0;
		if (currentAngle >= 360.0) {
			currentAngle = 0;
		}
	}

	public void setValues(Sprite sprite) {
		sprite.setCurrentAngle(currentAngle);
		sprite.setX((int) cordX);
		sprite.setY((int) cordY);
	}

	public void animation(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		AffineTransform origXform = g2d.getTransform();
		AffineTransform newXform = (AffineTransform) (origXform.clone());

		// center of rotation is center of the panel
		newXform.rotate(Math.toRadians(currentAngle), imageCenterX, imageCenterY);
		g2d.setTransform(newXform);

		cordX = Math.round(cordX);
		cordY = Math.round(cordY);

		// draw image in panel

		g2d.drawImage(this.sprite.getImage(), (int) cordX, (int) cordY, null);
		// g2d.translate(imageCenterX, imageCenterY);
	}

}
