/**
 * 
 */
package com.action;

import java.util.Map;

import com.model.Sprite;

/**
 * This interface should be implemented by all the action classes to specify
 * respective action.
 * 
 * @author team5
 *
 */
public interface Action {
	/**
	 * This method should be implemented by all the Action classes to specify
	 * respective action implementation.
	 * 
	 * @param spriteArray
	 * @param paramMap
	 * 
	 */
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteArray);
}
