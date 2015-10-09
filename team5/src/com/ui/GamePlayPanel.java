/**
 * 
 */
package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.action.Actions;
import com.action.Animation;
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

	private SavableGameObject savableGameObject;
//	private Animation animation;
	private Vanish vanish = new Vanish();
	private BaseObservable<Integer> inputKeyObservable = new BaseObservable<Integer>();

	public GamePlayPanel() {
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
			repaint();
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (!savableGameObject.isGameOver()) {
			if (null != savableGameObject.getBackgroudImage()) {
				g.drawImage(savableGameObject.getBackgroudImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			}

			for (Sprite sprite : savableGameObject.getSpriteList()) {
				if (sprite.getY() + sprite.getImage().getHeight(null) >= Constants.GAME_PLAY_PANEL_HEIGHT) {
					savableGameObject.setGameOver(true);
					repaint();
				}
				if (!sprite.isDestroyed()) {
					g.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), this);
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

		} else {
			g.setFont(new Font("Verdana", Font.BOLD, 20));
			g.drawString("You Lose!!!", Constants.GAME_PLAY_PANEL_WIDTH / 3, Constants.GAME_PLAY_PANEL_HEIGHT / 2);
		}

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