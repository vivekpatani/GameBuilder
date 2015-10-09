/**
 * 
 */
package com.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Logger;

import com.launcher.Constants;
import com.model.Sprite;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * This class should implement the sound action that needs to be played on
 * related event.
 * 
 * @author team5
 *
 */
public class PlaySound implements Action, Runnable {
	private static final Logger LOGGER = Logger.getLogger(PlaySound.class);

	private Thread play;
	private Map<Object, Object> paramMap;

	@Override
	public void performAction(Map<Object, Object> paramMap, Sprite... spriteName) {
		this.paramMap = paramMap;
		play = new Thread(this);
		play.start();
	}

	@Override
	public void run() {
		String gongFile = Constants.SOUNDS_PATH + this.paramMap.get(Constants.SOUND);
		InputStream in;
		try {
			in = this.getClass().getClassLoader().getResourceAsStream(gongFile);
			AudioPlayer.player.start(new AudioStream(in));
		} catch (FileNotFoundException e) {
			LOGGER.warn(e);
		} catch (IOException e) {
			LOGGER.warn(e);
		}
	}
}
