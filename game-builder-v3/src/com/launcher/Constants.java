/**
 * 
 */
package com.launcher;

import java.awt.Color;

import com.controller.WallConfig;

/**
 * This class holds the constants used at various places in game. Any new
 * constant should be included in this class and used.
 * 
 * @author team5
 *
 */
public class Constants {
	
	public static final String GAME_NAME = "Game Maker v1.8";
	public static final String NEW_CONFIGURATION = "Develop a New Configuration";
	public static final String LOAD = "Load";
	public static final String LOAD_ANOTHER = "Load Another";
	public static final String OK = "OK";
	public static final String CANCEL = "Cancel";
	public static final String AUTO_SAVE_PATH = "autosave/savedFiles/";
	public static final String AUTO_SAVE_FILE_NAME_PREFIX = "Autosave_";
	public static final String AUTO_SAVE_ARCHIEVE_PATH = "autosave/archieve";
	public static final String LAST_SAVED_LABEL_DATE_FORMAT = "MM-dd-yyyy HH:mm:ss";
	public static final String LAST_SAVED_FILE_DATE_FORMAT = "MMddyyyy_HHmmss";
	public static final String LAST_SAVED_LABEL = "Last Saved at : ";
	public static final String ADD_CLOCK_LABEL = "Display Clock ?";
	public static final String DATA = "data";
	public static final String SOUND = "Sound";
	public static final String ACTION_TYPE = "Action Type";
	public static final String EVENT_TYPE = "Event Type";
	public static final String NONE = "None";
	public static final String X_POSITION = "X-position";
	public static final String Y_POSITION = "Y-position";
	public static final String NAME = "Name";
	public static final String SPRITE_PANEL = "Sprite Panel";
	public static final String IMAGE_PANEL = "Image Panel";
	public static final String EVENT_PANEL = "Event Panel";
	public static final String CONTROL_PANEL = "Control Panel";
	public static final String BACKGROUND_PANEL = "Background Panel";
	public static final String FRAMEWALL_PANEL = "Frame Walls";
	public static final String ATTACH = "Attach";
	public static final String CREATE = "Create";
	public static final String DELETE = "Delete";
	public static final String SELECT = "SELECT";
	public static final String BACKGROUND_IMAGE = "Background Image";
	public static final String CREATED_SPRITELIST_LABEL = "Sprite List";
	public static final String LEFT_WALL = "Left Wall";
	public static final String RIGHT_WALL = "Right Wall";
	public static final String TOP_WALL = "Top Wall";
	public static final String BOTTOM_WALL = "Bottom Wall";
	public static final Color defaultColor = new Color(245, 252, 201);
	public static final int INITIAL_X_DIR = 1;
	public static final int INITIAL_Y_DIR = -1;

	public static final int FRAME_WIDTH = 1000;
	public static final int FRAME_HEIGHT = 700;
	public static final int GAME_BOARD_PANEL_WIDTH = 550;
	public static final int GAME_BOARD_PANEL_HEIGHT = 700;
	public static final int GAME_PLAY_PANEL_WIDTH = 540;
	public static final int GAME_PLAY_PANEL_HEIGHT = 600;
	public static final int GAME_MAKER_PANEL_WIDTH = 450;
	public static final int GAME_MAKER_PANEL_HEIGHT = 700;
	public static final int MENU_PANEL_HEIGHT = 50;
	public static final int VERTICAL_DISPLACEMENT = 30;
	public static final int HORIZONTAL_DISPLACEMENT = 30;
	public static final int splitFrameSize = GAME_MAKER_PANEL_WIDTH -5;
	public static final double highlightDiameter = 15;

	public static int bulletXCord = 0;
	public static int bulletYCord = 0;
	public static boolean bulletVisible = true;
	
	public static final String CONFIG_FILE_PATH = "resources/config/game-config.properties";
	public static final String SPRITES_IMAGE_PATH = "resources/img/sprites";
	public static final String BACKGROUND_IMAGE_PATH = "resources/img/background";
	public static final String APP_IMAGE_PATH = "resources/img/";
	public static final String SOUNDS_PATH = "resources/sounds/";

	// these constants are for observer pattern
	public static final Integer EVENT_TIMER = 1;
	public static final Integer EVENT_KEY_LEFT = 2;
	public static final Integer EVENT_KEY_RIGHT = 3;
	public static final Integer EVENT_KEY_UP = 4;
	public static final Integer EVENT_KEY_DOWN = 5;
	public static final Integer EVENT_KEY_SPACE = 6;
	public static final Integer EVENT_KEY_A = 7;
	public static final Integer EVENT_KEY_D = 8;
	public static final Integer EVENT_KEY_W = 9;
	public static final Integer EVENT_KEY_X = 10;
	
	// size for DeleteSpriteDialog
	public static final int dialogWidth = 300;
	public static final int dialogHeight = 150;
	
	// To store wall boolean values and let actions/events access it
	public static WallConfig wallConfigObj = new WallConfig();
}
