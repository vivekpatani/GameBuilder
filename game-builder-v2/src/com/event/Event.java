/**
 * 
 */
package com.event;

import java.util.Map;

import com.model.Sprite;

/**
 * This interface should be implemented by all the event classes to specify
 * respective events.
 * 
 * @author team5
 *
 */
public interface Event {
	/**
	 * This method should be implemented by all events to bind the specified
	 * sprite to the event.
	 * 
	 * @param sprite
	 */
	public void addSprite(Sprite sprite);

	/**
	 * This method should be implemented by all the Event classes and should be
	 * used to invoke actions corresponding to all the events for a given
	 * sprite.
	 */
	public void triggerAction(int data);

	/**
	 * This method can be used to populate any action specific parameters in the
	 * paramMap.
	 */
	public void populateParameterMap(Map<Object, Object> paramMap);

	/**
	 * This method can be used to fetch event parameter map of any concrete
	 * event class.
	 */
	public Map<Object, Object> fetchParameterMap();
}
