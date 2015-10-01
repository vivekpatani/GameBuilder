package com.gameMaker.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.gameMaker.main.Overseer;

public class ActionConfigPanel extends JPanel {

	private Overseer overseerObj;
	
	private JButton configureControls;
	private ChooseControlsDialog controlsDialog;
	
	public ActionConfigPanel (Overseer overseerObj) {
		
		this.overseerObj = overseerObj;
		initActionConfigPanel();
	}
	
	public void initActionConfigPanel() {
		configureControls = new JButton ("Configure Breakout Controls");
		
		ActionListener configControlsListener = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				showControlDiaglog();
			}
		};
		
		configureControls.addActionListener(configControlsListener);
		this.add(configureControls);
	}
	
	public void showControlDiaglog() {
		controlsDialog = new ChooseControlsDialog (overseerObj);
		// To-do make size constant
		controlsDialog.setSize(300, 150);
		controlsDialog.setLocationRelativeTo(overseerObj.getMainFrame());
		controlsDialog.setVisible(true);
	}
}
