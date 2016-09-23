package com.ui;

import org.junit.Before;
import org.junit.Test;

import com.command.CreateCommand;
import com.controller.GameController;

import junit.framework.Assert;

public class CreateCommandTest {

	private GameMakerPanel gameMakerPanel;
	private GameContainer gameContainer;
	private GameController gameController;

	@Before
	public void setup() {
		gameMakerPanel = new GameMakerPanel();
		gameContainer = new GameContainer();
		gameContainer.setGameMakerPanel(gameMakerPanel);
		gameController = new GameController(gameContainer);
	}

	@Test
	public void testCreateCommand_Success() {
		gameMakerPanel.getSpriteNameTextField().setText("sample1");
		gameMakerPanel.getxPositionTextField().setText("20");
		gameMakerPanel.getyPositionTextField().setText("50");
		gameMakerPanel.setSelectedImage("ball.png");
		new CreateCommand(gameController).executeCommand();
		Assert.assertTrue(
				gameController.getGameContainer().getGamePlayPanel().getSavableGameObject().getSpriteList().size() > 0);
	}

	/*
	 * @Test public void testCreateCommand_Failure1() { CreateCommand cmd = new
	 * CreateCommand(gameController);
	 * 
	 * gameMakerPanel.getSpriteNameTextField().setText("sample1");
	 * gameMakerPanel.getxPositionTextField().setText("m");
	 * gameMakerPanel.getyPositionTextField().setText("50");
	 * gameMakerPanel.setSelectedImage("ball.png");
	 * 
	 * try { PowerMockito.doNothing().when(cmd, "displayErrorMessageDialog",
	 * Mockito.anyString()); } catch (Exception e) { e.printStackTrace(); }
	 * cmd.executeCommand();
	 * Assert.assertTrue(gameController.getGameContainer().getGamePlayPanel().
	 * getSpriteList().size() == 0); }
	 */
}
