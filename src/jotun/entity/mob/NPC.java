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
	
	public NPC(int x, int y, Sprite sprite) {
		super(x, y);
		this.direction = Direction.IDLE;
		this.sprite = sprite;
		this.sprite.init(x,y);
	}
	
	public void move(double xa, double ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}else if(xa != 0){
			if(!collisionTile(getX() + xa, getY() + ya)){
				addX(xa / 16);
			}
		}else{
			if(!collisionTile(getX() + xa, getY() + ya)){
				addY(ya / 16);
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
	
	public boolean collisionTile(double xa, double ya){
		Tile target = this.getLevel().getTile((int)Math.round(xa),(int) Math.round(ya));
		if(target.getSprite().intersects(getSprite()) && target.isSolid()){
			System.out.println("Blocked: " + target.getPosition().getX() + "," + target.getPosition().getY());
			return true;
		}
		return false;
	}

	public boolean collision(double xa, double ya) {
		boolean collition = false;
		double xt, yt;
		for (int c = 0; c < 4; c++) {
			xt = ((getX() + xa) - c % 2 * (Tile.WIDTH - 1)) / Tile.WIDTH;
			yt = ((getY() + ya) - c / 2 * (Tile.HEIGHT - 1) + (SIZE / 2)) / Tile.HEIGHT;
			int xi = (int) Math.ceil(xt);
			int yi = (int) Math.ceil(yt);

			if (c % 2 == 0) {
				xi = (int) Math.floor(xt);
			}

			if (c / 2 == 0) {
				yi = (int) Math.floor(yt);
			}

			if (getLevel().getTile(xi, yi).isSolid()) {
				collition = true;
			}
		}

		return collition;
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
