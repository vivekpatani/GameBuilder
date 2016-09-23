/**
 * 
 */
package com.command;

import com.controller.GameController;
import com.event.KeyPress;
import com.model.Sprite;
import com.observer.Clock;

/**
 * This command launches the game created by user.
 * 
 * @author team5
 *
 */
public class PlayCommand implements Command {
	private GameController gameController;

	public PlayCommand(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void executeCommand() {
		Clock clock = Clock.getInstance();
		KeyPress keyPress = KeyPress.getInstance();
		
		String loosingSprite = (String) gameController.getGameContainer().getGameMakerPanel().getLoosingSpriteComboBox().getSelectedItem();
		for(Sprite spriteObj : gameController.getGameContainer().getGamePlayPanel().getSavableGameObject().getSpriteList()) {
			if(loosingSprite.equals(spriteObj.getName())) {
				spriteObj.setLoosingProperty(true);
			}
		}

		gameController.getGameContainer().getGamePlayPanel().addObserver(keyPress);
		clock.addObserver(gameController.getGameContainer().getGamePlayPanel());
		clock.addObserver(gameController.getGameContainer().getClockPanel());

		clock.reset();

		gameController.getGameContainer().getGamePlayPanel().requestFocusInWindow();
	}
}
