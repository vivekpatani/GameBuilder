package gameMaker.main;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import org.apache.log4j.Logger;

public class GameView {

	private JPanel gamePanel;
	
	private final static Logger log = Logger.getLogger(GameView.class);
	
	public GameView (JPanel gamePanel) {
		this.gamePanel = gamePanel;
		initDrop();
	}
	
	public void addToPanel(JComponent component) {
		gamePanel.add(component);
		gamePanel.repaint();
	}
	
	public void initDrop() {
		TransferHandler dragNDrop = new TransferHandler() {
			
			@Override
			public boolean canImport (TransferSupport support) {
				if (!support.isDrop()) {
					return false;
				}
				
				if(!support.isDataFlavorSupported(DataFlavor.imageFlavor)) {
					return false;
				}
				
				return true;
			}
			
			@Override
			public boolean importData (TransferSupport support) {
				if(!canImport (support)) {
					return false;
				}
				
				Transferable transferable = support.getTransferable();
				ImageIcon transferImage;
				
				try {
					transferImage = (ImageIcon) transferable.getTransferData(DataFlavor.imageFlavor);
				}
				catch (Exception e) {
					log.error("Error : ", e);
					return false;
				}
				
				// Not needed, getting mousePosition in DropListener
				// tempLabel.setBounds(100, 100, 100, 100);
				
				gamePanel.add(new JLabel (transferImage));
				return true;
			}
		};
		
		gamePanel.setTransferHandler(dragNDrop);
	}
	
	public JPanel getGamePanel() {
		return gamePanel;
	}
	
}