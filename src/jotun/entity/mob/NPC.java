package jotun.entity.mob;


import java.io.Serializable;

import jotun.entity.Entity;
import jotun.graphics.Sprite;
import jotun.level.tile.Tile;
import jotun.utils.Position;

public abstract class NPC extends Entity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int SIZE = 64;

	protected Sprite sprite;
	protected boolean moving = false;
	protected int animate = 0;
	protected int animateSpeed = 60;
	protected Direction direction;

	@Override
	public abstract void update();

	protected enum Direction {
		UP, DOWN, LEFT, RIGHT, IDLE;
	}
	
	public NPC(int x, int y) {
		super(x, y);
		this.direction = Direction.IDLE;
	}
	
	public void move(double xa, double ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}else if(xa != 0){
			Position target = new Position(position.x + xa, position.y);
			if(!collision(target.x, target.y)){
				position.x += xa / 64;
			}
		}else{
			Position target = new Position(position.x, position.y + ya);
			if(!collision(target.x, target.y)){
				position.y += ya / 64;
			}
		}

		if (xa > 0) {
			direction = Direction.RIGHT;
		} else if (xa < 0) {
			direction = Direction.LEFT;
		} else if (ya > 0) {
			direction = Direction.DOWN;
		} else if (ya < 0) {
			direction = Direction.UP;
		}else{
			direction = Direction.IDLE;
		}
	}

	private int absMove(double ya) {
		if (ya < 0) {
			return -1;
		}
		if (ya == 0) {
			return 0;
		}
		return 1;
	}

	public boolean collision(double xa, double ya) {
		boolean collision = false;
		
		if(level.getTile((int) Math.round(position.x + xa),(int) Math.round(position.y + ya)).solid()){
			collision = true;
		}
		
		return collision;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
}
