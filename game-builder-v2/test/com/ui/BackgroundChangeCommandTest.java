/**
 * 
 */
package com.ui;

import org.junit.Test;

import com.command.BackgroundChangeCommand;
import com.controller.GameController;

import junit.framework.Assert;

/**
 * @author team5
 *
 */
public class BackgroundChangeCommandTest {
	GameContainer container = new GameContainer();
	BackgroundChangeCommand cmd = new BackgroundChangeCommand(new GameController(container));

	@Test
	public void testBackgroundChangeCommand() {
		container.getGameMakerPanel().getBackgroundImageComboBox().setSelectedIndex(2);
		cmd.executeCommand();
		Assert.assertTrue(container.getGamePlayPanel().getSavableGameObject().getBackgroudImage().getSource() != null);

	}
}
