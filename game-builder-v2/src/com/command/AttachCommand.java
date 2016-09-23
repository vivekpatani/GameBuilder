/**
 * 
 */
package com.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.action.Actions;
import com.controller.GameController;
import com.event.Events;
import com.launcher.Constants;
import com.model.Sprite;
import com.ui.GameMakerPanel;

/**
 * This com.command attaches the selected event/action to a sprite.
 * 
 * @author team5
 *
 */
public class AttachCommand implements Command {
	private GameController gameController;

	public AttachCommand(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void executeCommand() {

		List<Actions> actionList = new ArrayList<Actions>();

		GameMakerPanel gameMakerPanel = gameController.getGameContainer().getGameMakerPanel();
		Sprite selectedSprite = fetchSpriteFromCreatedSpritesList(
				gameMakerPanel.getCreatedSpriteComboBox().getSelectedItem());
		Map<Events, List<Actions>> eventActionMap = selectedSprite.getEventActionMap();

		if ("None".equals(gameMakerPanel.getEventTypeComboBox().getSelectedItem().toString())) {
			JOptionPane.showMessageDialog(null, "Please select a valid Event");
		} else if (gameMakerPanel.getActionList().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Please select an Action");
		} else {
			Events event = Events
					.valueOf(gameMakerPanel.getEventTypeComboBox().getSelectedItem().toString().toUpperCase());

			if (eventActionMap.containsKey(event)) {
				actionList = eventActionMap.get(event);
			}
			actionList.add(Actions.valueOf(gameMakerPanel.getActionList().getSelectedValue().toString().toUpperCase()));
			eventActionMap.put(event, actionList);
			selectedSprite.setEventActionMap(eventActionMap);

			Map<Object, Object> paramMap = new HashMap<>();
			JComboBox<Object> soundComboBox = gameMakerPanel.getSoundComboBox();

			if (null != soundComboBox && soundComboBox.isEnabled()) {
				paramMap.put(Constants.SOUND, soundComboBox.getSelectedItem());
			}

			event.getValue().addSprite(selectedSprite);
			event.getValue().populateParameterMap(paramMap);

			gameMakerPanel.getPlayButton().setEnabled(true);
			gameMakerPanel.resetEventsPanel();
			autoSave();
		}
	}

	/**
	 * This method fetches the selected sprite instance from the sprite list in
	 * event panel.
	 * 
	 * @param SpriteName
	 * @return
	 */
	private Sprite fetchSpriteFromCreatedSpritesList(Object SpriteName) {
		List<Sprite> createdSpriteList = gameController.getGameContainer().getGamePlayPanel().getSavableGameObject()
				.getSpriteList();
		Sprite selectedSprite = null;

		for (Sprite sprite : createdSpriteList) {
			if (SpriteName.equals(sprite.getName())) {
				selectedSprite = sprite;
				break;
			}
		}
		return selectedSprite;
	}

	/***
	 * This method triggers AutoSave.
	 */
	private void autoSave() {
		((SaveCommand) gameController.getSaveCommand()).setAutoSave(true);
		gameController.getSaveCommand().executeCommand();
	}
}
