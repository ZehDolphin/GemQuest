package com.gemquest.main;

public class Settings {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	public static final int CAMERA_HEIGHT = 192;
	public static final int CAMERA_WIDTH = CAMERA_HEIGHT * 16 / 9;
	
	/**
	 * Should really be retrieved from the map file, but this is the lazy way..
	 */
	public static final int TILE_SIZE = 16;
	
	public static final String TITLE = "Gem Quest";
	
	public static final boolean RESIZABLE = true;
	
	public static final String COLLISION_LAYER_NAME = "Collision";
	
	
}
