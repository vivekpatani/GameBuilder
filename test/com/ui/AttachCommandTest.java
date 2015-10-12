/**
 * 
 */
package com.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.action.Actions;
import com.command.AttachCommand;
import com.controller.GameController;
import com.event.Events;
import com.model.Sprite;

import junit.framework.Assert;

/**
 * @author team5
 *
 */
public class AttachCommandTest {
	private static GameContainer container;
	private static GameController controller;
	private static AttachCommand cmd;
	private static List<Actions> actionList;
	private static Map<Events, List<Actions>> eventActionMap;
	private Sprite ball;

	@BeforeClass
	public static void classSetUp() {
		container = new GameContainer();
		controller = new GameController(container);
		cmd = new AttachCommand(controller);
		actionList = new ArrayList<Actions>();
		eventActionMap = new HashMap<>();
	}

	@Before
	public void methodSetUp() {
		actionList.add(Actions.AUTOMOVE);
		eventActionMap.put(Events.TIMECHANGE, actionList);

		ball = new Sprite("B1", 50, 100,
				new ImageIcon(this.getClass().getClassLoader().getResource("resources/img/sprites/ball.png"))
						.getImage(),
				"ball.png", eventActionMap);
		ball.setEventActionMap(eventActionMap);
		controller.setSprite(ball);
		container.getGamePlayPanel().getSavableGameObject().getSpriteList().add(ball);
		container.getGameMakerPanel().getCreatedSpriteComboBox().addItem(ball.getName());
		container.getGameMakerPanel().getCreatedSpriteComboBox().setSelectedIndex(0);
	}

	@Test
	public void testAttachCommand() {
		container.getGameMakerPanel().getEventTypeComboBox().setSelectedIndex(2);
		container.getGameMakerPanel().getActionList().setSelectedIndex(0);
		cmd.executeCommand();
		Assert.assertTrue(container.getGameMakerPanel().getPlayButton().isEnabled() == true);

	}

	@Test
	public void testAttachCommand2() {
		container.getGameMakerPanel().getEventTypeComboBox().setSelectedIndex(2);
		container.getGameMakerPanel().getActionList().setSelectedIndex(0);
		cmd.executeCommand();
		Assert.assertTrue(container.getGameMakerPanel().getPlayButton().isEnabled() == true);

	}
}
