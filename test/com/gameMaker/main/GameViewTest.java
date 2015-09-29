package com.gameMaker.main;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gameMaker.main.GameView;
import com.gameMaker.main.Overseer;

public class GameViewTest {


	private JFrame testFrame;
	private Overseer overseerObj;
	private GameView gameViewObj;
	
	@Before
	public void setUp() throws Exception {
		testFrame = new JFrame();
		overseerObj = new Overseer(testFrame);
		overseerObj.init();
		
		gameViewObj = new GameView (overseerObj.getGamePanel());
	}

	@Test
	public void testGameView() {
		Assert.assertEquals(overseerObj.getGamePanel(), gameViewObj.getGamePanel());
	}

}
