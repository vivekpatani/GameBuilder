/**
 * 
 */
package com.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import org.junit.Assert;
import org.junit.Test;

import com.action.Actions;
import com.event.Events;
import com.event.TimeChange;
import com.model.Sprite;

/**
 * @author team5
 *
 */
public class TimeChangeTest {
	TimeChange timeChange = TimeChange.getInstance();

	@Test
	public void testTriggerAction() {
		Map<Events, List<Actions>> eventActionMap = new HashMap<>();
		List<Actions> actionList = new ArrayList<>();
		actionList.add(Actions.AUTOMOVE);
		eventActionMap.put(Events.TIMECHANGE, actionList);
		actionList = new ArrayList<>();

		Sprite ball = new Sprite("B1", 50, 100,
				new ImageIcon(this.getClass().getClassLoader().getResource("resources/img/sprites/ball.png"))
						.getImage(),
				"ball.png", eventActionMap);
		timeChange.addSprite(ball);

		timeChange.triggerAction(0);
		Assert.assertTrue(ball.getX() == 51);
		Assert.assertTrue(ball.getY() == 99);
	}
}
