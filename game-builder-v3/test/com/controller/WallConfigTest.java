package com.controller;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WallConfigTest {
	
	private WallConfig wallConfigObj;
	private boolean testBoolean;

	@Before
	public void setUp() throws Exception {
		wallConfigObj = new WallConfig();
		testBoolean = false;
	}

	@Test
	public void testGetWallConfig() {
		Assert.assertTrue(wallConfigObj.getLeftWall());
		Assert.assertTrue(wallConfigObj.getRightWall());
		Assert.assertTrue(wallConfigObj.getTopWall());
		Assert.assertTrue(wallConfigObj.getBottomWall());
	}

	@Test
	public void testSetWallConfig() {
		wallConfigObj.setLeftWall(testBoolean);
		wallConfigObj.setRightWall(testBoolean);
		wallConfigObj.setTopWall(testBoolean);
		wallConfigObj.setBottomWall(testBoolean);
		Assert.assertFalse(wallConfigObj.getLeftWall());
		Assert.assertFalse(wallConfigObj.getRightWall());
		Assert.assertFalse(wallConfigObj.getTopWall());
		Assert.assertFalse(wallConfigObj.getBottomWall());
	}

}
