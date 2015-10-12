/**
 * 
 */
package com.ui;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hp
 *
 */
public class Common {
	public static Object invokeMethod(String methodName, Object gameCommand) {
		Method method;
		Object returnObj = null;
		try {
			method = gameCommand.getClass().getDeclaredMethod(methodName);
			method.setAccessible(true);
			returnObj = method.invoke(gameCommand);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return returnObj;
	}

	public static Object invokeMethodWithParam(String methodName, GameMakerPanel board, Class[] param, int... x) {
		Method method;
		Object returnObj = null;
		try {
			method = GameMakerPanel.class.getDeclaredMethod(methodName, param);
			method.setAccessible(true);
			if (x.length == 0) {
				returnObj = method.invoke(board);
			} else {
				returnObj = method.invoke(board, x[0], x[1]);
			}

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return returnObj;
	}

	public static Object getFieldValue(String fieldName, Object gameCommand) {
		Object returnObj = null;
		Field field;
		try {
			field = GameMakerPanel.class.getDeclaredField(fieldName);
			field.setAccessible(true);
			returnObj = field.get(gameCommand);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return returnObj;
	}

	public static void setFieldValue(String fieldName, int fieldValue, Object board) {
		Field field;
		try {
			field = board.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(board, fieldValue);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}