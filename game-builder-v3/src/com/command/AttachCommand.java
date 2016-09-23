/**
 * 
 */
package com.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.action.Actions;
import com.controller.GameController;
import com.event.Events;
import com.launcher.Constants;
import com.model.Sprite;
import com.ui.GameMakerPanel;
import com.ui.GamePlayPanel;

/**
 * This com.command attaches the selected event/action to a sprite.
 * For FireAction, a bulletSprite is added to the parent Sprite and initialized by predefined events/actions.
 * 
 * @author Team% (Assignment #5)
 *
 */
public class AttachCommand implements Command {
	private final static Logger log = Logger.getLogger(AttachCommand.class);
	private GameController gameController;
	private Sprite bulletSpriteObj;
	private Map<Events, List<Actions>> eventActionMapBullet;
	private List<Actions> actionListBullet = new ArrayList<Actions>();
	private List<Actions> actionListBullet2 = new ArrayList<Actions>();

	public AttachCommand(GameController gameController) {
		this.gameController = gameController;
		bulletSpriteObj = null;
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
			
			if (actionList.contains(Actions.FIREACTION)) {
				try {
					eventActionMapBullet = new HashMap<>();
					actionListBullet.add(Actions.MOVEUP);
					actionListBullet2.add(Actions.VANISH);
					eventActionMapBullet.put(Events.COLLISION, actionListBullet2);
					eventActionMapBullet.put(Events.TIMECHANGE, actionListBullet);
					bulletSpriteObj = new Sprite("bullet" + System.currentTimeMillis(), (int) Constants.bulletXCord, (int) Constants.bulletYCord,
							new ImageIcon(this.getClass().getClassLoader().getResource("resources/img/sprites/Bullet.png")).getImage(),"Bullet.png", eventActionMapBullet);
					bulletSpriteObj.setDestroyed(Constants.bulletVisible);
					
				} catch (Exception e) {
					log.error("Error : ", e);
				}
				selectedSprite.setAttachTo(bulletSpriteObj);
				gameController.getGameContainer().getGamePlayPanel().getSavableGameObject().getSpriteList().add(bulletSpriteObj);
				Events tempEvent = Events.valueOf("TIMECHANGE");
				tempEvent.getValue().addSprite(bulletSpriteObj);
				tempEvent.getValue().populateParameterMap(new HashMap<>());
				
				tempEvent = Events.valueOf("COLLISION");
				tempEvent.getValue().addSprite(bulletSpriteObj);
				tempEvent.getValue().populateParameterMap(new HashMap<>());
			}
			
			
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
