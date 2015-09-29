package gameMaker.listener;

import java.awt.Image;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import gameMaker.main.ControlView;
import gameMaker.main.Overseer;
import gameMaker.util.Constants;

public class SpriteSelectionListener implements ActionListener {

	private final static Logger log = Logger.getLogger(SpriteSelectionListener.class);
	private Overseer overseerObj;
	
	private JPanel spritePanel;
	private JLabel imageLabel;
	
	public SpriteSelectionListener(Overseer overseerObj, JPanel spritePanel) {
		
		this.overseerObj = overseerObj;
		this.spritePanel = spritePanel;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		JComboBox <String> tempComboBox = (JComboBox <String >) event.getSource();
		
		if (Constants.SPRITE_LIST[0].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
			log.info("Default value of ComboBox");
			// To-do add a function call to disable accordionUI
		}
		else if (Constants.SPRITE_LIST[1].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
			/*
			 * Show Ball Image
			 */
			
			BufferedImage ballImage;
			try {
				
				if(null != imageLabel)	{
				spritePanel.remove(imageLabel);
				}
				ballImage = ImageIO.read(new File (overseerObj.getResourceFolder() + "/" + "ball1.png"));
				Image scaledImg = ballImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				imageLabel = new JLabel(new ImageIcon(scaledImg));
				imageLabel.setBounds(75, 50, 30, 30);
				//spritePanel.add(imageLabel, 111);
				DragListener dragListener = new DragListener();
				DragSource dragSource = new DragSource();
				dragSource.createDefaultDragGestureRecognizer(imageLabel, DnDConstants.ACTION_COPY, dragListener);
				
				overseerObj.getControlView().addToPreviewPanel(imageLabel);
				
				/*
				spritePanel.add(imageLabel);
				spritePanel.revalidate();
				*/
				
			} 
			catch (IOException e) {
				log.error("Error : ", e);
			}
			
			
		}
		else if (Constants.SPRITE_LIST[2].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
			
			/*
			 * Show Brick Image
			 */
			
			BufferedImage ballImage;
			try {
				if(null != imageLabel)	{
					spritePanel.remove(imageLabel);
					}
				
				spritePanel.revalidate();
				ballImage = ImageIO.read(new File (overseerObj.getResourceFolder() + "/" + "brick1.jpg"));
				Image scaledImg = ballImage.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
				imageLabel = new JLabel(new ImageIcon(scaledImg));
				imageLabel.setBounds(75, 50, 50, 30);
				//spritePanel.remove("spriteImage");
				//spritePanel.remove(spritePanel.getComponentCount(""));
				
				DragListener dragListener = new DragListener();
				DragSource dragSource = new DragSource();
				dragSource.createDefaultDragGestureRecognizer(imageLabel, DnDConstants.ACTION_MOVE, dragListener);
				
				overseerObj.getControlView().addToPreviewPanel(imageLabel);
				
				/*
				spritePanel.add(imageLabel);
				spritePanel.revalidate();
				*/
				
			} 
			catch (IOException e) {
				log.error("Error : ", e);
			}
			

		}else if (Constants.SPRITE_LIST[3].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
			
			/*
			 * Show Paddle Image
			 */
			
			BufferedImage ballImage;
			try {
				if(null != imageLabel)	{
					spritePanel.remove(imageLabel);
					}
				
				spritePanel.revalidate();
				ballImage = ImageIO.read(new File (overseerObj.getResourceFolder() + "/" + "paddle1.png"));
				Image scaledImg = ballImage.getScaledInstance(100, 30, Image.SCALE_SMOOTH);
				imageLabel = new JLabel(new ImageIcon(scaledImg));
				imageLabel.setBounds(75, 50, 100, 30);
				//spritePanel.remove("spriteImage");
				//spritePanel.remove(spritePanel.getComponentCount(""));
				
				DragListener dragListener = new DragListener();
				DragSource dragSource = new DragSource();
				dragSource.createDefaultDragGestureRecognizer(imageLabel, DnDConstants.ACTION_COPY, dragListener);
				
				overseerObj.getControlView().addToPreviewPanel(imageLabel);
				
				/*
				spritePanel.add(imageLabel);
				spritePanel.revalidate();
				*/
			} 
			catch (IOException e) {
				log.error("Error : ", e);
			}
			

		}
		


	}

}
