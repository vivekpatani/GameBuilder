/**
 * 
 */
package com.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.action.Actions;
import com.model.Sprite;

/**
 * This class should be used to implement actions that need to be performed as
 * time changes.
 * 
 * @author team5
 *
 */
public class TimeChange implements Event {

	private static TimeChange timeChange;
	private List<Sprite> attachedSpriteList;
	private Map<Object, Object> paramMap;

	/**
	 * Private constructor to prevent instantiation.
	 */
	private TimeChange() {
		this.attachedSpriteList = new ArrayList<Sprite>();
		this.paramMap = new HashMap<Object, Object>();
	}

	public static TimeChange getInstance() {
		if (null == timeChange) {
			timeChange = new TimeChange();
		}
		return timeChange;
	}

	@Override
	public void addSprite(Sprite sprite) {
		if (!attachedSpriteList.contains(sprite)) {
			attachedSpriteList.add(sprite);
		}
	}

	@Override
	public void triggerAction(int data) {
		for (Sprite sprite : attachedSpriteList) {
			for (Actions action : sprite.getEventActionMap().get(Events.TIMECHANGE)) {
				action.getValue().performAction(paramMap, sprite);
			}
		}
	}

	@Override
	public void populateParameterMap(Map<Object, Object> paramMap) {
		this.paramMap.putAll(paramMap);
	}

	@Override
	public Map<Object, Object> fetchParameterMap() {
		return paramMap;
	}
}
