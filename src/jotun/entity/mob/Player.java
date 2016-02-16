package jotun.entity.mob;

import java.io.Serializable;

import jotun.graphics.AnimatedSprite;
import jotun.graphics.Sprite;
import jotun.utils.Position;

public class Player extends NPC implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Animated sprites
	private AnimatedSprite idle = new AnimatedSprite(4);
	private AnimatedSprite down = new AnimatedSprite(12);
	private AnimatedSprite up = new AnimatedSprite(12);
	private AnimatedSprite right = new AnimatedSprite(12);
	private AnimatedSprite left = new AnimatedSprite(12);
	private AnimatedSprite currentAnimatedSprite = right;
	private Position targetPosition;

	public Player(int x, int y) {
		super(x,y, new Sprite(Sprite.player_idle1));
		setTargetPosition(new Position(x,y));
		initAnimations();
		getSprite().setX(16);
		getSprite().setY(16);
		getSprite().setWidth(32);
		getSprite().setHeight(32);
	}

	private void initAnimations() {
		this.idle.frames[0] = new Sprite(Sprite.player_idle1);
		this.idle.frames[1] = new Sprite(Sprite.player_idle2);
		this.idle.frames[2] = new Sprite(Sprite.player_idle3);
		this.idle.frames[3] = new Sprite(Sprite.player_idle4);
		
		this.up.frames[0] = new Sprite(Sprite.player_up1);
		this.up.frames[1] = new Sprite(Sprite.player_up2);
		this.up.frames[2] = new Sprite(Sprite.player_up3);
		this.up.frames[3] = new Sprite(Sprite.player_up4);
		this.up.frames[4] = new Sprite(Sprite.player_up5);
		this.up.frames[5] = new Sprite(Sprite.player_up6);
		this.up.frames[6] = new Sprite(Sprite.player_up7);
		this.up.frames[7] = new Sprite(Sprite.player_up8);
		this.up.frames[8] = new Sprite(Sprite.player_up9);
		this.up.frames[9] = new Sprite(Sprite.player_up10);
		this.up.frames[10] = new Sprite(Sprite.player_up11);
		this.up.frames[11] = new Sprite(Sprite.player_up12);
		
		this.down.frames[0] = new Sprite(Sprite.player_down1);
		this.down.frames[1] = new Sprite(Sprite.player_down2);
		this.down.frames[2] = new Sprite(Sprite.player_down3);
		this.down.frames[3] = new Sprite(Sprite.player_down4);
		this.down.frames[4] = new Sprite(Sprite.player_down5);
		this.down.frames[5] = new Sprite(Sprite.player_down6);
		this.down.frames[6] = new Sprite(Sprite.player_down7);
		this.down.frames[7] = new Sprite(Sprite.player_down8);
		this.down.frames[8] = new Sprite(Sprite.player_down9);
		this.down.frames[9] = new Sprite(Sprite.player_down10);
		this.down.frames[10] = new Sprite(Sprite.player_down11);
		this.down.frames[11] = new Sprite(Sprite.player_down12);
		
		this.left.frames[0] = new Sprite(Sprite.player_left1);
		this.left.frames[1] = new Sprite(Sprite.player_left2);
		this.left.frames[2] = new Sprite(Sprite.player_left3);
		this.left.frames[3] = new Sprite(Sprite.player_left4);
		this.left.frames[4] = new Sprite(Sprite.player_left5);
		this.left.frames[5] = new Sprite(Sprite.player_left6);
		this.left.frames[6] = new Sprite(Sprite.player_left7);
		this.left.frames[7] = new Sprite(Sprite.player_left8);
		this.left.frames[8] = new Sprite(Sprite.player_left9);
		this.left.frames[9] = new Sprite(Sprite.player_left10);
		this.left.frames[10] = new Sprite(Sprite.player_left11);
		this.left.frames[11] = new Sprite(Sprite.player_left12);
		
		this.right.frames[0] = new Sprite(Sprite.player_right1);
		this.right.frames[1] = new Sprite(Sprite.player_right2);
		this.right.frames[2] = new Sprite(Sprite.player_right3);
		this.right.frames[3] = new Sprite(Sprite.player_right4);
		this.right.frames[4] = new Sprite(Sprite.player_right5);
		this.right.frames[5] = new Sprite(Sprite.player_right6);
		this.right.frames[6] = new Sprite(Sprite.player_right7);
		this.right.frames[7] = new Sprite(Sprite.player_right8);
		this.right.frames[8] = new Sprite(Sprite.player_right9);
		this.right.frames[9] = new Sprite(Sprite.player_right10);
		this.right.frames[10] = new Sprite(Sprite.player_right11);
		this.right.frames[11] = new Sprite(Sprite.player_right12);
	}

	@Override
	public void update() {
		updateMoving();
		clear();
		updateShooting();
	}

	public void clear() {
		//Clear owned objects that are dead
	}

	private void updateMoving() {
		if (getAnimate() < getAnimateSpeed()) {
			setAnimate(getAnimate() + 1);
		} else {
			setAnimate(0);
		}
		
		if(getAnimate() % 5 == 0){
			currentAnimatedSprite.update();
		}

		if (getDirection() == Direction.UP) {
			currentAnimatedSprite = up;
		} else if (getDirection() == Direction.DOWN) {
			currentAnimatedSprite = down;
		} else if (getDirection() == Direction.LEFT) {
			currentAnimatedSprite = left;
		} else if (getDirection() == Direction.RIGHT) {
			currentAnimatedSprite = right;
		}else{
			currentAnimatedSprite = idle;
		}
		
		setSprite(currentAnimatedSprite.getFrame());
	}

	private void updateShooting() {
		
	}

	public Position getTargetPosition() {
		return targetPosition;
	}

	public void setTargetPosition(Position targetPosition) {
		this.targetPosition = targetPosition;
	}
}