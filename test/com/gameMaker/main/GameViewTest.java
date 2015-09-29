package com.gameMaker.main;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gameMaker.main.GameView;
import com.gameMaker.main.Overseer;
import com.gameMaker.util.Constants;

public class GameViewTest {


	private JFrame testFrame;
	private Overseer overseerObj;
	private GameView gameViewObj;
	private Boolean booleanFlag;
	private JLabel testLabel;
	
	@Before
	public void setUp() throws Exception {
		testFrame = new JFrame();
		overseerObj = new Overseer(testFrame);
		gameViewObj = new GameView (overseerObj);
		testLabel = new JLabel("Test");
		testLabel.setBounds(Constants.ySpace, Constants.ySpace, 20, 20);
		gameViewObj.addToPanel(testLabel);
	}

	@Test
	public void testAddToPanel() {
		if(testLabel.getParent() == gameViewObj)
			booleanFlag = true;
		else
			booleanFlag = false;
		
		Assert.assertTrue(booleanFlag);
	}
	
	@Test
	public void testGetGamePanel() {
		Assert.assertEquals(gameViewObj, gameViewObj.getGamePanel());
	}

}
