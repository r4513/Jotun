package jotun.entity.mob;


import java.io.Serializable;

import jotun.entity.Entity;
import jotun.graphics.Sprite;
import jotun.level.tile.Tile;

public abstract class NPC extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int SIZE = 64;

	protected Sprite _sprite;
	protected boolean _moving = false;
	protected int _animate = 0;
	protected int _animateSpeed = 60;
	protected Direction _direction;
	protected double speed = 2;

	@Override
	public abstract void update();

	protected enum Direction {
		UP, DOWN, LEFT, RIGHT, IDLE;
	}

	public void move(double xa, double ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;

		}

		if (xa > 0) {
			_direction = Direction.RIGHT;
		} else if (xa < 0) {
			_direction = Direction.LEFT;
		} else if (ya > 0) {
			_direction = Direction.DOWN;
		} else if (ya < 0) {
			_direction = Direction.UP;
		}else{
			_direction = Direction.IDLE;
		}

		while (xa != 0) {
			if (Math.abs(xa) > 1) {
				if (!collision(absMove(xa), ya)) {
					xPosition += absMove(xa) * speed;
				}
				xa -= absMove(xa) * speed;
			} else {
				if (!collision(absMove(xa), ya)) {
					xPosition += xa * speed;
				}
				xa = 0;
			}
		}
		while (ya != 0) {
			if (Math.abs(ya) > 1) {
				if (!collision(xa, absMove(ya)) && !collision(xa, absMove(ya))) {
					yPosition += absMove(ya) * speed;
				}
				ya -= absMove(ya);
			} else {
				if (!collision(xa, absMove(ya))&& !collision(xa, absMove(ya))) {
					yPosition += ya * speed;
				}
				ya = 0;
			}
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
		boolean collition = false;
		double xt, yt;
		for (int c = 0; c < 4; c++) {
			xt = ((xPosition + xa) - c % 2 * (Tile.WIDTH - 1)) / Tile.WIDTH;
			yt = ((yPosition + ya) - c / 2 * (Tile.HEIGHT - 1) + (SIZE / 2))
					/ Tile.HEIGHT;
			int xi = (int) Math.ceil(xt);
			int yi = (int) Math.ceil(yt);

			if (c % 2 == 0) {
				xi = (int) Math.floor(xt);
			}

			if (c / 2 == 0) {
				yi = (int) Math.floor(yt);
			}

			if (_level.getTile(xi, yi).solid()) {
				collition = true;
			}
		}

		return collition;
	}
	
	public Sprite getSprite() {
		return _sprite;
	}
}
