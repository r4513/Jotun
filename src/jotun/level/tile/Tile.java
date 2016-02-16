package jotun.level.tile;

import java.io.Serializable;

import jotun.graphics.Sprite;
import jotun.utils.Position;

public abstract class Tile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Width and height constants
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;
	//Tile constants
	public static final int VOIDTILE = 0;
	public static final int GRASSTILE = 1;
	public static final int ROADDARKTILE = 2;
	public static final int ROADSANDTILE = 3;
	public static final int SANDTILE = 4;
	public static final int WALLTILE = 5;
	public static final int WALLDARKTILE = 6;
	public static final int WATERTILE = 7;

	// Class member variables
	private Position position;
	private Sprite sprite;
	private boolean isSolid = false;
	private boolean isLiquid = false;

	public Tile(Sprite sprite, int x, int y) {
		this.sprite = sprite;
		this.sprite.init(x, y);
		this.position = new Position(x,y);
	}
	
	public static Tile createTile(int type, int x, int y){
		switch(type){
		case VOIDTILE : return new VoidTile(new Sprite(Sprite.void_sprite));
		case GRASSTILE : return new GrassTile(new Sprite(Sprite.grass), x, y);
		case ROADDARKTILE : return new RoadDarkTile(new Sprite(Sprite.dark_road), x, y);
		case ROADSANDTILE : return new RoadSandTile(new Sprite(Sprite.sand_road), x, y);
		case SANDTILE : return new SandTile(new Sprite(Sprite.sand), x, y);
		case WALLTILE : return new WallTile(new Sprite(Sprite.wall_red), x, y);
		case WALLDARKTILE : return new WallDarkTile(new Sprite(Sprite.wall_dark), x, y);
		case WATERTILE : return new WaterTile(new Sprite(Sprite.water3), x, y);
		}
		return null;
	}

	public boolean isLiquid() {
		return isLiquid;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public Position getPosition() {
		return position;
	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

	public void setLiquid(boolean isLiquid) {
		this.isLiquid = isLiquid;
	}
}
