package jotun.level.impl;

import jotun.level.Level;

public class TownLevel extends Level{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 60;
	public static int HEIGHT = 30;

	public TownLevel(int w, int h){
		super(w,h);
		generateLevel();
	}

	@Override
	public void generateLevel() {
		loadLevelFromFile("res\\maps\\TownLevel.map");
	}
}
