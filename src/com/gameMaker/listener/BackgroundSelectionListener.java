package com.gameMaker.listener;

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

import com.gameMaker.main.ControlView;
import com.gameMaker.main.Overseer;
import com.gameMaker.util.Constants;

public class BackgroundSelectionListener implements ActionListener{
	
	private final static Logger log = Logger.getLogger(BackgroundSelectionListener.class);
	private Overseer overseerObj;
	
	private JPanel backgroundPanel;
	private JLabel imageLabel;
	
public BackgroundSelectionListener(Overseer overseerObj, JPanel backgroundPanel) {
		
		this.overseerObj = overseerObj;
		this.backgroundPanel = backgroundPanel;
	}

@Override
public void actionPerformed(ActionEvent event){

	
	JComboBox <String> tempComboBox = (JComboBox <String >) event.getSource();
	
	if (Constants.BACKGROUND_LIST[0].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
		log.info("Default value of ComboBox");
		// To-do add a function call to disable accordionUI
	}
	else if (Constants.BACKGROUND_LIST[1].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
		/*
		 * dome.jpg
		 */
		BufferedImage backgroundImage;
		try {
			
			if(null != imageLabel)	{
				backgroundPanel.remove(imageLabel);
			}
			backgroundImage = ImageIO.read(new File (overseerObj.getResourceFolder() + "/" + "dome.jpg"));
			overseerObj.getGameView().changeBackground(backgroundImage);
			
		} 
		catch (IOException e) {
			log.error("Error : ", e);
		}
	}
	else if (Constants.BACKGROUND_LIST[2].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
		/*
		 * green.jpg
		 */
		BufferedImage backgroundImage;
	try {
			
			if(null != imageLabel)	{
				backgroundPanel.remove(imageLabel);
			}
			backgroundImage = ImageIO.read(new File (overseerObj.getResourceFolder() + "/" + "green.jpg"));
			overseerObj.getGameView().changeBackground(backgroundImage);
			
		} 
		catch (IOException e) {
			log.error("Error : ", e);
		}
	}
	else if (Constants.BACKGROUND_LIST[3].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
		/*
		 * mountains.jpg
		 */
		BufferedImage backgroundImage;
	try {
			
			if(null != imageLabel)	{
				backgroundPanel.remove(imageLabel);
			}
			backgroundImage = ImageIO.read(new File (overseerObj.getResourceFolder() + "/" + "mountains.jpg"));
			overseerObj.getGameView().changeBackground(backgroundImage);
			
		} 
		catch (IOException e) {
			log.error("Error : ", e);
		}
	}
	else if (Constants.BACKGROUND_LIST[4].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
		/*
		 * plain.jpg
		 */
		BufferedImage backgroundImage;
	try {
			
			if(null != imageLabel)	{
				backgroundPanel.remove(imageLabel);
			}
			backgroundImage = ImageIO.read(new File (overseerObj.getResourceFolder() + "/" + "plain.jpg"));
			overseerObj.getGameView().changeBackground(backgroundImage);
			
		} 
		catch (IOException e) {
			log.error("Error : ", e);
		}
	}
	else if (Constants.BACKGROUND_LIST[5].equalsIgnoreCase((String) tempComboBox.getSelectedItem())) {
		/*
		 * skypale.jpg
		 */
		BufferedImage backgroundImage;
	try {
			
			if(null != imageLabel)	{
				backgroundPanel.remove(imageLabel);
			}
			backgroundImage = ImageIO.read(new File (overseerObj.getResourceFolder() + "/" + "skypale.jpg"));
			overseerObj.getGameView().changeBackground(backgroundImage);
			
		} 
		catch (IOException e) {
			log.error("Error : ", e);
		}
	}
}


}
