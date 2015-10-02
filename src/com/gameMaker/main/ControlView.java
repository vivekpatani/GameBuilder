package com.gameMaker.main;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import com.gameMaker.listener.DragListener;
import com.gameMaker.util.Constants;
import com.gameMaker.view.AccordionUI;

public class ControlView implements Constants {

	private final static Logger log = Logger.getLogger(ControlView.class);
	
	private JPanel controlPanel;
	private JComboBox<String> gameTypeComboBox;
	
	private Overseer overseerObj;
	
	private AccordionUI accordionUI;
	
	private JSplitPane splitControlView;
	private JPanel previewPanel;
	
	// Everything under this needs to be removed later
	private JLabel titleLabel;
	private BufferedImage tempPic;
	private JLabel picLabel;
	
	public ControlView(Overseer overseerObj, JPanel controlPanel) {
		this.overseerObj = overseerObj;
		this.controlPanel = controlPanel;
		init();
	}
	
	public void init() {
		
		//controlPanel.setBorder(new TitledBorder("Choose a Layout for the game"));
		
		gameTypeComboBox = new JComboBox <String>(gameTypeList);
		gameTypeComboBox.setSelectedIndex(0);
		gameTypeComboBox.setBounds(gameTypeBounds);
		gameTypeComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox <String> tempComboBox = (JComboBox <String >) event.getSource();
				
				if (gameTypeList[0].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
					log.info("Default value of ComboBox");
					// Removes Breakout accordion
					controlPanel.remove(splitControlView);
					controlPanel.repaint();
				}
				else if (gameTypeList[1].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
					log.info("Breakout Game selected");
					initBreakout();			
					initBreakoutAccordion();
				}
				else if (gameTypeList[2].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
					log.info("Tetris selected");
					// Removes Breakout accordion
					controlPanel.remove(splitControlView);
					controlPanel.repaint();
				}
				else {
					log.warn("Nothing selected");
				}
			}			
		});

		controlPanel.add(gameTypeComboBox, BorderLayout.NORTH);
		gameTypeComboBox.setEnabled(true);
		
	}
	
	public void initBreakout() {
		
		ArrayList<JComponent> componentList = new ArrayList<JComponent>();
		
		// To test sending object from controlView to GameView
		// Remove later
		titleLabel = new JLabel();
		//titleLabel.setText("Breakout");
		//titleLabel.setBounds((windowWidth-splitSize)/2, ySpace, 100, 50);
		
		/*componentList.add(titleLabel);
		
		
		for(JComponent tempComponent : componentList) {
			overseerObj.addToGameView(tempComponent);
		}
		
*/	}
	
	public void initBreakoutAccordion() {

		accordionUI = new AccordionUI(overseerObj);
		accordionUI.acordionMaker();

		previewPanel = new JPanel();
		previewPanel.setLayout(new BorderLayout());
		previewPanel.add(addImage(overseerObj.getResourceFolder(), "BreakoutTitle.jpg"));
		previewPanel.setEnabled(true);
		
		// Splitting ControlView in two after ComboBox
		splitControlView = new JSplitPane(JSplitPane.VERTICAL_SPLIT, previewPanel, accordionUI);
		// Setting the resize to false
		splitControlView.setEnabled(false);
		// Setting the location of the divider
		splitControlView.setDividerLocation(splitControlViewSize);
		
		controlPanel.add(splitControlView, BorderLayout.CENTER);
		
		controlPanel.revalidate();
		controlPanel.repaint();
	}
	
	// Temporary function to test drag and drop functionality
	public JLabel addImage(File resourceFolder, String fileName) {
		
		try {
			tempPic = ImageIO.read(new File (resourceFolder + "/" + fileName));
			Image scaledImg = tempPic.getScaledInstance(splitSize, splitControlViewSize, Image.SCALE_SMOOTH);
			
			picLabel = new JLabel(new ImageIcon(scaledImg));
			//picLabel.setBounds(splitSize/2, splitControlViewSize, ySpace*2, ySpace*2);
		} 
		catch (IOException e) {
			log.error("Error : ", e);
		}
		
		/*DragListener dragListener = new DragListener();
		DragSource dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(picLabel, DnDConstants.ACTION_COPY, dragListener);
		*/ 
		// More can be added by making dragSource2 and adding object to it 
		
		return picLabel;
	}
	
	public JPanel getControlPanel() {
		return controlPanel;
	}
	
	public JPanel getPreviewPanel() {
		return previewPanel;
	}
	
	public void addToPreviewPanel (JLabel picLabel) {
		previewPanel.removeAll();
		previewPanel.add(picLabel, BorderLayout.CENTER);
		previewPanel.revalidate();
		previewPanel.repaint();
	}
}
