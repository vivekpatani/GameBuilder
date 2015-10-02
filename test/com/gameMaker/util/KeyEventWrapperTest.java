package com.gameMaker.util;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KeyEventWrapperTest {
	
	private JPanel tempPanel;
	private KeyEventWrapper testKey, compareKey;
	private KeyEvent testEvent;
	private String testString;

	@Before
	public void setUp() throws Exception {
		tempPanel = new JPanel();
		testKey = new KeyEventWrapper(new KeyEvent(tempPanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED));
	}

	@Test
	public void testKeyEventWrapper() {
		compareKey = new KeyEventWrapper(new KeyEvent(tempPanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED));
		Assert.assertNotSame(testKey, compareKey);
	}

	@Test
	public void testEqualsObject() {
		compareKey = new KeyEventWrapper(new KeyEvent(tempPanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED));
		Assert.assertEquals(testKey, compareKey);
	}

	@Test
	public void testGetKeyCode() {
		Assert.assertEquals(testKey.getKeyCode(), KeyEvent.VK_DOWN);
	}

	@Test
	public void testGetKeyString() {
		testString = "DOWN";
		Assert.assertEquals(testString, testKey.getKeyString());
	}

	@Test
	public void testGetKeyEvent() {
		testEvent = new KeyEvent(tempPanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
		compareKey = new KeyEventWrapper(testEvent);
		Assert.assertEquals(testEvent, compareKey.getKeyEvent());
	}

}
