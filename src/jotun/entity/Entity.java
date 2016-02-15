package jotun.entity;

import java.io.Serializable;
import java.util.Random;

import jotun.level.Level;

public abstract class Entity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double xPosition, yPosition;
	protected boolean _removed = false;
	protected Level _level;
	protected final Random _random = new Random();
	
	public abstract void update();
	
	public void init(Level level){
		_level = level;
	}
	
	public double getX(){
		return xPosition;
	}
	
	public double getY(){
		return yPosition;
	}
	
	public void remove(){
		_removed = true;
	}
	
	public boolean isRemoved(){
		return _removed;
	}
}
