/**
 * 
 */
package com.command;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.action.Actions;
import com.controller.GameController;
import com.event.Events;
import com.launcher.Constants;
import com.model.Sprite;
import com.ui.GameMakerPanel;

/**
 * This com.command creates a sprite object as specified by the user.
 * 
 * @author team5
 *
 */
public class CreateCommand implements Command {

	private GameController gameController;

	public CreateCommand(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void executeCommand() {
		GameMakerPanel gameMakerPanel = gameController.getGameContainer().getGameMakerPanel();
		if (!isFieldValid(gameMakerPanel.getSpriteNameTextField(), false)) {
			displayErrorMessageDialog("Empty Sprite Name Not Allowed.");
		} else if (isDuplicateSprite(gameMakerPanel.getSpriteNameTextField())) {
			displayErrorMessageDialog("Sprite Name Already Exists.");
		} else if (!isFieldValid(gameMakerPanel.getxPositionTextField(), true)) {
			displayErrorMessageDialog("Empty / Non-numerical X-position Not Allowed.");
		} else if (!isFieldValid(gameMakerPanel.getyPositionTextField(), true)) {
			displayErrorMessageDialog("Empty / Non-numerical Y-position Not Allowed.");
		} else if (null == gameMakerPanel.getSelectedImage()) {
			displayErrorMessageDialog("Please select an image for the sprite.");
		} else {

			Image image = fetchSpriteImage(gameMakerPanel.getSelectedImage());
			int x = Integer.parseInt(gameMakerPanel.getxPositionTextField().getText());
			int y = Integer.parseInt(gameMakerPanel.getyPositionTextField().getText());

			if (isPositionValid(x, y, image)) {
				Sprite newSprite = createNewSprite(gameMakerPanel, x, y, image);
//				newSprite.setCurrentAngle(0);
				gameController.setSprite(newSprite);
				gameController.getGameContainer().getGamePlayPanel().getSavableGameObject().getSpriteList()
						.add(gameController.getSprite());

				populateSpriteNames(gameMakerPanel.getSpriteNameTextField());
				populateCreatedSpriteList(newSprite, gameMakerPanel);
				gameMakerPanel.getDeleteSpriteButton().setEnabled(true);
				gameMakerPanel.getAttachButton().setEnabled(true);
				gameController.getGameContainer().getGamePlayPanel().removeCordinateHighlighting();
				gameController.getGameContainer().repaint();
				autoSave();
			} else {
				displayErrorMessageDialog("Invalid position specified for the sprite.");
			}
		}
	}

	/**
	 * This method checks for validity of field data when creating a new sprite.
	 * 
	 * @param field
	 * @param isNumber
	 * @return
	 */
	private boolean isFieldValid(JTextField field, boolean isNumber) {
		if (!field.getText().isEmpty()) {
			if (isNumber && !Pattern.matches("^[0-9]*$", field.getText())) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * This method creates a new Sprite object as specified by the user.
	 * 
	 * @param gameMakerPanel
	 * @return
	 */
	private Sprite createNewSprite(GameMakerPanel gameMakerPanel, int x, int y, Image image) {

		return new Sprite(gameMakerPanel.getSpriteNameTextField().getText(), x, y, image,
				gameMakerPanel.getSelectedImage().toString(), new HashMap<Events, List<Actions>>());
	}

	/**
	 * This method determines if the placed sprite is within game panel
	 * boundaries.
	 * 
	 * @return
	 */
	private boolean isPositionValid(int x, int y, Image image) {
		Rectangle sprite = new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
		Rectangle gameWindow = new Rectangle(0, 0, Constants.GAME_PLAY_PANEL_WIDTH, Constants.GAME_PLAY_PANEL_HEIGHT);

		return gameWindow.contains(sprite);
	}

	/**
	 * This method checks if the sprite already exists in the application.
	 * 
	 * @param field
	 * @return
	 */
	private boolean isDuplicateSprite(JTextField field) {
		String name = field.getText();
		return gameController.getSpriteNames().contains(name);
	}

	/**
	 * This method populates the sprite name list as the user goes on creating
	 * new sprites.
	 */
	private void populateSpriteNames(JTextField field) {
		gameController.getSpriteNames().add(field.getText());
	}

	/**
	 * This method fetches the image of specified sprite to be inserted on game
	 * panel.
	 * 
	 * @param imageName
	 * @return
	 */
	private Image fetchSpriteImage(Object imageName) {
		return new ImageIcon(getClass().getClassLoader().getResource(Constants.SPRITES_IMAGE_PATH + "/" + imageName))
				.getImage();
	}

	/**
	 * This method displays error message dialog.
	 */
	private void displayErrorMessageDialog(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}

	/**
	 * This method selects the current element as the selected element in sprite
	 * list on game maker panel.
	 * 
	 * @param sprite
	 * @param gameMakerPanel
	 */
	private void populateCreatedSpriteList(Sprite sprite, GameMakerPanel gameMakerPanel) {
		Object spriteName = sprite.getName();
		gameMakerPanel.getCreatedSpriteComboBox().addItem(spriteName);
		gameMakerPanel.getCreatedSpriteComboBox().setSelectedItem(spriteName);
		gameMakerPanel.getLoosingSpriteComboBox().addItem(spriteName);
	}

	/***
	 * This method triggers AutoSave.
	 */
	private void autoSave() {
		((SaveCommand) gameController.getSaveCommand()).setAutoSave(true);
		gameController.getSaveCommand().executeCommand();
	}
}
