/**
 * 
 */
package com.command;

import javax.swing.ImageIcon;

import com.controller.GameController;
import com.launcher.Constants;
import com.ui.GameMakerPanel;

/**
 * This com.command attaches the selected background image to the panel.
 * 
 * @author team5
 *
 */
public class BackgroundChangeCommand implements Command {

	private GameController gameController;

	public BackgroundChangeCommand(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void executeCommand() {

		GameMakerPanel gameMakerPanel = gameController.getGameContainer().getGameMakerPanel();
		String selectedbackgroundImage = gameMakerPanel.getBackgroundImageComboBox().getSelectedItem().toString();

		if (!Constants.NONE.equals(selectedbackgroundImage)) {
			ImageIcon backgroundImage = new ImageIcon(getClass().getClassLoader()
					.getResource(Constants.BACKGROUND_IMAGE_PATH + "/" + selectedbackgroundImage));

			gameController.getGameContainer().getGamePlayPanel().getSavableGameObject()
					.setBackgroudImage(backgroundImage.getImage());
			gameController.getGameContainer().getGamePlayPanel().getSavableGameObject()
					.setBackgroudImageName(selectedbackgroundImage);
			gameController.getGameContainer().getGamePlayPanel().repaint();
		}
	}
}
