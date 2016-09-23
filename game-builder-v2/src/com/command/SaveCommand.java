/**
 * 
 */
package com.command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.controller.GameController;
import com.event.Events;
import com.launcher.Constants;
import com.model.SavableGameObject;

/**
 * This com.command saves the current state of user activity in a local file.
 * 
 * @author team5
 *
 */
public class SaveCommand implements Command {

	private static final Logger LOGGER = Logger.getLogger(SaveCommand.class);
	private GameController gameController;
	private SavableGameObject savableGameObject;
	private boolean isAutoSave;

	/**
	 * Parameterized Constructor
	 * 
	 * @param savableGameObject
	 */
	public SaveCommand(GameController gameController) {
		this.gameController = gameController;
		this.savableGameObject = gameController.getGameContainer().getGamePlayPanel().getSavableGameObject();
	}

	@Override
	public void executeCommand() {
		if (isAutoSave) {
			autoSave();
		} else {
			manualSave();
		}
	}

	/**
	 * @return the savableGameObject
	 */
	public SavableGameObject getSavableGameObject() {
		return savableGameObject;
	}

	/**
	 * @param savableGameObject
	 *            the savableGameObject to set
	 */
	public void setSavableGameObject(SavableGameObject savableGameObject) {
		this.savableGameObject = savableGameObject;
	}

	/**
	 * @return the isAutoSave
	 */
	public boolean isAutoSave() {
		return isAutoSave;
	}

	/**
	 * @param isAutoSave
	 *            the isAutoSave to set
	 */
	public void setAutoSave(boolean isAutoSave) {
		this.isAutoSave = isAutoSave;
	}

	/**
	 * This method is used to populate the event parameter map of all the
	 * concrete event classes into savable object.
	 */
	private void populateEventParameterMap() {
		Map<Object, Map<Object, Object>> eventParameterMap = new HashMap<>();
		for (Events event : Events.values()) {
			eventParameterMap.put(event.name(), event.getValue().fetchParameterMap());
		}
		savableGameObject.setEventParameterMap(eventParameterMap);
	}

	/**
	 * This method will be called while auto saving the game.
	 */
	private void autoSave() {
		this.isAutoSave = false;

		File savedFileDir = new File(Constants.AUTO_SAVE_PATH);
		File archieveDir = new File(Constants.AUTO_SAVE_ARCHIEVE_PATH);

		createArchieve(savedFileDir, archieveDir);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.LAST_SAVED_FILE_DATE_FORMAT);
		String stringDate = sdf.format(date);

		File savedFile = null;

		try {
			if (!savedFileDir.exists()) {
				savedFileDir.mkdirs();
			}
			savedFile = new File(Constants.AUTO_SAVE_PATH + Constants.AUTO_SAVE_FILE_NAME_PREFIX + stringDate + ".gsf");

			savedFile.createNewFile();
			saveToFile(savedFile);
			FileUtils.deleteDirectory(archieveDir);
			setLastAutoSaveMessage(date);
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

	/**
	 * This method will be called when user clicks on save button.
	 */
	private void manualSave() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Game State File", "gsf"));
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			saveToFile(file);
		}
	}

	/**
	 * This method saves the game file at the specified location.
	 * 
	 * @param file
	 */
	private void saveToFile(File file) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			populateEventParameterMap();
			out.writeObject(savableGameObject);
			out.close();
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

	/**
	 * This method updates the last saved message on game maker panel.
	 * 
	 * @param date
	 */
	private void setLastAutoSaveMessage(Date date) {
		SimpleDateFormat sdf2 = new SimpleDateFormat(Constants.LAST_SAVED_LABEL_DATE_FORMAT);

		JLabel autoSaveLabel = gameController.getGameContainer().getGameMakerPanel().getLastAutoSaveLabel();
		autoSaveLabel.setText(Constants.LAST_SAVED_LABEL + sdf2.format(date));
		autoSaveLabel.setVisible(true);
	}

	/**
	 * This method creates a backup of auto saved game files.
	 * 
	 * @param savedFileDir
	 * @param archieveDir
	 */
	private void createArchieve(File savedFileDir, File archieveDir) {

		if (savedFileDir.exists()) {
			try {
				FileUtils.copyDirectory(savedFileDir, archieveDir);
				FileUtils.cleanDirectory(savedFileDir);
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}
	}
}
