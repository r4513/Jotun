package jotun.level.tile;

import java.io.Serializable;

import jotun.graphics.Sprite;
import jotun.utils.Position;

public abstract class Tile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;

	// Class member variables
	private Position position;
	private Sprite _sprite;
	protected boolean _isSolid = false;
	protected boolean _isLiquid = false;

	public Tile(Sprite sprite, int x, int y) {
		_sprite = sprite;
		this.position = new Position(x,y);
	}

	public boolean solid() {
		return _isSolid;
	}

	public boolean isLiquid() {
		return _isLiquid;
	}

	public Sprite getSprite() {
		return _sprite;
	}

	public Position getPosition() {
		return position;
	}
}
