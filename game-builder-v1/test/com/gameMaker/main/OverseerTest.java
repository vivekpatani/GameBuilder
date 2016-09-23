package com.gameMaker.main;

import static org.junit.Assert.fail;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gameMaker.main.Overseer;
import com.gameMaker.util.KeyEventWrapper;

public class OverseerTest {

	private JFrame testFrame;
	private Overseer overseerObj;
	
	private KeyEventWrapper tempKey, compareKey;
	
	@Before
	public void setUp() throws Exception {
		testFrame = new JFrame();
		overseerObj = new Overseer(testFrame);
		tempKey = new KeyEventWrapper(new KeyEvent(testFrame, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED));
	}

	@Test
	public void testGetMainFrame() {
		Assert.assertSame(overseerObj.getMainFrame(), testFrame);
	}

	@Test
	public void testSetLeftMoveKey() {
		overseerObj.setLeftMoveKey(tempKey);
		Assert.assertEquals(overseerObj.getLeftMoveKey(), tempKey);
	}

	@Test
	public void testGetLeftMoveKey() {
		overseerObj.setLeftMoveKey(tempKey);
		compareKey = overseerObj.getLeftMoveKey();
		Assert.assertEquals(compareKey, tempKey);
	}

	@Test
	public void testSetRightMoveKey() {
		overseerObj.setRightMoveKey(tempKey);
		Assert.assertEquals(overseerObj.getRightMoveKey(), tempKey);
	}

	@Test
	public void testGetRightMoveKey() {
		overseerObj.setRightMoveKey(tempKey);
		compareKey = overseerObj.getRightMoveKey();
		Assert.assertEquals(compareKey, tempKey);
	}

}
