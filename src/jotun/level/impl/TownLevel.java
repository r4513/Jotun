package jotun.level.impl;

import jotun.graphics.Sprite;
import jotun.level.Level;
import jotun.level.tile.GrassTile;
import jotun.level.tile.WallTile;

public class TownLevel extends Level{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TownLevel(int w, int h){
		super(w,h);
		generateLevel();
	}

	@Override
	public void generateLevel() {
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				if(x == 0 || x == width || y == 0 || y == height){
					tiles[x][y] = new WallTile(new Sprite(Sprite.wall_dark),x,y);
				}else{
					tiles[x][y] = new GrassTile(new Sprite(Sprite.grass),x,y);
				}
			}
		}
	}
}
