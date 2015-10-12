package com.ui;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class GameMakerPanelTest {

	private GameMakerPanel gameMakerPanel;

	@Before
	public void setup() {
		gameMakerPanel = new GameMakerPanel();
	}

	@Test
	public void testInit() {
		Assert.assertTrue(Common.getFieldValue("spritePanel", gameMakerPanel) != null);
	}
}
