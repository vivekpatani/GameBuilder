package gameMaker.util;

import java.awt.Rectangle;

public interface Constants {

	// MainFrame size
	public static final int windowWidth = 800;
	public static final int windowHeight = 650;
	
	public static final int splitSize = 300;

	public static enum gameType {Breakout, Tetris}
	public static final String[] gameTypeList = {"Breakout", "Tetris"};
	public static final Rectangle gameTypeBounds = new Rectangle (75, 20, 150, 30);
	
	public static final int ySpace = 50;
}
