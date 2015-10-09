/**
 * 
 */
package com.action;


/**
 * This Enum holds the values for all possible actions.
 * 
 * @author team5
 *
 */
public enum Actions {
	AUTOMOVE(new AutoMove()), 
	MOVEDOWN(new MoveDown()),
	CHANGEDIRECTION(new ChangeDirection()), 
	MOVEHORIZONTAL(new MoveHorizontal()), 
	MOVEVERTICAL(new MoveVertical()), 
	PLAYSOUND(new PlaySound()), 
	VANISH(new Vanish());

	private Action value;

	private Actions(Action value) {
		this.value = value;
	}

	public Action getValue() {
		return value;
	}
}
