/**
 * 
 */
package com.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.action.Action;
import com.action.Actions;
import com.model.Sprite;

/**
 * This class should be used to implement the actions to be performed on
 * collision between two sprites.
 * 
 * @author team5
 *
 */
public class Collision implements Event {

	private static Collision collision;
	private List<Sprite> attachedSpriteList;
	private Map<Object, Object> paramMap;

	/**
	 * Private constructor to prevent instantiation.
	 */
	private Collision() {
		this.attachedSpriteList = new ArrayList<Sprite>();
		this.paramMap = new HashMap<Object, Object>();
	}

	public static Collision getInstance() {
		if (null == collision) {
			collision = new Collision();
		}
		return collision;
	}

	@Override
	public void addSprite(Sprite sprite) {
		if (!attachedSpriteList.contains(sprite)) {
			attachedSpriteList.add(sprite);
		}
	}

	@Override
	public void triggerAction(int data) {
		for (Sprite sprite1 : attachedSpriteList) {
			for (Sprite sprite2 : attachedSpriteList) {
				if (sprite1.getName() != sprite2.getName() && !sprite1.isDestroyed() && !sprite2.isDestroyed()
						&& sprite1.getRectangle().intersects(sprite2.getRectangle())) {
					executeAction(sprite1, sprite2);
				}
			}
		}
	}

	/**
	 * This method executes all the actions on both the colliding sprites as
	 * listed in the EventActionMAp.
	 * 
	 * @param spriteArray
	 */
	private void executeAction(Sprite... spriteArray) {
		for (Sprite sprite : Arrays.asList(spriteArray)) {
			List<Actions> actionList = sprite.getEventActionMap().get(Events.COLLISION);

			for (Actions action : actionList) {
				Action actionValue = action.getValue();
				if (action.equals(Actions.valueOf("VANISH"))) {
					paramMap.put(Actions.VANISH, sprite);
				}
				action.getValue().performAction(paramMap, spriteArray);
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
