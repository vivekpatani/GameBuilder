/**
 * 
 */
package com.command;


import com.controller.DeleteSpriteDialog;
import com.controller.GameController;
import com.launcher.Constants;
/**
 * This com.command creates a JDialogBox with all listed sprites
 * and lets the user choose the ones to delete.
 * 
 * @author team5
 *
 */
public class DeleteCommand implements Command {
	
	private GameController gameControllerObj;
	
	public DeleteCommand (GameController gameControllerObj){
		
		this.gameControllerObj = gameControllerObj;
		
	}

	@Override
	public void executeCommand() {
		DeleteSpriteDialog deleteSpriteDialogObj = new DeleteSpriteDialog(gameControllerObj);
		deleteSpriteDialogObj.setSize(Constants.dialogWidth, Constants.dialogHeight);
		deleteSpriteDialogObj.setLocationRelativeTo(gameControllerObj.getGameContainer());
		deleteSpriteDialogObj.setVisible(true);
		deleteSpriteDialogObj.initDialogBox();
	}

}
