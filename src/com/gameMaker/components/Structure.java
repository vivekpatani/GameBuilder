/**
 * 
 */
package com.gameMaker.components;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author {Abhijeet, Ankit, Jaini, Rohith, Vivek}
 * @file Structure.java
 * {GameBuilder 0.9 : Living in Beta}
 */
public class Structure {
	
    // Variables
    protected int x, y, width, height;
    protected Color color;

    // Constructor
    public Structure(int x, int y, int width, int height, Color color) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    // Draw a structure
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    // Mutator methods
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // Accessor methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
}
