package com.ui;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.action.Actions;
import com.event.Events;
import com.event.KeyPress;
import com.model.Sprite;

public class MoveAndRotateTest {
	KeyPress keyPress = KeyPress.getInstance();
	Sprite paddle;
	
	@Before
		public void setUp() {
			Map<Events, List<Actions>> eventActionMap = new HashMap<Events, List<Actions>>();
			List<Actions> actionList = new ArrayList<Actions>();
			actionList.add(Actions.MOVEANDROTATE);
			eventActionMap.put(Events.KEYPRESS, actionList);
			actionList = new ArrayList<Actions>();

			paddle = new Sprite("B1", 50, 100,
					new ImageIcon(this.getClass().getClassLoader().getResource("resources/img/sprites/paddle.png"))
							.getImage(),
					"paddle.png", eventActionMap);
			keyPress.addSprite(paddle);
		}
	
	@Test
	public void triggerActionWithMoveLeft() {
		keyPress.triggerAction(3);
		Assert.assertEquals(paddle.getCurrentAngle(), 5.0, 0.0002); 
	}

	@Test
	public void triggerActionWithMoveRight() {
		keyPress.triggerAction(2);
		Assert.assertEquals(paddle.getCurrentAngle(), -5.0, 0.0002); 
	}

}
