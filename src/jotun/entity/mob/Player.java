package jotun.entity.mob;

import java.io.Serializable;

import jotun.graphics.AnimatedSprite;
import jotun.graphics.Sprite;

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

	private AnimatedSprite _currentAnimatedSprite = right;

	public Player() {
		xPosition = 0;
		yPosition = 0;
		_sprite = new Sprite(Sprite.player_idle1,SIZE,SIZE);
		initAnimations();

	}

	public Player(int x, int y) {
		_sprite = new Sprite(Sprite.player_idle1, x,y,SIZE,SIZE);
		xPosition = x;
		yPosition = y;
		initAnimations();
	}

	private void initAnimations() {
		this.idle.frames[0] = new Sprite(Sprite.player_idle1,SIZE, SIZE);
		this.idle.frames[1] = new Sprite(Sprite.player_idle2,SIZE, SIZE);
		this.idle.frames[2] = new Sprite(Sprite.player_idle3,SIZE, SIZE);
		this.idle.frames[3] = new Sprite(Sprite.player_idle4,SIZE, SIZE);
		
		this.up.frames[0] = new Sprite(Sprite.player_up1,SIZE, SIZE);
		this.up.frames[1] = new Sprite(Sprite.player_up2,SIZE, SIZE);
		this.up.frames[2] = new Sprite(Sprite.player_up3,SIZE, SIZE);
		this.up.frames[3] = new Sprite(Sprite.player_up4,SIZE, SIZE);
		this.up.frames[4] = new Sprite(Sprite.player_up5,SIZE, SIZE);
		this.up.frames[5] = new Sprite(Sprite.player_up6,SIZE, SIZE);
		this.up.frames[6] = new Sprite(Sprite.player_up7,SIZE, SIZE);
		this.up.frames[7] = new Sprite(Sprite.player_up8,SIZE, SIZE);
		this.up.frames[8] = new Sprite(Sprite.player_up9,SIZE, SIZE);
		this.up.frames[9] = new Sprite(Sprite.player_up10,SIZE, SIZE);
		this.up.frames[10] = new Sprite(Sprite.player_up11,SIZE, SIZE);
		this.up.frames[11] = new Sprite(Sprite.player_up12,SIZE, SIZE);
		
		this.down.frames[0] = new Sprite(Sprite.player_down1,SIZE, SIZE);
		this.down.frames[1] = new Sprite(Sprite.player_down2,SIZE, SIZE);
		this.down.frames[2] = new Sprite(Sprite.player_down3,SIZE, SIZE);
		this.down.frames[3] = new Sprite(Sprite.player_down4,SIZE, SIZE);
		this.down.frames[4] = new Sprite(Sprite.player_down5,SIZE, SIZE);
		this.down.frames[5] = new Sprite(Sprite.player_down6,SIZE, SIZE);
		this.down.frames[6] = new Sprite(Sprite.player_down7,SIZE, SIZE);
		this.down.frames[7] = new Sprite(Sprite.player_down8,SIZE, SIZE);
		this.down.frames[8] = new Sprite(Sprite.player_down9,SIZE, SIZE);
		this.down.frames[9] = new Sprite(Sprite.player_down10,SIZE, SIZE);
		this.down.frames[10] = new Sprite(Sprite.player_down11,SIZE, SIZE);
		this.down.frames[11] = new Sprite(Sprite.player_down12,SIZE, SIZE);
		
		this.left.frames[0] = new Sprite(Sprite.player_left1,SIZE, SIZE);
		this.left.frames[1] = new Sprite(Sprite.player_left2,SIZE, SIZE);
		this.left.frames[2] = new Sprite(Sprite.player_left3,SIZE, SIZE);
		this.left.frames[3] = new Sprite(Sprite.player_left4,SIZE, SIZE);
		this.left.frames[4] = new Sprite(Sprite.player_left5,SIZE, SIZE);
		this.left.frames[5] = new Sprite(Sprite.player_left6,SIZE, SIZE);
		this.left.frames[6] = new Sprite(Sprite.player_left7,SIZE, SIZE);
		this.left.frames[7] = new Sprite(Sprite.player_left8,SIZE, SIZE);
		this.left.frames[8] = new Sprite(Sprite.player_left9,SIZE, SIZE);
		this.left.frames[9] = new Sprite(Sprite.player_left10,SIZE, SIZE);
		this.left.frames[10] = new Sprite(Sprite.player_left11,SIZE, SIZE);
		this.left.frames[11] = new Sprite(Sprite.player_left12,SIZE, SIZE);
		
		this.right.frames[0] = new Sprite(Sprite.player_right1,SIZE, SIZE);
		this.right.frames[1] = new Sprite(Sprite.player_right2,SIZE, SIZE);
		this.right.frames[2] = new Sprite(Sprite.player_right3,SIZE, SIZE);
		this.right.frames[3] = new Sprite(Sprite.player_right4,SIZE, SIZE);
		this.right.frames[4] = new Sprite(Sprite.player_right5,SIZE, SIZE);
		this.right.frames[5] = new Sprite(Sprite.player_right6,SIZE, SIZE);
		this.right.frames[6] = new Sprite(Sprite.player_right7,SIZE, SIZE);
		this.right.frames[7] = new Sprite(Sprite.player_right8,SIZE, SIZE);
		this.right.frames[8] = new Sprite(Sprite.player_right9,SIZE, SIZE);
		this.right.frames[9] = new Sprite(Sprite.player_right10,SIZE, SIZE);
		this.right.frames[10] = new Sprite(Sprite.player_right11,SIZE, SIZE);
		this.right.frames[11] = new Sprite(Sprite.player_right12,SIZE, SIZE);
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
		if (_animate < _animateSpeed) {
			_animate++;
		} else {
			_animate = 0;
		}
		
		if(_animate % 5 == 0){
			_currentAnimatedSprite.update();
		}

		if (this._direction == Direction.UP) {
			_currentAnimatedSprite = up;
		} else if (this._direction == Direction.DOWN) {
			_currentAnimatedSprite = down;
		} else if (this._direction == Direction.LEFT) {
			_currentAnimatedSprite = left;
		} else if (this._direction == Direction.RIGHT) {
			_currentAnimatedSprite = right;
		}else{
			_currentAnimatedSprite = idle;
		}
		
		_sprite = _currentAnimatedSprite.getFrame();
	}

	private void updateShooting() {
		
	}
}