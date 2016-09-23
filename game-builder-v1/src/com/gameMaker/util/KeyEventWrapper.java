/*
 * KeyEventWrapper : Stores the keyEvent objects generated in a class object
 */

package com.gameMaker.util;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import org.apache.log4j.Logger;

public class KeyEventWrapper {
	
	private final static Logger log = Logger.getLogger(KeyEventWrapper.class);
    private KeyEvent keyEvent;

    // Constructor to initialize keyEvent
    public KeyEventWrapper(KeyEvent keyEvent) {
        this.keyEvent = keyEvent;
     }  

    // Custom equals to compare KeyEventWrapper objects
    public boolean equals(Object object) {
         if(object instanceof KeyEventWrapper) {
               KeyEventWrapper wrapper = (KeyEventWrapper) (object);
               KeyEvent k = wrapper.getKeyEvent();

               return (keyEvent.getKeyCode() == k.getKeyCode());
           } 
         return false;
     }

    // Returns the keyCode of the keyEvent
    public int getKeyCode() {
          return keyEvent.getKeyCode();
      }
    
    public String getKeyString() {
    	String temp = KeyStroke.getKeyStroke(keyEvent.getKeyCode(), 0).toString();
    	// Get the string after first space
    	// This is done to get "A" from "pressed A" and "released A"
    	temp = temp.substring(temp.indexOf(" ") + 1, temp.length());
    	return temp;
    }
    
    // get function to return keyEvent
    public KeyEvent getKeyEvent() {
        return keyEvent;
     }
}