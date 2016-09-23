package com.gameMaker.view;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gameMaker.main.Overseer;

public class AccordionUITest {

	private JFrame testFrame;
	private JPanel testPanel;
	private Overseer overseerObj;
	private AccordionUI accordionUITestObj;
	private int visibleBarTest;
	private String testName;
	
	@Before
	public void setUp() throws Exception {
		testFrame = new JFrame();
		testPanel = new JPanel();
		overseerObj = new Overseer(testFrame);
		accordionUITestObj = new AccordionUI(overseerObj);
		accordionUITestObj.acordionMaker();
	}

	@Test
	public void testAddBarStringJComponent() {
		testName = "TestBar";
		accordionUITestObj.addBar(testName, testPanel);
		Assert.assertTrue(accordionUITestObj.getBarsObj().containsKey(testName));
	}

	@Test
	public void testRemoveBar() {
		testName = "TestBar";
		accordionUITestObj.addBar(testName, testPanel);
		accordionUITestObj.removeBar(testName);
		Assert.assertFalse(accordionUITestObj.getBarsObj().containsKey(testName));
	}

	@Test
	public void testGetVisibleBar() {
		visibleBarTest = 0;
		Assert.assertEquals(visibleBarTest, accordionUITestObj.getVisibleBar());
	}

	@Test
	public void testSetVisibleBar() {
		visibleBarTest = 3;
		accordionUITestObj.setVisibleBar(visibleBarTest);
		Assert.assertEquals(visibleBarTest, accordionUITestObj.getVisibleBar());
	}

	@Test
	public void testGetAccordionUI() {
		Assert.assertEquals(accordionUITestObj, accordionUITestObj.getAccordionUI());
	}

}
