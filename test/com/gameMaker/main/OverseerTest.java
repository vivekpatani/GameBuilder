package com.gameMaker.main;

import javax.swing.JFrame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gameMaker.main.Overseer;

public class OverseerTest {

	private JFrame testFrame;
	private Overseer overseerObj;
	
	@Before
	public void setUp() throws Exception {
		testFrame = new JFrame();
		overseerObj = new Overseer(testFrame);
	}

	@Test
	public void testOverseer() {
		Assert.assertSame(overseerObj.getMainFrame(), testFrame);
	}
}
