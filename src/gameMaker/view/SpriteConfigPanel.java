package gameMaker.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.gameMaker.listener.SpriteSelectionListener;

import gameMaker.util.Constants;

public class SpriteConfigPanel extends JPanel {

	private JComboBox<String> spritesComboBox;
	
	public SpriteConfigPanel() {
		
		setLayout(new BorderLayout());
		spritesComboBox = new JComboBox <String>(Constants.SPRITE_LIST);
		spritesComboBox.setSelectedIndex(0);
		spritesComboBox.setBounds(Constants.DROPDOWN_DEFAULT_BOUNDS);
		spritesComboBox.addActionListener(new SpriteSelectionListener(this));
		this.add(spritesComboBox, BorderLayout.NORTH);		
		spritesComboBox.setEnabled(true);
		
		
	}
}
