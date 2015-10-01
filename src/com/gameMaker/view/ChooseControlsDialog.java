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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private JButton cancelButton, okButton;
	
	
	public ChooseControlsDialog(Overseer overseerObj) {
		this.overseerObj = overseerObj;
		leftKey = overseerObj.getLeftMoveKey();
		rightKey = overseerObj.getRightMoveKey();
		selectControls();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	public void selectControls() {
		
		dialogBoxPanel = new JPanel();
		dialogBoxPanel.setLayout(new GridLayout(4,2));
		
		mouseRadioButton = new JRadioButton("Mouse Controls");
		keyboardRadioButton = new JRadioButton("Keyboard Controls");
		buttonGroup = new ButtonGroup();
		leftButton = new JButton("Move Left Key");
		rightButton = new JButton("Move Right Key");
		leftKeyBindingLabel = new JLabel(leftKey.getKeyString());
		rightKeyBindingLabel = new JLabel(rightKey.getKeyString());
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		
		ActionListener mouseRadioButtonListener = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// To-do Use enum to define a mode
				// GameControl.MOUSE;
				
				leftButton.setVisible(false);
				rightButton.setVisible(false);
				leftKeyBindingLabel.setVisible(false);
				rightKeyBindingLabel.setVisible(false);
				
				okButton.setEnabled(true);
				cancelButton.setEnabled(true);
				
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

				okButton.setEnabled(true);
				cancelButton.setEnabled(true);
				
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
						rightKeyBindingLabel.setText(rightKey.getKeyString());
						leftKeyBindingLabel.setText("Please enter a key");
						dialogBoxPanel.revalidate();
						dialogBoxPanel.repaint();
					}
				};
				
				ActionListener rightButtonListener = new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						rightButton.addKeyListener(rightKeyListener);
						leftKeyBindingLabel.setText(leftKey.getKeyString());
						rightKeyBindingLabel.setText("Please enter a key");
						dialogBoxPanel.revalidate();
						dialogBoxPanel.repaint();
					}
				};
				
				leftButton.addActionListener(leftButtonListener);
				rightButton.addActionListener(rightButtonListener);
			}
		};
		
		ActionListener okButtonListener = new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				if(keyboardRadioButton.isSelected()) {
					if(leftKey.equals(rightKey)) {
						JOptionPane.showMessageDialog(null, "Left and Right Key cannot be same!\n\nPlease change either to a different value.");
					}
					else {
						overseerObj.setLeftMoveKey(leftKey);
						overseerObj.setRightMoveKey(rightKey);
						disposeDialogBox();
					}
				}
			}
		};
		
		ActionListener cancelButtonListener = new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				disposeDialogBox();
			}
		};
		

		mouseRadioButton.addActionListener(mouseRadioButtonListener);
		keyboardRadioButton.addActionListener(keyboardRadioButtonListener);
		okButton.addActionListener(okButtonListener);
		cancelButton.addActionListener(cancelButtonListener);
		
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		leftKeyBindingLabel.setVisible(false);
		rightKeyBindingLabel.setVisible(false);
		
		okButton.setEnabled(false);
		cancelButton.setEnabled(false);
		
		buttonGroup.add(mouseRadioButton);
		buttonGroup.add(keyboardRadioButton);
		
		dialogBoxPanel.add(mouseRadioButton);
		dialogBoxPanel.add(keyboardRadioButton);
		dialogBoxPanel.add(leftButton);
		dialogBoxPanel.add(rightButton);
		dialogBoxPanel.add(leftKeyBindingLabel);
		dialogBoxPanel.add(rightKeyBindingLabel);
		dialogBoxPanel.add(okButton);
		dialogBoxPanel.add(cancelButton);
		
		this.add(dialogBoxPanel);
		
	}
	
	public void disposeDialogBox() {
				this.dispose();
		}	
}
