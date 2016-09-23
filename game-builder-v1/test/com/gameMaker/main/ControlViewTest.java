package com.gameMaker.main;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gameMaker.main.ControlView;
import com.gameMaker.main.Overseer;

public class ControlViewTest {
	
	private JFrame testFrame;
	private Overseer overseerObj;
	private JLabel testLabel;
	private ControlView controlViewObj;
	

	@Before
	public void setUp() throws Exception {
		testFrame = new JFrame();
		overseerObj = new Overseer(testFrame);
		overseerObj.init();
		controlViewObj = new ControlView (overseerObj, overseerObj.getControlPanel());
		controlViewObj.initBreakoutAccordion();
		testLabel = new JLabel("Hello, this is a test");
	}

	@Test
	public void testControlView() {
		Assert.assertEquals(overseerObj.getControlPanel(), controlViewObj.getControlPanel());
	}
	
	@Test
	public void testAddToPreviewPanel() {
		controlViewObj.addToPreviewPanel(testLabel);
		Assert.assertTrue((testLabel.getParent()==controlViewObj.getPreviewPanel()));
		
	}

}
