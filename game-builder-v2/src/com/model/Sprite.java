/**
 * 
 */
package com.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.action.Actions;
import com.action.Animation;
import com.event.Events;
import com.launcher.Constants;

/**
 * This class represents the independent sprite object.
 * 
 * @author team5
 *
 */
public class Sprite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8644334802669672254L;

	transient private Image image;
	private String name;
	private int x;
	private int y;
	private boolean isDestroyed;
	private String imageName;
	private Map<Events, List<Actions>> eventActionMap;
	private Animation animation;
	private int xDir = Constants.INITIAL_X_DIR;
	private int yDir = Constants.INITIAL_Y_DIR;

	/**
	 * @param name
	 * @param x
	 * @param y
	 * @param image
	 * @param imageName
	 * @param eventActionMap
	 */
	public Sprite(String name, int x, int y, Image image, String imageName, Map<Events, List<Actions>> eventActionMap) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.image = image;
		this.imageName = imageName;
		this.eventActionMap = eventActionMap;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @return the eventActionMap
	 */
	public Map<Events, List<Actions>> getEventActionMap() {
		return eventActionMap;
	}

	/**
	 * @param eventActionMap
	 *            the eventActionMap to set
	 */
	public void setEventActionMap(Map<Events, List<Actions>> eventActionMap) {
		this.eventActionMap = eventActionMap;
	}

	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName
	 *            the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * @return the xDir
	 */
	public int getxDir() {
		return xDir;
	}

	/**
	 * @param xDir
	 *            the xDir to set
	 */
	public void setxDir(int xDir) {
		this.xDir = xDir;
	}

	/**
	 * @return the yDir
	 */
	public int getyDir() {
		return yDir;
	}

	/**
	 * @param yDir
	 *            the yDir to set
	 */
	public void setyDir(int yDir) {
		this.yDir = yDir;
	}

	/**
	 * @return the isDestroyed
	 */
	public boolean isDestroyed() {
		return isDestroyed;
	}

	/**
	 * @param isDestroyed
	 *            the isDestroyed to set
	 */
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	/**
	 * This method provides the rectangular bounds of corresponding sprite.
	 * 
	 * @return
	 */
	public Rectangle getRectangle() {
		return new Rectangle(this.x, this.y, this.image.getWidth(null), this.image.getHeight(null));
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
}
