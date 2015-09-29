package gameMaker.main;

import javax.imageio.ImageIO;
import javax.swing.*;

import gameMaker.util.Constants;
import gameMaker.util.DragListener;
import gameMaker.view.AccordionUI;
import gameMaker.view.SpritePanel;

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

public class ControlView implements Constants {

	private final static Logger log = Logger.getLogger(ControlView.class);
	
	private JPanel controlPanel;
	private JComboBox<String> gameTypeComboBox;
	
	private Overseer overseerObj;
	
	private SpritePanel spritePanel;
	private AccordionUI accordionUI;
	
	private JSplitPane splitControlView;
	private JPanel previewPanel;
	private JButton loadAndSaveButton;
	
	// Everything under this needs to be removed later
	private JLabel titleLabel;
	private BufferedImage tempPic;
	private JLabel picLabel;
	
	
	public JButton getLoadAndSaveButton() {
		return loadAndSaveButton;
	}

	public void setLoadAndSaveButton(JButton loadAndSaveButton) {
		this.loadAndSaveButton = loadAndSaveButton;
	}

	public ControlView(Overseer overseerObj, JPanel controlPanel) {
		this.overseerObj = overseerObj;
		this.controlPanel = controlPanel;
		init();
	}
	
	public void init() {
		
		//controlPanel.setBorder(new TitledBorder("Choose a Layout for the game"));
		
		loadAndSaveButton = new JButton("Load");
		
		gameTypeComboBox = new JComboBox <String>(gameTypeList);
		gameTypeComboBox.setSelectedIndex(0);
		gameTypeComboBox.setBounds(gameTypeBounds);
		gameTypeComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox <String> tempComboBox = (JComboBox <String >) event.getSource();
				
				if (gameTypeList[0].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
					log.info("Default value of ComboBox");
					// To-do add a function call to disable accordionUI
				}
				else if (gameTypeList[1].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
					log.info("Breakout Game selected");
					initBreakout();			
					initBreakoutAccordion();
				}
				else if (gameTypeList[2].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
					log.info("Tetris selected");
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

		accordionUI = new AccordionUI();
		spritePanel = new SpritePanel();
		accordionUI.acordionMaker();
		/*
		JPanel addedSpritePanel = new JPanel(new BorderLayout());
		addedSpritePanel.add(new JLabel("Added Sprites"), BorderLayout.NORTH);
		addedSpritePanel.add(new JScrollPane(), BorderLayout.CENTER);
		*/

		previewPanel = new JPanel();
		previewPanel.add(addImage());
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
	public JLabel addImage() {
		
		try {
			tempPic = ImageIO.read(this.getClass().getResource("/BreakoutTitle.jpg")); 
			//ImageIO.read(new File ("resources/BreakoutTitle.jpg"));
			Image scaledImg = tempPic.getScaledInstance(splitSize, splitControlViewSize, Image.SCALE_SMOOTH);
			
			picLabel = new JLabel(new ImageIcon(scaledImg));
			//picLabel.setBounds(splitSize/2, splitControlViewSize, ySpace*2, ySpace*2);
		} 
		catch (IOException e) {
			log.error("Error : ", e);
		}
		
		DragListener dragListener = new DragListener();
		DragSource dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(picLabel, DnDConstants.ACTION_COPY, dragListener);
		 // More can be added by making dragSource2 and adding object to it 
		
		return picLabel;
	}
	
	public JPanel getControlPanel() {
		return controlPanel;
	}
	
}
