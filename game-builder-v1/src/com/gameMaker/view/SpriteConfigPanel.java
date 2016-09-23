package com.gameMaker.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.gameMaker.listener.SpriteSelectionListener;
import com.gameMaker.main.Overseer;
import com.gameMaker.util.Constants;

public class SpriteConfigPanel extends JPanel {

	private Overseer overseerObj;
	private JComboBox<String> spritesComboBox;
	
	public SpriteConfigPanel(Overseer overseerObj) {
		
		this.overseerObj = overseerObj;
		setLayout(new BorderLayout());
		spritesComboBox = new JComboBox <String>(Constants.SPRITE_LIST);
		spritesComboBox.setSelectedIndex(0);
		spritesComboBox.setBounds(Constants.DROPDOWN_DEFAULT_BOUNDS);
		spritesComboBox.addActionListener(new SpriteSelectionListener(overseerObj, this));
		this.add(spritesComboBox, BorderLayout.NORTH);		
		spritesComboBox.setEnabled(true);
		
		
	}
}
