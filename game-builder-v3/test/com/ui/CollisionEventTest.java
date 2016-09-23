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
import com.event.Collision;
import com.event.Events;
import com.model.Sprite;

/**
 * @author team5
 *
 */
public class CollisionEventTest {
	Collision collision = Collision.getInstance();

	@Test
	public void testTriigerAction() {
		Map<Events, List<Actions>> eventActionMap = new HashMap<>();
		List<Actions> actionList = new ArrayList<>();
		actionList.add(Actions.AUTOMOVE);
		eventActionMap.put(Events.TIMECHANGE, actionList);
		actionList = new ArrayList<>();

		actionList.add(Actions.CHANGEDIRECTION);
		eventActionMap.put(Events.COLLISION, actionList);

		collision.addSprite(new Sprite("B1", 50, 100,
				new ImageIcon(this.getClass().getClassLoader().getResource("resources/img/sprites/ball.png"))
						.getImage(),
				"ball.png", eventActionMap));

		eventActionMap = new HashMap<>();
		actionList = new ArrayList<>();

		actionList.add(Actions.VANISH);
		eventActionMap.put(Events.COLLISION, actionList);
		Sprite b = new Sprite("B3", 60, 67,
				new ImageIcon(this.getClass().getClassLoader().getResource("resources/img/sprites/brick.jpg"))
						.getImage(),
				"brick.jpg", eventActionMap);
		collision.addSprite(b);

		collision.triggerAction(0);
		Assert.assertTrue(b.isDestroyed());
	}
}
