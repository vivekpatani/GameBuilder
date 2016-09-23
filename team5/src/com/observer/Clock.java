/**
 * 
 */
package com.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.event.Collision;
import com.event.TimeChange;

/**
 * @author team5
 *
 */
public class Clock implements GenericObservable<Integer> {
	private static Clock clock;
	private int minute, seconds, millis;
	private String clockDisplay = "00:00";
	private Timer timer;
	private BaseObservable<Integer> inputButtonObservable = new BaseObservable<Integer>();

	private Clock() {
		this.timer = new Timer(5, new TimerListener());
	}

	public static Clock getInstance() {
		if (null == clock) {
			clock = new Clock();
		}
		return clock;
	}

	private class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			updateClockDisplay();
			TimeChange.getInstance().triggerAction(0);
			Collision.getInstance().triggerAction(0);
			inputButtonObservable.notifyObserver();
		}
	}

	/**
	 * This method updates clock display every time the timer is triggered.
	 */
	private void updateClockDisplay() {
		if (seconds == 60) {
			minute++;
			seconds = 0;
			millis = 0;
		}
		clockDisplay = String.format("%02d:%02d", minute, seconds);
		millis += 5;
		seconds = millis / 1000;
	}

	public void reset() {
		timer.setDelay(5);
		timer.restart();
	}

	@Override
	public void addObserver(GenericObserver<Integer> observer) {
		inputButtonObservable.addObserver(observer);
	}

	@Override
	public void removeObserver(GenericObserver<Integer> observer) {
		inputButtonObservable.removeObserver(observer);
	}

	@Override
	public void notifyObserver(Integer... data) {
		inputButtonObservable.notifyObserver(data);
	}

	@Override
	public void removeAllObservers() {
		inputButtonObservable.removeAllObservers();
	}

	public void update(Integer... data) {
	}

	/**
	 * @return the clockDisplay
	 */
	public String getClockDisplay() {
		return clockDisplay;
	}

	/**
	 * @param clockDisplay
	 *            the clockDisplay to set
	 */
	public void setClockDisplay(String clockDisplay) {
		this.clockDisplay = clockDisplay;
	}
}
