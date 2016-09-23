/**
 * 
 */
package com.model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This object is used to save the game maker state and stores the list of
 * sprites created by user.
 * 
 * @author team5
 *
 */
public class SavableGameObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8175288920817406356L;
	transient private Image backgroudImage;
	private List<Sprite> spriteList;
	private Map<Object, Map<Object, Object>> eventParameterMap;
	private String backgroudImageName;
	private boolean addClock;
	private boolean isGameOver;

	/**
	 * Constructor
	 * 
	 */
	public SavableGameObject() {
		this.spriteList = new ArrayList<Sprite>();
	}

	/**
	 * @return the spriteList
	 */
	public List<Sprite> getSpriteList() {
		return spriteList;
	}

	/**
	 * @param spriteList
	 *            the spriteList to set
	 */
	public void setSpriteList(List<Sprite> spriteList) {
		this.spriteList = spriteList;
	}

	/**
	 * @return the backgroudImage
	 */
	public Image getBackgroudImage() {
		return backgroudImage;
	}

	/**
	 * @param backgroudImage
	 *            the backgroudImage to set
	 */
	public void setBackgroudImage(Image backgroudImage) {
		this.backgroudImage = backgroudImage;
	}

	/**
	 * @return the backgroudImageName
	 */
	public String getBackgroudImageName() {
		return backgroudImageName;
	}

	/**
	 * @param backgroudImageName
	 *            the backgroudImageName to set
	 */
	public void setBackgroudImageName(String backgroudImageName) {
		this.backgroudImageName = backgroudImageName;
	}

	/**
	 * @return the eventParameterMap
	 */
	public Map<Object, Map<Object, Object>> getEventParameterMap() {
		return eventParameterMap;
	}

	/**
	 * @param eventParameterMap
	 *            the eventParameterMap to set
	 */
	public void setEventParameterMap(Map<Object, Map<Object, Object>> eventParameterMap) {
		this.eventParameterMap = eventParameterMap;
	}

	/**
	 * @return the addClock
	 */
	public boolean isAddClock() {
		return addClock;
	}

	/**
	 * @param addClock
	 *            the addClock to set
	 */
	public void setAddClock(boolean addClock) {
		this.addClock = addClock;
	}

	/**
	 * @return the isGameOver
	 */
	public boolean isGameOver() {
		return isGameOver;
	}

	/**
	 * @param isGameOver
	 *            the isGameOver to set
	 */
	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
}
