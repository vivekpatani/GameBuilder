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
	/**
	 * 
	 */
	public InputReceiver(Graphics g) {
		mainBoard = g;
		
	}
	/**
	 * @param panel
	 */
	public InputReceiver(JPanel panel) {
		super();
		this.panel = panel;
	}


	public static final void ball(){
		System.out.println("Enteres into ball ");
		JButton ballSizeInput = new JButton(INPUT_MESSAGE_BALL);
		
		
		JPanel ballPanel = new JPanel();
		
		JTextField inputBallW, inputBallH;
		
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
    	        Ball b = new Ball(250, 250, inputIntW, inputIntH, Color.white);
            	b.draw(ballPanel.getGraphics());
                inputBallW.setVisible(false);
                inputBallH.setVisible(false);
            	}
            }
        });

		
	}


}
