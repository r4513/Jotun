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
	public Position position;
	public boolean removed = false;
	public Level level;
	public final Random random = new Random();
	
	public Entity(int x, int y){
		this.position = new Position(x,y);
	}
	
	public abstract void update();
	
	public void init(Level level){
		this.level = level;
	}
	
	public double getX(){
		return this.position.getX();
	}
	
	public double getY(){
		return this.position.getY();
	}
	
	public void remove(){
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
}
