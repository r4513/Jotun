package jotun.level.tile;

import jotun.graphics.Sprite;

public class WaterTile extends Tile {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WaterTile(Sprite sprite, int x, int y) {
		super(sprite,x,y);
		setSolid(true);
		setLiquid(true);
	}
}
