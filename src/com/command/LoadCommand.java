/**
 * 
 */
package com.command;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.apache.log4j.Logger;

import com.action.Actions;
import com.controller.GameController;
import com.event.Events;
import com.launcher.Constants;
import com.model.SavableGameObject;
import com.model.Sprite;

/**
 * This com.command loads the selected game maker file which stores user
 * activity.
 * 
 * @author team5
 *
 */
public class LoadCommand implements Command {
	private static final Logger LOGGER = Logger.getLogger(LoadCommand.class);

	private GameController gameController;

	public LoadCommand(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void executeCommand() {

		File savedFileDir = new File(Constants.AUTO_SAVE_PATH);
		File[] fileArray = savedFileDir.listFiles();

		JButton load = new JButton(Constants.LOAD);
		JButton loadAnother = new JButton(Constants.LOAD_ANOTHER);
		JButton cancel = new JButton(Constants.CANCEL);

		loadAnother.addActionListener(new LoadCustomFileListener());
		load.addActionListener(new LoadAutoSavedFileListener());
		cancel.addActionListener(new CancelButtonListener());

		JRadioButton radioButton = new JRadioButton(fileArray[0].getName());
		radioButton.setSelected(true);
		radioButton.setVisible(true);

		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();

		panel.setLayout(new GridLayout(0, 1));
		panel.add(radioButton);

		panel2.add(load);
		panel2.add(loadAnother);
		panel2.add(cancel);

		panel.add(panel2);

		JDialog jd = new JDialog();
		jd.add(panel);
		jd.setLocationRelativeTo(gameController.getGameContainer());
		jd.pack();
		jd.setVisible(true);
	}

	/**
	 * Loads the saved game file.
	 * 
	 * @param file
	 * @return
	 */
	private SavableGameObject loadFile(File file) {
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		SavableGameObject gameObject = null;
		try {
			fileIn = new FileInputStream(file);
			in = new ObjectInputStream(fileIn);
			gameObject = (SavableGameObject) in.readObject();

		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage() + e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage() + e);
		} catch (ClassNotFoundException e) {
			LOGGER.error(e.getMessage() + e);
		} finally {
			try {
				in.close();
				fileIn.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage() + e);
			}
		}
		return gameObject;
	}

	/**
	 * This method retrieves Image object for all the sprites from the saved
	 * files. It is needed as the Image object is not Serializable.
	 * 
	 * @param spriteList
	 * @return
	 */
	private List<Sprite> retrieveSpriteImages(List<Sprite> spriteList) {

		for (Sprite sprite : spriteList) {
			ImageIcon icon = new ImageIcon(this.getClass().getClassLoader()
					.getResource(Constants.SPRITES_IMAGE_PATH + "/" + sprite.getImageName()));
			sprite.setImage(icon.getImage());
		}
		return spriteList;
	}

	/**
	 * This method retrieves Image object from the name of background image in
	 * String format.
	 * 
	 * @param imageName
	 * @return
	 */
	private Image retrieveBackgroundImage(String imageName) {
		gameController.getGameContainer().getGameMakerPanel().getBackgroundImageComboBox().setSelectedItem(imageName);
		ImageIcon icon = new ImageIcon(
				this.getClass().getClassLoader().getResource(Constants.BACKGROUND_IMAGE_PATH + "/" + imageName));
		return icon.getImage();
	}

	/**
	 * This method re-associates all the sprites with their respective actions
	 * and events from the loaded object.
	 * 
	 * @param sprite
	 */
	private void retrieveEventsAndActions(List<Sprite> spriteList) {

		for (Sprite sprite : spriteList) {
			Map<Events, List<Actions>> eventActionMap = sprite.getEventActionMap();

			for (Events event : eventActionMap.keySet()) {
				event.getValue().addSprite(sprite);
			}
			gameController.getSpriteNames().add(sprite.getName());
		}
	}

	/**
	 * This method restores the event parameter map into all the concrete event
	 * classes.
	 * 
	 * @param gameObject
	 */
	private void retrieveEventParameterMap(SavableGameObject gameObject) {
		for (Entry<Object, Map<Object, Object>> entry : gameObject.getEventParameterMap().entrySet()) {
			Events.valueOf(entry.getKey().toString()).getValue().populateParameterMap(entry.getValue());
		}
	}

	/**
	 * This method populates the sprite list in game maker panel from loaded
	 * object.
	 */
	private void restoreCreatedSpriteList() {
		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(gameController.getSpriteNames().toArray());
		gameController.getGameContainer().getGameMakerPanel().getCreatedSpriteComboBox().setModel(model);
	}

	/**
	 * This method loads the custom saved file.
	 */
	private void loadCustomFile() {
		JFileChooser fileChooser = new JFileChooser();

		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			retrieveSavedFile(selectedFile);
		}
	}

	/**
	 * This class loads the auto saved file.
	 */
	private class LoadAutoSavedFileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent button = ((JComponent) e.getSource());
			Component[] cmp = ((JPanel) button.getParent().getParent()).getComponents();
			((JDialog) button.getRootPane().getParent()).dispose();

			String savedFileName = null;
			for (Component component : cmp) {
				if (component instanceof JRadioButton)
					savedFileName = ((JRadioButton) component).getText();
			}

			File savedFile = new File(Constants.AUTO_SAVE_PATH + savedFileName);
			retrieveSavedFile(savedFile);
		}
	}

	/**
	 * This class loads the custom saved file.
	 */
	private class LoadCustomFileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent button = ((JComponent) e.getSource());
			((JDialog) button.getRootPane().getParent()).dispose();
			loadCustomFile();
		}
	}

	/**
	 * This class closes the dialog box.
	 */
	private class CancelButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent button = ((JComponent) e.getSource());
			((JDialog) button.getRootPane().getParent()).dispose();
		}
	}

	/**
	 * This method retrieves the loaded object from selected saved file.
	 * 
	 * @param selectedFile
	 */
	private void retrieveSavedFile(File selectedFile) {
		SavableGameObject gameObject = loadFile(selectedFile);

		gameController.getGameContainer().getGamePlayPanel().setSavableGameObject(gameObject);

		List<Sprite> spriteList = gameObject.getSpriteList();
		gameObject.setSpriteList(retrieveSpriteImages(spriteList));
		Constants.wallConfigObj = gameObject.getWallConfig();

		retrieveEventsAndActions(spriteList);
		retrieveEventParameterMap(gameObject);
		restoreCreatedSpriteList();

		if (null != gameObject.getBackgroudImageName()) {
			gameObject.setBackgroudImage(retrieveBackgroundImage(gameObject.getBackgroudImageName()));
		}
		if (gameObject.isAddClock()) {
			gameController.getGameContainer().getClockPanel().getClockLabel().setVisible(true);
			gameController.getGameContainer().getGameMakerPanel().getAddClockCheckbox().setSelected(true);
		}

		gameController.getGameContainer().getGameMakerPanel().getPlayButton().setEnabled(true);
		gameController.getGameContainer().getGameMakerPanel().getAttachButton().setEnabled(true);
		gameController.getGameContainer().repaint();
	}
}
