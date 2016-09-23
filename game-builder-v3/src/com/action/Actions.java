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
	MOVEUP(new MoveUp()),
	CHANGEDIRECTION(new ChangeDirection()), 
	MOVEEVENWITHLR(new MoveEvenWithLR()), 
	MOVEEVENWITHAD(new MoveEvenWithAD()), 
	MOVEVERTICALWITHUD(new MoveVerticalWithUD()), 
	MOVEVERTICALWITHWX(new MoveVerticalWithWX()), 
	PLAYSOUND(new PlaySound()),
	MOVEANDROTATE(new MoveAndRotate()),
	VANISH(new Vanish()),
	DONOTHING(new DoNothing()),
	FIREACTION(new FireAction());

	private Action value;

	private Actions(Action value) {
		this.value = value;
	}

	public Action getValue() {
		return value;
	}
}
