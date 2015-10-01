package com.gameMaker.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

import com.gameMaker.main.Overseer;
import com.gameMaker.util.KeyEventWrapper;

public class ChooseControlsDialog extends JDialog {

	private Overseer overseerObj;
	private JPanel dialogBoxPanel;
	private JButton leftButton, rightButton;
	private JLabel leftKeyBindingLabel, rightKeyBindingLabel;
	private ButtonGroup buttonGroup;
	private JRadioButton mouseRadioButton, keyboardRadioButton;
	private KeyEventWrapper leftKey, rightKey;
	
	
	public ChooseControlsDialog(Overseer overseerObj) {
		this.overseerObj = overseerObj;
		leftKey = overseerObj.getLeftMoveKey();
		rightKey = overseerObj.getRightMoveKey();
		selectControls();
	}
	
	public void selectControls() {
		
		dialogBoxPanel = new JPanel();
		dialogBoxPanel.setLayout(new GridLayout(3,2));
		mouseRadioButton = new JRadioButton("Mouse Controls");
		keyboardRadioButton = new JRadioButton("Keyboard Controls");
		buttonGroup = new ButtonGroup();
		leftButton = new JButton("Move Left Key");
		rightButton = new JButton("Move Right Key");
		leftKeyBindingLabel = new JLabel(leftKey.getKeyString());
		rightKeyBindingLabel = new JLabel(rightKey.getKeyString());
		
		ActionListener mouseRadioButtonListener = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// To-do Use enum to define a mode
				// GameControl.MOUSE;
				
				leftButton.setVisible(false);
				rightButton.setVisible(false);
				leftKeyBindingLabel.setVisible(false);
				rightKeyBindingLabel.setVisible(false);
				
				dialogBoxPanel.repaint();
				// send image to keyImage in gamePanel
			}
		};

		ActionListener keyboardRadioButtonListener = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				leftKeyBindingLabel.setVisible(true);
				rightKeyBindingLabel.setVisible(true);
				
				dialogBoxPanel.repaint();
				
				final KeyListener leftKeyListener = new KeyAdapter() {
					public void keyReleased(KeyEvent ke) {
						leftKey = new KeyEventWrapper(ke);
						leftKeyBindingLabel.setText(leftKey.getKeyString());
						leftButton.removeKeyListener(this);
						
						dialogBoxPanel.revalidate();
						dialogBoxPanel.repaint();
					}
				};
				
				final KeyListener rightKeyListener = new KeyAdapter() {
					public void keyReleased(KeyEvent ke) {
						rightKey = new KeyEventWrapper(ke);
						rightKeyBindingLabel.setText(rightKey.getKeyString());
						rightButton.removeKeyListener(this);
						
						dialogBoxPanel.revalidate();
						dialogBoxPanel.repaint();
					}
				};
				
				ActionListener leftButtonListener = new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						leftButton.addKeyListener(leftKeyListener);
						leftKeyBindingLabel.setText("Please enter a key");
						dialogBoxPanel.revalidate();
						dialogBoxPanel.repaint();
					}
				};
				
				ActionListener rightButtonListener = new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						rightButton.addKeyListener(rightKeyListener);
						rightKeyBindingLabel.setText("Please enter a key");
						dialogBoxPanel.revalidate();
						dialogBoxPanel.repaint();
					}
				};
				
				leftButton.addActionListener(leftButtonListener);
				rightButton.addActionListener(rightButtonListener);
			}
		};
		

		mouseRadioButton.addActionListener(mouseRadioButtonListener);
		keyboardRadioButton.addActionListener(keyboardRadioButtonListener);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		leftKeyBindingLabel.setVisible(false);
		rightKeyBindingLabel.setVisible(false);
		
		buttonGroup.add(mouseRadioButton);
		buttonGroup.add(keyboardRadioButton);
		
		dialogBoxPanel.add(mouseRadioButton);
		dialogBoxPanel.add(keyboardRadioButton);
		dialogBoxPanel.add(leftButton);
		dialogBoxPanel.add(rightButton);
		dialogBoxPanel.add(leftKeyBindingLabel);
		dialogBoxPanel.add(rightKeyBindingLabel);
		
		this.add(dialogBoxPanel);
		
	}
	
}
