package com.controller;

import java.io.Serializable;

/**
 * The purpose of this class is to contain all four panel frames/walls as true/false.
 * If a wall is true, objects should bounce off of it (primarily for AutoMove)
 * If a wall is false, the object(s) would go OutOfBounds and that can be checked as a way of GameOver/ loose life.
 * 
 * @author Team5 (Assignment #5)
*/
public class WallConfig implements Serializable {
	
	private boolean leftWall;
	private boolean rightWall;
	private boolean topWall;
	private boolean bottomWall;
	
	public WallConfig() {
		leftWall = true;
		rightWall = true;
		topWall = true;
		bottomWall = true;
	}

	// Mutators
	public void setLeftWall (boolean value) {
		leftWall = value;
	}
	public boolean getLeftWall() {
		return leftWall;
	}
	
	public void setRightWall (boolean value) {
		rightWall = value;
	}
	public boolean getRightWall() {
		return rightWall;
	}
	
	public void setTopWall (boolean value) {
		topWall = value;
	}	
	public boolean getTopWall() {
		return topWall;
	}
	
	public void setBottomWall (boolean value) {
		bottomWall = value;
	}
	public boolean getBottomWall() {
		return bottomWall;
	}
}
