package gameMaker.util;

import java.awt.Rectangle;

public interface Constants {

	// MainFrame size
	public static final int windowWidth = 800;
	public static final int windowHeight = 650;

	// Size where the main frame is split in two
	public static final int splitSize = 300;

	// Handles the games added
	public static enum gameType {Breakout, Tetris}
	public static final String[] gameTypeList = {"Breakout", "Tetris"};
	
	// Dimenstions for the top ComboBox
	// To -do remove this and generalize it 
	public static final Rectangle gameTypeBounds = new Rectangle (75, 20, 150, 30);
	
	// Space to keep between the objects
	public static final int ySpace = 50;
}
