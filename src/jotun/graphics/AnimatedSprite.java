package jotun.graphics;

import java.io.Serializable;

public class AnimatedSprite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Sprite[] frames;
    private double duration;
	private int counter = 0;
    
    public AnimatedSprite(int length){
    	frames = new Sprite[length];
    	duration = length - 1;
    }
    
    public Sprite getFrame()
    {
        return frames[counter];
    }

	public void update() {
		if(counter == duration){
			counter = 0;
		}else{
			counter++;
		}
	}
}
