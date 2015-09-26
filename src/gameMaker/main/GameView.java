package gameMaker.main;

import javax.swing.JComponent;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

public class GameView {

	private JPanel gamePanel;
	
	private final static Logger log = Logger.getLogger(GameView.class);
	
	public GameView (JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void addToPanel(JComponent component) {
		gamePanel.add(component);
		gamePanel.repaint();
	}
	
}