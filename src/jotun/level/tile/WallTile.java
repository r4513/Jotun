package jotun.level.tile;

import jotun.graphics.Sprite;

public class WallTile extends Tile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WallTile(Sprite sprite, int x, int y) {
		super(sprite,x,y);
		_isSolid = true;
	}

}
