/**
 * 
 */
package com.command;

import javax.swing.JCheckBox;

import com.controller.GameController;

/**
 * This class adds/removes clock panel from the game display
 * 
 * @author team5
 *
 */
public class AddClockCommand implements Command {
	private GameController gameController;

	public AddClockCommand(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void executeCommand() {
		JCheckBox clockCheckBox = (JCheckBox) gameController.getGameContainer().getGameMakerPanel()
				.getAddClockCheckbox();

		boolean addFlag = false;
		if (clockCheckBox.isSelected()) {
			addFlag = true;
		}
		gameController.getGameContainer().getClockPanel().getClockLabel().setVisible(addFlag);
		gameController.getGameContainer().getGamePlayPanel().getSavableGameObject().setAddClock(addFlag);
	}
}
