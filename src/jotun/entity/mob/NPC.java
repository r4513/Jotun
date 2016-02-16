package jotun.entity.mob;


import java.io.Serializable;

import jotun.entity.Entity;
import jotun.graphics.Sprite;
import jotun.utils.Position;

public abstract class NPC extends Entity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int SIZE = 64;

	private Sprite sprite;
	private boolean moving = false;
	private int animate = 0;
	private int animateSpeed = 60;
	private Direction direction;

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
			Position target = new Position(getX() + xa, getY());
			if(!collision(target.x, target.y)){
				addX(xa / 32);
			}
		}else{
			Position target = new Position(getX(), getY() + ya);
			if(!collision(target.x, target.y)){
				addY(ya / 32);
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

	public boolean collision(double xa, double ya) {
		boolean collision = false;
		if(getLevel().getTile((int) Math.round(getX() + xa),(int) Math.round(getY() + ya)).isSolid()){
			collision = true;
		}
		return collision;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite){
		this.sprite = sprite;
	}
	
	public Direction getDirection(){
		return this.direction;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public int getAnimate() {
		return animate;
	}

	public void setAnimate(int animate) {
		this.animate = animate;
	}

	public int getAnimateSpeed() {
		return animateSpeed;
	}

	public void setAnimateSpeed(int animateSpeed) {
		this.animateSpeed = animateSpeed;
	}
}
