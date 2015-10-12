/**
 * 
 */
package com.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.action.Actions;
import com.launcher.Constants;
import com.model.Sprite;
import com.observer.GenericObserver;

/**
 * This class should be used to implement actions to be performed when Keyboard
 * events are captured.
 * 
 * @author team5
 *
 */
public class KeyPress implements Event, GenericObserver<Integer> {

	private static KeyPress keyPress;
	private List<Sprite> attachedSpriteList;
	private Map<Object, Object> paramMap;

	/**
	 * Private constructor to prevent instantiation.
	 */
	private KeyPress() {
		this.attachedSpriteList = new ArrayList<Sprite>();
		this.paramMap = new HashMap<Object, Object>();
	}

	public static KeyPress getInstance() {
		if (null == keyPress) {
			keyPress = new KeyPress();
		}
		return keyPress;
	}

	@Override
	public void addSprite(Sprite sprite) {
		if (!attachedSpriteList.contains(sprite)) {
			attachedSpriteList.add(sprite);
		}
	}

	@Override
	public void triggerAction(int data) {
		paramMap.put(Constants.DATA, data);
		for (Sprite sprite : attachedSpriteList) {
			for (Actions action : sprite.getEventActionMap().get(Events.KEYPRESS)) {
				action.getValue().performAction(paramMap, sprite);
			}
		}
	}

	@Override
	public void update(Integer... data) {
		triggerAction(data[0]);
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
