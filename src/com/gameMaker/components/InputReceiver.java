/**
 * 
 */
package com.gameMaker.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gameMaker.main.Overseer;
import com.gameMaker.util.Constants;

/**
 * @author {Abhijeet, Ankit, Jaini, Rohith, Vivek}
 * @file InputReceiver.java
 * {GameBuilder 0.9 : Living in Beta}
 */
public class InputReceiver implements Constants{
	
    private JButton paddlesizeInput, brickSizeInput;
    private Graphics mainBoard;
	private static JPanel panel;
	
	private JPanel ballPanel;
	private JTextField inputBallW;
	private JTextField inputBallH;
	private JButton ballSizeInput;
	private Ball b;
	
	private Overseer overseerObj;
	/**
	 * 
	 */
	public InputReceiver(Graphics g) {
		mainBoard = g;
		
	}
	/**
	 * @param panel
	 */
	public InputReceiver(JPanel panel, Overseer overseerObj) {
		super();
		this.panel = panel;
		
		this.overseerObj = overseerObj;
	}


	public void ball(){
		System.out.println("Enteres into ball ");
		ballSizeInput = new JButton(INPUT_MESSAGE_BALL);
		
		
		ballPanel = new JPanel();
		inputBallW = new JTextField (10);
        inputBallH = new JTextField (10);
      
        ballPanel.add(inputBallW);
        ballPanel.add(inputBallH);
        ballPanel.add(ballSizeInput);
        
        ballPanel.setVisible(true);
        
        panel.add(ballPanel);
        
        ballSizeInput.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
            	
            	/*if (false){
                JOptionPane.showMessageDialog(frame.getComponent(0), "Incorrect Inputs!");
            	}*/
            	{
            		System.out.println("into ball listener");
            	//label.setVisible(true);
    	        int inputIntW = Integer.parseInt(inputBallW.getText());
    	        int inputIntH = Integer.parseInt(inputBallH.getText());	            	
            	//ballOutput.setVisible(true);
            	//panel.add(ballOutput);
            	System.out.println("Lets make love:"+ inputIntW);
            	System.out.println("Lets make love:"+ inputIntH);
            	
            	// The problem was your initial cordinates were 250,250..that wouldn't fit the spritePanel
    	        b = new Ball(50, 50, inputIntW, inputIntH, Color.RED);
    	        // You were using spritePanel here, to print it there
    	        b.draw(ballPanel.getGraphics());
    	        
    	        // To print it on previewPanel you need overseerObj access
    	        b.draw(overseerObj.getControlView().getPreviewPanel().getGraphics());

                // inputBallW.setVisible(false);
                // inputBallH.setVisible(false);
                // ballSizeInput.setVisible(false);
            	}
            }
        });
	}


}
