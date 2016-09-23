/**
 * 
 */
package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.action.Actions;
import com.action.MoveAndRotate;
import com.action.Vanish;
import com.event.Collision;
import com.event.Events;
import com.launcher.Constants;
import com.model.SavableGameObject;
import com.model.Sprite;
import com.observer.BaseObservable;
import com.observer.GenericObservable;
import com.observer.GenericObserver;

/**
 * This class contains components on game play screen.
 * 
 * @author team5
 *
 */
public class GamePlayPanel extends JPanel implements GenericObserver<Integer>, GenericObservable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8842878779462323972L;

	private final static Logger log = Logger.getLogger(GamePlayPanel.class);
	private SavableGameObject savableGameObject;
//	private Animation animation;
	private Vanish vanish = new Vanish();
	private MoveAndRotate moveRotate ;
	private BaseObservable<Integer> inputKeyObservable = new BaseObservable<Integer>();
	private int xCord, yCord;
	private boolean drawPosition;
	
	public GamePlayPanel() {
		BasicConfigurator.configure();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder());
		setPreferredSize(new Dimension(Constants.GAME_PLAY_PANEL_WIDTH, Constants.GAME_PLAY_PANEL_HEIGHT));
		this.savableGameObject = new SavableGameObject();
		this.addKeyListener(new KeyBoardListener());
	}

	// this is the event handle for the paddle movement
	private class KeyBoardListener extends KeyAdapter {

		public void keyPressed(KeyEvent event) {
			int key = event.getKeyCode();
			if (key == KeyEvent.VK_RIGHT) {
				inputKeyObservable.notifyObserver(Constants.EVENT_KEY_RIGHT);
			}
			if (key == KeyEvent.VK_LEFT) {
				inputKeyObservable.notifyObserver(Constants.EVENT_KEY_LEFT);
			}
			if (key == KeyEvent.VK_DOWN) {
				inputKeyObservable.notifyObserver(Constants.EVENT_KEY_DOWN);
			}
			if (key == KeyEvent.VK_UP) {
				inputKeyObservable.notifyObserver(Constants.EVENT_KEY_UP);
			}
			if (key == KeyEvent.VK_SPACE) {
				inputKeyObservable.notifyObserver(Constants.EVENT_KEY_SPACE);
			}
			/* adding new keys as part of a5 */
			if (event.getKeyChar() == 'a'){
				inputKeyObservable.notifyObserver(Constants.EVENT_KEY_A);
			}
			if (event.getKeyChar() == 'd'){
				inputKeyObservable.notifyObserver(Constants.EVENT_KEY_D);
			}
			if (event.getKeyChar() == 'w'){
				inputKeyObservable.notifyObserver(Constants.EVENT_KEY_W);
			}
			if (event.getKeyChar() == 'x'){
				inputKeyObservable.notifyObserver(Constants.EVENT_KEY_X);
			}
			repaint();
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(drawPosition) {
			Graphics2D g2d = (Graphics2D)g;
			 Ellipse2D.Double circle = new Ellipse2D.Double((double) xCord,  (double) yCord, Constants.highlightDiameter, Constants.highlightDiameter);
			 g2d.fill(circle);
			 g2d.drawString("This is where your Sprite will appear", (xCord + 1 + (int) Constants.highlightDiameter), (yCord + 1 + (int) Constants.highlightDiameter));
		}
		

		if (!savableGameObject.isGameOver()) {
			if (null != savableGameObject.getBackgroudImage()) {
				g.drawImage(savableGameObject.getBackgroudImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			}
			
			for (Sprite sprite : savableGameObject.getSpriteList()) {
				// Checks if the sprite has loosing property as true
				// In other words if the sprite is a main objective of the game
				if(sprite.getLoosingProperty()) {
					checkIfOut(sprite);
					checkIfDestroyed(sprite);
				}
					
				if (!sprite.isDestroyed()) {
					if(sprite.getEventActionMap().values().toString().contains(Actions.MOVEANDROTATE.toString())) {
						this.moveRotate = new MoveAndRotate(sprite);
						this.moveRotate.animation(g);
					}else {
						g.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), this);
					}
					
				} else {
					Map<Object, Object> eMap = null;
					for (Events e : sprite.getEventActionMap().keySet()) {
						if (e.equals(Events.COLLISION)) {
							eMap = ((Collision) e.getValue()).fetchParameterMap();
							break;
						}
					}
					if (null != eMap && null != eMap.get(Actions.VANISH)) {
						Sprite sp = (Sprite) eMap.get(Actions.VANISH);					
						this.vanish.draw(g,sp);
					}
				}
			}

		} 
		else {
			g.setFont(new Font("Verdana", Font.BOLD, 20));
			g.drawString("You Lose!!!", Constants.GAME_PLAY_PANEL_WIDTH / 3, Constants.GAME_PLAY_PANEL_HEIGHT / 2);
		}

	}
	
	public void checkIfOut(Sprite spriteObj) {
		// Logic to handle Game Over with sprite going through specific wall
		// Bottom wall logic
		if (spriteObj.getY() + spriteObj.getImage().getHeight(null) >= Constants.GAME_PLAY_PANEL_HEIGHT && !savableGameObject.getWallConfig().getBottomWall()) {
			savableGameObject.setGameOver(true);
			repaint();
		}
		//Left wall logic 
		if (spriteObj.getX() <= 0 && !savableGameObject.getWallConfig().getLeftWall()) {
			savableGameObject.setGameOver(true);
			repaint();
		}
		// Right wall logic
		if (spriteObj.getX() + spriteObj.getImage().getWidth(null) >= Constants.GAME_PLAY_PANEL_WIDTH && !savableGameObject.getWallConfig().getRightWall()) {
			savableGameObject.setGameOver(true);
			repaint();
		}
		// Top wall logic
		if (spriteObj.getY() <= 0 && !savableGameObject.getWallConfig().getTopWall()) {
			savableGameObject.setGameOver(true);
			repaint();
		}
	}
 
	public void checkIfDestroyed(Sprite spriteObj) {
		if(spriteObj.isDestroyed()) {
			savableGameObject.setGameOver(true);
			repaint();
		}
	}
	
	public void drawCordinates(int x, int y) {
		xCord = x;
		yCord = y;
		drawPosition = true;
		repaint();
	}
	
	public void removeCordinateHighlighting() {
		drawPosition = false;
		repaint();
	}
	
	@Override
	public void update(Integer... data) {
		repaint();
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

	@Override
	public void addObserver(GenericObserver<Integer> observer) {
		inputKeyObservable.addObserver(observer);
	}

	@Override
	public void removeObserver(GenericObserver<Integer> observer) {
		inputKeyObservable.removeObserver(observer);
	}

	@Override
	public void notifyObserver(Integer... data) {
		inputKeyObservable.notifyObserver(data);
	}

	@Override
	public void removeAllObservers() {
		inputKeyObservable.removeAllObservers();
	}

}