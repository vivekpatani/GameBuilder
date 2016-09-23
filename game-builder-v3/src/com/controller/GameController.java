/**
 * 
 */
package com.controller;

import java.util.HashSet;
import java.util.Set;

import com.command.AddClockCommand;
import com.command.AttachCommand;
import com.command.BackgroundChangeCommand;
import com.command.Command;
import com.command.CreateCommand;
import com.command.DeleteCommand;
import com.command.LoadCommand;
import com.command.PlayCommand;
import com.command.SaveCommand;
import com.model.Sprite;
import com.observer.Clock;
import com.ui.GameContainer;

/**
 * This class acts as the controller for all the requests coming from the user
 * and directs them to respective listeners to be executed.
 * 
 * @author team5
 *
 */
public class GameController {

	private GameContainer gameContainer;
	private Command saveCommand;
	private Command loadCommand;
	private Command playCommand;
	private Command attachCommand;
	private Command detachCommand;
	private Command createCommand;
	private Command deleteCommand;
	private Command backGroundChangeCommand;
	private Command addClockCommand;
	private Clock clock;

	private Sprite sprite;
	private Set<String> spriteNames;

	public GameController(GameContainer gameContainer) {
		this.gameContainer = gameContainer;
		this.spriteNames = new HashSet<String>();
		addCommandButtons();
		addButtonListeners();
	}

	/**
	 * This method binds command buttons to the controller.
	 */
	private void addCommandButtons() {
		saveCommand = new SaveCommand(this);
		loadCommand = new LoadCommand(this);
		createCommand = new CreateCommand(this);
		deleteCommand = new DeleteCommand(this);
		attachCommand = new AttachCommand(this);
		playCommand = new PlayCommand(this);
		backGroundChangeCommand = new BackgroundChangeCommand(this);
		addClockCommand = new AddClockCommand(this);
	}

	/**
	 * This methods binds action listeners on buttons to the controller.
	 */
	private void addButtonListeners() {
		this.gameContainer.getGameMakerPanel().addCoordinateListener(new CoordinateListener (this));
		this.gameContainer.getGameMakerPanel().addCreateListener(new CreateSpriteListener(this));
		this.gameContainer.getGameMakerPanel().addAttachButtonListener(new AttachButtonListener(this));
		this.gameContainer.getGameMakerPanel().addSaveButtonListener(new SaveButtonActionListener(this));
		this.gameContainer.getGameMakerPanel().addLoadButtonListener(new LoadButtonListener(this));
		this.gameContainer.getGameMakerPanel().addPlayButtonListener(new PlayButtonListener(this));
		this.gameContainer.getGameMakerPanel().addBackgroundImageChangeListener(new BackGroundChangeListener(this));
		this.gameContainer.getGameMakerPanel().addAddClockListener(new AddClockListener(this));
		this.gameContainer.getGameMakerPanel().addDeleteListener(new DeleteButtonListener(this));
		this.gameContainer.getGameMakerPanel().addWallCheckBoxListener(new WallCheckBoxListener(this));
	}

	/**
	 * @return the gameContainer
	 */
	public GameContainer getGameContainer() {
		return gameContainer;
	}

	/**
	 * @param gameContainer
	 *            the gameContainer to set
	 */
	public void setGameContainer(GameContainer gameContainer) {
		this.gameContainer = gameContainer;
	}

	/**
	 * @return the saveCommand
	 */
	public Command getSaveCommand() {
		return saveCommand;
	}

	/**
	 * @param saveCommand
	 *            the saveCommand to set
	 */
	public void setSaveCommand(Command saveCommand) {
		this.saveCommand = saveCommand;
	}

	/**
	 * @return the loadCommand
	 */
	public Command getLoadCommand() {
		return loadCommand;
	}

	/**
	 * @param loadCommand
	 *            the loadCommand to set
	 */
	public void setLoadCommand(Command loadCommand) {
		this.loadCommand = loadCommand;
	}

	/**
	 * @return the playCommand
	 */
	public Command getPlayCommand() {
		return playCommand;
	}

	/**
	 * @param playCommand
	 *            the playCommand to set
	 */
	public void setPlayCommand(Command playCommand) {
		this.playCommand = playCommand;
	}

	/**
	 * @return the attachCommand
	 */
	public Command getAttachCommand() {
		return attachCommand;
	}

	/**
	 * @param attachCommand
	 *            the attachCommand to set
	 */
	public void setAttachCommand(Command attachCommand) {
		this.attachCommand = attachCommand;
	}

	/**
	 * @return the detachCommand
	 */
	public Command getDetachCommand() {
		return detachCommand;
	}

	/**
	 * @param detachCommand
	 *            the detachCommand to set
	 */
	public void setDetachCommand(Command detachCommand) {
		this.detachCommand = detachCommand;
	}

	/**
	 * @return the createCommand
	 */
	public Command getCreateCommand() {
		return createCommand;
	}

	/**
	 * @param createCommand
	 *            the createCommand to set
	 */
	public void setCreateCommand(Command createCommand) {
		this.createCommand = createCommand;
	}

	/**
	 * @return the deleteCommand
	 */
	public Command getDeleteCommand() {
		return deleteCommand;
	}

	/**
	 * @param deleteCommand
	 *            the deleteCommand to set
	 */
	public void setDeleteCommand(Command deleteCommand) {
		this.deleteCommand = deleteCommand;
	}

	/**
	 * @return the backGroundChangeCommand
	 */
	public Command getBackGroundChangeCommand() {
		return backGroundChangeCommand;
	}

	/**
	 * @param backGroundChangeCommand
	 *            the backGroundChangeCommand to set
	 */
	public void setBackGroundChangeCommand(Command backGroundChangeCommand) {
		this.backGroundChangeCommand = backGroundChangeCommand;
	}

	/**
	 * @return the sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}

	/**
	 * @param sprite
	 *            the sprite to set
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * @return the spriteNames
	 */
	public Set<String> getSpriteNames() {
		return spriteNames;
	}

	/**
	 * @param spriteNames
	 *            the spriteNames to set
	 */
	public void setSpriteNames(Set<String> spriteNames) {
		this.spriteNames = spriteNames;
	}

	/**
	 * @return the clock
	 */
	public Clock getClock() {
		return clock;
	}

	/**
	 * @param clock
	 *            the clock to set
	 */
	public void setClock(Clock clock) {
		this.clock = clock;
	}

	/**
	 * @return the addClockCommand
	 */
	public Command getAddClockCommand() {
		return addClockCommand;
	}

	/**
	 * @param addClockCommand
	 *            the addClockCommand to set
	 */
	public void setAddClockCommand(Command addClockCommand) {
		this.addClockCommand = addClockCommand;
	}
}
