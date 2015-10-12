package com.controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.model.Sprite;

/** 
 * This class takes all the SpriteObj from gameControllerObj and shows the list to user in form of JCheckBox
 * User can select any number of Sprites and 
*/
public class DeleteSpriteDialog extends JDialog {
	
	private final static Logger log = Logger.getLogger(DeleteSpriteDialog.class);
	private GameController gameControllerObj;
	private JPanel dialogBoxPanel, checkBoxPanel, buttonPanel;
	private JButton okButton, cancelButton;
	private List<Sprite> spriteListObj;
	private ArrayList<JCheckBox> arrayListCheckBoxObj;
	private JCheckBox temporaryCheckBox;
	
	
	public DeleteSpriteDialog (GameController gameControllerObj) {
		BasicConfigurator.configure();
		this.gameControllerObj = gameControllerObj;
		dialogBoxPanel = new JPanel();
		dialogBoxPanel.setLayout(new GridLayout(2,1));
		this.add(dialogBoxPanel);
		checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
		buttonPanel = new JPanel();
		okButton = new JButton("Delete");
		cancelButton = new JButton("Cancel");
		spriteListObj = gameControllerObj.getGameContainer().getGamePlayPanel().getSavableGameObject().getSpriteList();
		arrayListCheckBoxObj = new ArrayList<JCheckBox>();
	}
	
	public void initDialogBox() {
		
		for(Sprite spriteObj : spriteListObj) {
			temporaryCheckBox = new JCheckBox(spriteObj.getName());
			temporaryCheckBox.setAlignmentX(CENTER_ALIGNMENT);
			arrayListCheckBoxObj.add(temporaryCheckBox);
			log.info("SpriteName: " + spriteObj.getName() + " added to arrayListCheckBox");
		}
		
		for(JCheckBox checkBoxObj : arrayListCheckBoxObj) {
			checkBoxPanel.add(checkBoxObj);
		}
		
		ActionListener okButtonListener = new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				ArrayList<Sprite> deletedSprites = new ArrayList<Sprite>();
				log.info("Ok Button clicked");
				for(JCheckBox checkBoxObj : arrayListCheckBoxObj) {
					if(checkBoxObj.isSelected()) {
						log.info("Selected checkbox : " + checkBoxObj.getText());
						for(Sprite spriteObj : spriteListObj) {
							if(checkBoxObj.getText().equals(spriteObj.getName())) {
								deletedSprites.add(spriteObj);
								log.info("Sprite " + spriteObj.getName() + " deleted");
								gameControllerObj.getSpriteNames().remove(spriteObj.getName());
								gameControllerObj.getGameContainer().getGameMakerPanel().getCreatedSpriteComboBox().removeItem(spriteObj.getName());
								gameControllerObj.getGameContainer().getGameMakerPanel().getLoosingSpriteComboBox().removeItem(spriteObj.getName());
							}
						}
					}
				}
				for(Sprite spriteObj : deletedSprites) {
					log.info("Size of List : " + spriteListObj.size());
					spriteListObj.remove(spriteObj);
					log.info("index of deleted : " + spriteListObj.indexOf(spriteObj));
				}
				gameControllerObj.getGameContainer().getGamePlayPanel().getSavableGameObject().setSpriteList(spriteListObj);
				gameControllerObj.getGameContainer().getGamePlayPanel().repaint();
				disposeDialogBox();
			}
		};
		
		ActionListener cancelButtonListener = new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				log.info("Cancel Button clicked");
				disposeDialogBox();
			}
		};
		
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		dialogBoxPanel.add(checkBoxPanel);
		dialogBoxPanel.add(buttonPanel);
		okButton.addActionListener(okButtonListener);
		cancelButton.addActionListener(cancelButtonListener);
		
		okButton.setEnabled(true);
		cancelButton.setEnabled(true);
	}
	
	public List<Sprite> getSpriteList() {
		return spriteListObj;
	}
	
	public void disposeDialogBox() {
		this.dispose();
	}	

}