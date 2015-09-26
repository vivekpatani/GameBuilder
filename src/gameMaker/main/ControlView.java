package gameMaker.main;

import javax.swing.*;

import gameMaker.util.Constants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
		
		controlPanel.add(gameTypeComboBox);
		gameTypeComboBox.setEnabled(true);
		
	}
	
	public void initBreakout() {
		
		ArrayList<JComponent> componentList = new ArrayList<JComponent>();
		
		// To test sending object from controlView to GameView
		// Remove later
		titleLabel = new JLabel();
		titleLabel.setText("Breakout");
		titleLabel.setBounds((windowWidth-splitSize)/2, ySpace, 100, 50);
		
		componentList.add(titleLabel);
		
		
		for(JComponent tempComponent : componentList) {
			overseerObj.addToGameView(tempComponent);
		}
		
	}
	
}