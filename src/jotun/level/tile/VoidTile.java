package jotun.level.tile;

import jotun.graphics.Sprite;

public class VoidTile extends Tile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 32;
	
	public VoidTile(Sprite sprite) {
		super(sprite);
		_isSolid = true;
	}
}
