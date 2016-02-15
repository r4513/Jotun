package jotun.level.tile;

import jotun.graphics.Sprite;

public class WaterTile extends Tile {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int HEIGHT = 32;
	
	
	public WaterTile(Sprite sprite) {
		super(sprite);
		_isLiquid = true;
	}
}
