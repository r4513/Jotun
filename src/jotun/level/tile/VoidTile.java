package jotun.level.tile;

import jotun.graphics.Sprite;

public class VoidTile extends Tile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VoidTile(Sprite sprite) {
		super(sprite,-1,-1);
		_isSolid = true;
	}
}
