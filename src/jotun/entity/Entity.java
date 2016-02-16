package jotun.entity;

import java.io.Serializable;
import java.util.Random;

import jotun.level.Level;
import jotun.utils.Position;

public abstract class Entity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Position position;
	private boolean removed = false;
	private Level level;
	private final Random random = new Random();
	
	public Entity(int x, int y){
		this.position = new Position(x,y);
	}
	
	public abstract void update();
	
	public void init(Level level){
		this.setLevel(level);
	}
	
	public double getX(){
		return this.position.getX();
	}
	
	public double getY(){
		return this.position.getY();
	}
	
	public void addX(double xa){
		double x = this.position.getX();
		this.position.setX(x + xa);
	}
	
	public void addY(double ya){
		double y = this.position.getY();
		this.position.setY(y + ya);
	}

	public Random getRandom() {
		return random;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
}
