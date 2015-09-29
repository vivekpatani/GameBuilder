package gameMaker.util;

import java.awt.Rectangle;

public interface Constants {

	// MainFrame size
	public static final int windowWidth = 800;
	public static final int windowHeight = 650;
	
	// For splitting main frame in two
	public static final int splitSize = 300;
	// Splitting the ControlView in two for PreviewPanel
	public static final int splitControlViewSize = 150;

	public static enum gameType {Breakout, Tetris}
	public static final String[] gameTypeList = {"Please choose Game Layout", "Breakout", "Tetris"};
	public static final String[] SPRITE_LIST = {"Please choose Sprite", "Ball", "Brick", "Paddle"};
	public static final String[] BACKGROUND_LIST = {"Please choose Background", "dome", "green", "mountains","plain","skypale"};
	public static final Rectangle gameTypeBounds = new Rectangle (75, 20, 150, 30);
	public static final Rectangle DROPDOWN_DEFAULT_BOUNDS = new Rectangle (75, 20, 100, 30);
	
	public static final int ySpace = 50;
}
