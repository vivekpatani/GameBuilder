/**
 * 
 */
package com.gameMaker.components;

import java.awt.Color;
import java.awt.Graphics;

import com.gameMaker.util.Constants;

/**
 * @author {Abhijeet, Ankit, Jaini, Rohith, Vivek}
 * @file Paddle.java
 * {GameBuilder 0.9 : Living in Beta}
 */
public class Paddle extends Structure implements Constants{
	    // Variables
	    //private int xSpeed;

	    // Constructor
	    public Paddle(int x, int y, int width, int height, Color color) {
	        super(x, y, width, height, color);
	    }

	    // Draws the paddle
	    @Override
	    public void draw(Graphics g) {
	        g.setColor(color);
	        g.fillRect(x, y, width, height);
	    }

	    // Places the paddle back in starting position at center of screen
	    public void reset() {
	        x = PADDLE_X_START;
	        y = PADDLE_Y_START;
	    }

	    // Checks if the ball hit the paddle
	    public boolean hitPaddle(int ballX, int ballY) {
	        if ((ballX >= x) && (ballX <= x + width)
	                && ((ballY >= y) && (ballY <= y + height))) {
	            return true;
	        }
	        return false;
	    }

	    // makes use of the command interface. this is the execution performed 
	    //when key is pressed
		public void move(int dx, int dy) {
			setX(getX() + dx);
		}

	}
