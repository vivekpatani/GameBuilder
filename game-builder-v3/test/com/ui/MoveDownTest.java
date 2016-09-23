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
import com.event.TimeChange;
import com.model.Sprite;

public class MoveDownTest {

TimeChange timeChange = TimeChange.getInstance();
	
	@Test
	public void testTriggerAction() {
		Map<Events, List<Actions>> eventActionMap = new HashMap<Events, List<Actions>>();
		List<Actions> actionList = new ArrayList<Actions>();
		actionList.add(Actions.MOVEDOWN);
		eventActionMap.put(Events.TIMECHANGE, actionList);
		actionList = new ArrayList<Actions>();

		Sprite paddle = new Sprite("B1", 50, 100,
				new ImageIcon(this.getClass().getClassLoader().getResource("resources/img/sprites/paddle.png"))
						.getImage(),
				"paddle.png", eventActionMap);
		paddle.setyDir(3);
		timeChange.addSprite(paddle);	
		timeChange.triggerAction(0);

		Assert.assertEquals(paddle.getY(),103);

}
}
