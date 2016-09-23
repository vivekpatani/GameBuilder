package com.gameMaker.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import org.apache.log4j.Logger;

import com.gameMaker.util.Constants;

public class GameView extends JPanel implements Constants {

	private final static Logger log = Logger.getLogger(GameView.class);
	
	private Overseer overseerObj;
	private Image backgroundImage;
	
	public GameView (Overseer overseerObj) {
		this.overseerObj = overseerObj;
		backgroundImage = null;
		this.setLayout(null);
		initDrop();
	}
	
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
	
		if(backgroundImage != null) {
			
			int size_x = this.getWidth();
			int size_y = this.getHeight();
			g.drawImage(backgroundImage, 0, 0, size_x, size_y, this);
			
		}
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
						
				addToPanel(new JLabel (transferImage));
				return true;
			}
		};
		
		this.setTransferHandler(dragNDrop);
	}
	
	// Used to add JComponents to this panel 
	public void addToPanel(JComponent component) {
		this.add(component);
		this.repaint();
	}
	
	// Returns the JPanel being used
	public JPanel getGamePanel() {
		return this;
	}
	
	// Gives the backgroundImage an Image to be used as the GameView's background
	public void changeBackground(Image bgImage) {
		backgroundImage = bgImage;
		repaint();
	}
}