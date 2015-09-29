package gameMaker.view;


import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import gameMaker.listener.BackgroundSelectionListener;
import gameMaker.main.Overseer;
import gameMaker.util.Constants;

public class BackgroundConfigPanel extends JPanel{
	
	private Overseer overseerObj;
	private JComboBox<String> backgroundComboBox;
	
	public BackgroundConfigPanel(Overseer overseerObj){
		this.overseerObj = overseerObj;
		setLayout(new BorderLayout());
		backgroundComboBox = new JComboBox <String>(Constants.BACKGROUND_LIST);
		backgroundComboBox.setSelectedIndex(0);
		backgroundComboBox.setBounds(Constants.DROPDOWN_DEFAULT_BOUNDS);
		backgroundComboBox.addActionListener(new BackgroundSelectionListener(overseerObj, this));
		this.add(backgroundComboBox, BorderLayout.NORTH);		
		backgroundComboBox.setEnabled(true);
	}

}
