package jotun.level.tile;

import jotun.graphics.Sprite;

public class WallTile extends Tile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 64;

	public WallTile(Sprite sprite) {
		super(sprite);
		_isSolid = true;
	}

}
