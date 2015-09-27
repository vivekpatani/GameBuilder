package gameMaker.main;

import javax.imageio.ImageIO;
import javax.swing.*;

import gameMaker.util.Constants;
import gameMaker.util.DragListener;

import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

public class ControlView implements Constants {

	private final static Logger log = Logger.getLogger(ControlView.class);
	
	private JPanel controlPanel;
	private JComboBox<String> gameTypeComboBox;
	
	private Overseer overseerObj;
	
	// Everything under this needs to be removed later
	private JLabel titleLabel;
	BufferedImage tempPic;
	private JLabel picLabel;
	
	public ControlView(Overseer overseerObj, JPanel controlPanel) {
		this.overseerObj = overseerObj;
		this.controlPanel = controlPanel;
		init();
	}
	
	public void init() {
		
		controlPanel.setBorder(new TitledBorder("Choose a Layout for the game"));
		
		gameTypeComboBox = new JComboBox <String>(gameTypeList);
		gameTypeComboBox.setSelectedIndex(1);
		gameTypeComboBox.setBounds(gameTypeBounds);
		gameTypeComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox <String> tempComboBox = (JComboBox <String >) event.getSource();
				
				if(gameTypeList[0].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
					log.info("Breakout Game selected");
					
					initBreakout();
				}
				else if(gameTypeList[1].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
					log.info("Tetris selected");
					
				}
				else {
					log.warn("Nothing selected");
				}
			}			
		});
		
		try {
			tempPic = ImageIO.read(new File ("resources/temp.jpg"));
			picLabel = new JLabel(new ImageIcon(tempPic));
			picLabel.setBounds(splitSize/3, gameTypeComboBox.getHeight()+ySpace, 100, 50);
			
		} 
		catch (IOException e) {
			log.error("Error : ", e);
		}
		
		DragListener dragListener = new DragListener();
		DragSource dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(picLabel, DnDConstants.ACTION_COPY, dragListener);
		 // More can be added by making dragSource2 and adding object to it 
		 
		
		controlPanel.add(picLabel);
		
		controlPanel.add(gameTypeComboBox);
		gameTypeComboBox.setEnabled(true);
		
	}
	
	public void initBreakout() {
		
		ArrayList<JComponent> componentList = new ArrayList<JComponent>();
		
		// To test sending object from controlView to GameView
		// Remove later
		titleLabel = new JLabel();
		titleLabel.setText("Breakout");
		titleLabel.setBounds((windowWidth-splitSize)/2, ySpace, ySpace*2, ySpace);
		
		componentList.add(titleLabel);
		
		
		for(JComponent tempComponent : componentList) {
			overseerObj.addToGameView(tempComponent);
		}
		
	}
	
}
