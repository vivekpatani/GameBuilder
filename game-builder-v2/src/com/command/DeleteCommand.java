/**
 * 
 */
package com.command;


import com.controller.GameController;
import com.model.Sprite;
import com.ui.GameContainer;
/**
 * This com.command deletes the selected sprite.
 * 
 * @author team5
 *
 */
public class DeleteCommand implements Command {
	
	private GameContainer gameContainer;
	private GameController gameControllerObj;
	
	public DeleteCommand (GameContainer gameContainer){
		
		this.gameContainer = gameContainer;
		
	}

	@Override
	public void executeCommand() {
		
		gameControllerObj = new GameController(gameContainer);
		
		
		for(Sprite spriteObj : gameControllerObj.getGameContainer().getGamePlayPanel().getSavableGameObject().getSpriteList()) {
			
			System.out.println(spriteObj.getName());
		}
		System.out.println();
	}

}
