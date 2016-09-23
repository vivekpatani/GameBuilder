/**
 * 
 */
package com.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.launcher.Constants;
import com.observer.Clock;
import com.observer.GenericObserver;

/**
 * This class creates a clock panel to be displayed on the game screen.
 * 
 * @author team5
 *
 */
public class ClockPanel extends JPanel implements GenericObserver<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5206308404412706678L;

	private JLabel clockLabel;

	public ClockPanel() {
		setBackground(new Color(111, 111, 111));
		setPreferredSize(new Dimension(Constants.GAME_PLAY_PANEL_WIDTH, Constants.MENU_PANEL_HEIGHT));

		clockLabel = new JLabel(Clock.getInstance().getClockDisplay());
		clockLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		clockLabel.setForeground(Color.DARK_GRAY);
		clockLabel.setVisible(false);

		this.add(clockLabel);
	}

	@Override
	public void update(Integer... data) {
		clockLabel.setText(Clock.getInstance().getClockDisplay());
	}

	/**
	 * @return the clockLabel
	 */
	public JLabel getClockLabel() {
		return clockLabel;
	}

	/**
	 * @param clockLabel
	 *            the clockLabel to set
	 */
	public void setClockLabel(JLabel clockLabel) {
		this.clockLabel = clockLabel;
	}

}
