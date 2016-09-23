/**
 * 
 */
package com.event;

/**
 * This Enum holds the values of all possible events.
 * 
 * @author team5
 *
 */
public enum Events {
	COLLISION(Collision.getInstance()), TIMECHANGE(TimeChange.getInstance()), KEYPRESS(KeyPress.getInstance());

	private Event value;

	private Events(Event value) {
		this.value = value;
	}

	public Event getValue() {
		return value;
	}
}
