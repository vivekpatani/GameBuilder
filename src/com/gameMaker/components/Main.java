package com.gameMaker.components;
/**
 * 
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gameMaker.util.Constants;

/**
 * @author {Abhijeet, Ankit, Jaini, Rohith, Vivek}
 * @file Main.java
 * {GameBuilder 0.9 : Living in Beta}
 */
public class Main implements Constants{
	
	protected static boolean inputFlag = false;
	
	Main(){
			
		try{

	        final JFrame frame = new JFrame();
	        JPanel panel = new JPanel();

	        final JLabel label = new JLabel("The Ball and it's size bruh!");
	        
	        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
	        frame.setTitle(FRAME_TITLE);
//	        label.setVisible(false);
	        frame.add(panel);
	        //InputReceiver ir = new InputReceiver(panel);
	        //ir.ball();
	        // panel.add(label);
	        panel.setVisible(true);
	        frame.setVisible(true);
	        
	        
	    	} catch (Exception e){
	    	e.printStackTrace();
	    }
	}
		private static void setField(){
			
		}
		public static void main(String[] args) {
	    	
			Main displayBall = new Main();
	    }
}