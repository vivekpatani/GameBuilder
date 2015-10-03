/**
 * 
 */
package com.gameMaker.components;

import java.awt.Color;
import java.awt.Graphics;


/**
 * @author {Abhijeet, Ankit, Jaini, Rohith, Vivek}
 * @file Ball.java
 * {GameBuilder 0.9 : Living in Beta}
 */
public class Ball extends Structure {
	
	private boolean onScreen;
    private int xDir = 1, yDir = -1;
	private int BALL_X_START;
	private int BALL_Y_START;

    // Constructor
    public Ball(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        setOnScreen(true);
    }

    // Draw the ball
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }


    // Resets the ball to original position at center of screen
    public void reset() {
        x = BALL_X_START;
        y = BALL_Y_START;
        xDir = 1;
        yDir = -1;
    }

    // Mutator methods
    public void setXDir(int xDir) {
        this.xDir = xDir;
    }

    public void setYDir(int yDir) {
        this.yDir = yDir;
    }

    public void setOnScreen(boolean onScreen) {
        this.onScreen = onScreen;
    }

    // Accessor methods for location on board
    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    public boolean isOnScreen() {
        return onScreen;
    }
    
	public void move(int dx, int dy) {
		setYDir(dy);
		setXDir(dx);
	}

}