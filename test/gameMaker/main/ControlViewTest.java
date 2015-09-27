package gameMaker.main;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ControlViewTest {
	
	private JFrame testFrame;
	private Overseer overseerObj;
	
	private ControlView controlViewObj;
	

	@Before
	public void setUp() throws Exception {
		testFrame = new JFrame();
		overseerObj = new Overseer(testFrame);
		overseerObj.init();
		
		controlViewObj = new ControlView (overseerObj, overseerObj.getControlPanel());
	}

	@Test
	public void testControlView() {
		Assert.assertEquals(overseerObj.getControlPanel(), controlViewObj.getControlPanel());
	}

}
