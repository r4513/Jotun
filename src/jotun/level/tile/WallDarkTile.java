package jotun.level.tile;

import jotun.graphics.Sprite;

public class WallDarkTile extends Tile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WallDarkTile(Sprite sprite, int x, int y) {
		super(sprite, x, y);
		setSolid(true);
	}

}
