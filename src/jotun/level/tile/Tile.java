package jotun.level.tile;

import java.io.Serializable;

import jotun.graphics.Sprite;

public abstract class Tile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;

	// Class member variables
	private int _x, _y;
	private Sprite _sprite;
	protected boolean _isSolid = false;
	protected boolean _isLiquid = false;

	public Tile(Sprite sprite) {
		_sprite = sprite;
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

	public int getX() {
		return _x;
	}

	public void setX(int x) {
		_x = x;
	}

	public int getY() {
		return _y;
	}

	public void setY(int y) {
		_y = y;
	}
}
