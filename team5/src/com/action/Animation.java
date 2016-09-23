package com.action;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class Animation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient BufferedImage animImage;
	private int frameWidth;
	private int frameHeight;
	private long frameTime;
	private long startingFrameTime;
	private long timeForNextFrame;
	private int numberOfFrames;
	private int currentFrameNumber;
	private int x;
	private int y;
	private int startingXOfFrameInImage;
	private int endingXOfFrameInImage;
	private long timeOfAnimationCreation;
	public boolean active;
	private long showDelay;

	public Animation(BufferedImage animImage, int frameWidth, int frameHeight,
			int numberOfFrames, long frameTime, boolean loop, int x, int y,
			long showDelay) {
		this.animImage = animImage;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.frameTime = frameTime;

		this.x = x;
		this.y = y;

		this.showDelay = showDelay;
		this.timeOfAnimationCreation = System.currentTimeMillis();

		startingXOfFrameInImage = 0;
		endingXOfFrameInImage = frameWidth;

		startingFrameTime = System.currentTimeMillis() + showDelay;
		timeForNextFrame = startingFrameTime + this.frameTime;
		currentFrameNumber = 0;
		numberOfFrames = 12;
		active = true;
	}
	
	public Animation(int x, int y) throws IOException {		
		this.animImage = ImageIO.read(getClass().getResourceAsStream("explosion_anim.png"));
		this.frameWidth = 134;
		this.frameHeight = 134;
		this.frameTime = 45;

		this.x = x-25;
		this.y = y-25;

		this.showDelay = 0;
		this.timeOfAnimationCreation = System.currentTimeMillis();

		startingXOfFrameInImage = 0;
		endingXOfFrameInImage = frameWidth;

		startingFrameTime = System.currentTimeMillis() + showDelay;
		timeForNextFrame = startingFrameTime + this.frameTime;
		currentFrameNumber = 0;
		numberOfFrames = 12;
		active = true;
	}

	/**
	 * It checks if it's time to show next frame of the animation. It also
	 * checks if the animation is finished.
	 */
	private void update() {
		if (timeForNextFrame <= System.currentTimeMillis()) {
			// Next frame.
			currentFrameNumber++;
			if(currentFrameNumber >= numberOfFrames)
            {
                currentFrameNumber = 0;

                active = false;
            }
			// Starting and ending coordinates for cuting the current frame
			// image out of the animation image.
			else {
				startingXOfFrameInImage = currentFrameNumber * frameWidth;
				endingXOfFrameInImage = startingXOfFrameInImage + frameWidth;

				// Set time for the next frame.
				startingFrameTime = System.currentTimeMillis();
				timeForNextFrame = startingFrameTime + frameTime;
			}
					}
	}

	public void draw(Graphics g) {
		this.update();

		// Checks if show delay is over.
		if (this.timeOfAnimationCreation + this.showDelay <= System
				.currentTimeMillis() && active)
			g.drawImage(animImage, x, y, x + frameWidth, y + frameHeight,
					startingXOfFrameInImage, 0, endingXOfFrameInImage,
					frameHeight, null);
	}

}
