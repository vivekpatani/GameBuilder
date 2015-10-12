package com.ui;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import org.junit.Assert;
import org.junit.Test;

import com.action.Actions;
import com.event.Events;
import com.event.KeyPress;
import com.model.Sprite;

public class FireActionTest {
	KeyPress keyPress = KeyPress.getInstance();
	private Sprite paddle;
	private Sprite bulletObj;
	
	@Test
	public void test() {
		Map<Events, List<Actions>> eventActionMap = new HashMap<Events, List<Actions>>();
		List<Actions> actionList = new ArrayList<Actions>();
		actionList.add(Actions.FIREACTION);
		eventActionMap.put(Events.KEYPRESS, actionList);
		actionList = new ArrayList<Actions>();

		paddle = new Sprite("B1", 50, 100,
				new ImageIcon(this.getClass().getClassLoader().getResource("resources/img/sprites/paddle.png"))
						.getImage(),
				"paddle.png", eventActionMap);
		
		bulletObj = new Sprite("B1", 10, 20,
				new ImageIcon(this.getClass().getClassLoader().getResource("resources/img/sprites/paddle.png"))
						.getImage(),
				"paddle.png", eventActionMap);
		
		paddle.setAttachTo(bulletObj);
		keyPress.addSprite(paddle);
		keyPress.triggerAction(6);
		Assert.assertEquals(bulletObj.getX(),122);
		Assert.assertEquals(bulletObj.getY(),80);

	}

}
