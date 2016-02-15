package jotun.graphics;

import java.io.Serializable;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import jotun.level.tile.Tile;

public class Sprite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Tile sprites here
	public final static Image grass = new Image(Game.class.getResource("/sprites/tiles/grass.png").toString());
	public final static Image sand_road = new Image(Game.class.getResource("/sprites/tiles/sand_road.png").toString());
	public final static Image sand = new Image(Game.class.getResource("/sprites/tiles/sand.png").toString());
	public final static Image dark_road = new Image(Game.class.getResource("/sprites/tiles/dark_road.png").toString());
	public final static Image wall_red = new Image(Game.class.getResource("/sprites/tiles/wall_red.png").toString());
	public final static Image wall_dark = new Image(Game.class.getResource("/sprites/tiles/wall_dark.png").toString());
	public final static Image water1 = new Image(Game.class.getResource("/sprites/tiles/water1.png").toString());
	public final static Image water2 = new Image(Game.class.getResource("/sprites/tiles/water2.png").toString());
	public final static Image water3 = new Image(Game.class.getResource("/sprites/tiles/water3.png").toString());
	public final static Image void_sprite = new Image(Game.class.getResource("/sprites/tiles/water1.png").toString());
	
	//PlayerSprites
	//Idle
	public final static Image player_idle1 = new Image(Game.class.getResource("/sprites/player/player_idle3.png").toString());
	public final static Image player_idle2 = new Image(Game.class.getResource("/sprites/player/player_idle3.png").toString());
	public final static Image player_idle3 = new Image(Game.class.getResource("/sprites/player/player_idle3.png").toString());
	public final static Image player_idle4 = new Image(Game.class.getResource("/sprites/player/player_idle3.png").toString());
	//Left
	public final static Image player_left1 = new Image(Game.class.getResource("/sprites/player/player_left1.png").toString());
	public final static Image player_left2 = new Image(Game.class.getResource("/sprites/player/player_left2.png").toString());
	public final static Image player_left3 = new Image(Game.class.getResource("/sprites/player/player_left3.png").toString());
	public final static Image player_left4 = new Image(Game.class.getResource("/sprites/player/player_left4.png").toString());
	public final static Image player_left5 = new Image(Game.class.getResource("/sprites/player/player_left5.png").toString());
	public final static Image player_left6 = new Image(Game.class.getResource("/sprites/player/player_left6.png").toString());
	public final static Image player_left7 = new Image(Game.class.getResource("/sprites/player/player_left7.png").toString());
	public final static Image player_left8 = new Image(Game.class.getResource("/sprites/player/player_left8.png").toString());
	public final static Image player_left9 = new Image(Game.class.getResource("/sprites/player/player_left9.png").toString());
	public final static Image player_left10 = new Image(Game.class.getResource("/sprites/player/player_left10.png").toString());
	public final static Image player_left11 = new Image(Game.class.getResource("/sprites/player/player_left11.png").toString());
	public final static Image player_left12 = new Image(Game.class.getResource("/sprites/player/player_left12.png").toString());
	//Right
	public final static Image player_right1 = new Image(Game.class.getResource("/sprites/player/player_right1.png").toString());
	public final static Image player_right2 = new Image(Game.class.getResource("/sprites/player/player_right2.png").toString());
	public final static Image player_right3 = new Image(Game.class.getResource("/sprites/player/player_right3.png").toString());
	public final static Image player_right4 = new Image(Game.class.getResource("/sprites/player/player_right4.png").toString());
	public final static Image player_right5 = new Image(Game.class.getResource("/sprites/player/player_right5.png").toString());
	public final static Image player_right6 = new Image(Game.class.getResource("/sprites/player/player_right6.png").toString());
	public final static Image player_right7 = new Image(Game.class.getResource("/sprites/player/player_right7.png").toString());
	public final static Image player_right8 = new Image(Game.class.getResource("/sprites/player/player_right8.png").toString());
	public final static Image player_right9 = new Image(Game.class.getResource("/sprites/player/player_right9.png").toString());
	public final static Image player_right10 = new Image(Game.class.getResource("/sprites/player/player_right10.png").toString());
	public final static Image player_right11 = new Image(Game.class.getResource("/sprites/player/player_right11.png").toString());
	public final static Image player_right12 = new Image(Game.class.getResource("/sprites/player/player_right12.png").toString());
	//Up
	public final static Image player_up1 = new Image(Game.class.getResource("/sprites/player/player_up1.png").toString());
	public final static Image player_up2 = new Image(Game.class.getResource("/sprites/player/player_up2.png").toString());
	public final static Image player_up3 = new Image(Game.class.getResource("/sprites/player/player_up3.png").toString());
	public final static Image player_up4 = new Image(Game.class.getResource("/sprites/player/player_up4.png").toString());
	public final static Image player_up5 = new Image(Game.class.getResource("/sprites/player/player_up5.png").toString());
	public final static Image player_up6 = new Image(Game.class.getResource("/sprites/player/player_up6.png").toString());
	public final static Image player_up7 = new Image(Game.class.getResource("/sprites/player/player_up7.png").toString());
	public final static Image player_up8 = new Image(Game.class.getResource("/sprites/player/player_up8.png").toString());
	public final static Image player_up9 = new Image(Game.class.getResource("/sprites/player/player_up9.png").toString());
	public final static Image player_up10 = new Image(Game.class.getResource("/sprites/player/player_up10.png").toString());
	public final static Image player_up11 = new Image(Game.class.getResource("/sprites/player/player_up11.png").toString());
	public final static Image player_up12 = new Image(Game.class.getResource("/sprites/player/player_up12.png").toString());
	//Down
	public final static Image player_down1 = new Image(Game.class.getResource("/sprites/player/player_down1.png").toString());
	public final static Image player_down2 = new Image(Game.class.getResource("/sprites/player/player_down2.png").toString());
	public final static Image player_down3 = new Image(Game.class.getResource("/sprites/player/player_down3.png").toString());
	public final static Image player_down4 = new Image(Game.class.getResource("/sprites/player/player_down4.png").toString());
	public final static Image player_down5 = new Image(Game.class.getResource("/sprites/player/player_down5.png").toString());
	public final static Image player_down6 = new Image(Game.class.getResource("/sprites/player/player_down6.png").toString());
	public final static Image player_down7 = new Image(Game.class.getResource("/sprites/player/player_down7.png").toString());
	public final static Image player_down8 = new Image(Game.class.getResource("/sprites/player/player_down8.png").toString());
	public final static Image player_down9 = new Image(Game.class.getResource("/sprites/player/player_down9.png").toString());
	public final static Image player_down10 = new Image(Game.class.getResource("/sprites/player/player_down10.png").toString());
	public final static Image player_down11 = new Image(Game.class.getResource("/sprites/player/player_down11.png").toString());
	public final static Image player_down12 = new Image(Game.class.getResource("/sprites/player/player_down12.png").toString());	
	
	private Image image;
    private double positionX;
    private double positionY;    
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    public Sprite(Image image, int x, int y, int w, int h)
    {
        positionX = x;
        positionY = y;    
        velocityX = w;
        velocityY = h;
        this.image = image;
    }
    
    public Sprite()
    {
        positionX = 0;
        positionY = 0;    
        velocityX = 0;
        velocityY = 0;
    }

    public Sprite(Image image, int w, int h) {
    	positionX = 0;
        positionY = 0;    
        velocityX = w;
        velocityY = h;
        this.image = image;
	}

	public void setImage(Image i)
    {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename)
    {
        Image i = new Image(filename);
        setImage(i);
    }

    public void setPosition(double x, double y)
    {
        positionX = x;
        positionY = y;
    }

    public void setVelocity(double x, double y)
    {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time)
    {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }

    public void render(GraphicsContext gc)
    {
        gc.drawImage( image, positionX, positionY );
    }

    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(Sprite s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }
    
    public String toString()
    {
        return " Position: [" + positionX + "," + positionY + "]" 
        + " Velocity: [" + velocityX + "," + velocityY + "]";
    }
/*
	public void renderTileIsometric(GraphicsContext gc, int xIso, int yIso, int xOffset, int yOffset) {
		gc.drawImage( image, xIso + xOffset, yIso + yOffset);
		gc.fillText((int )positionX + "," + (int)positionY, (xIso + Tile.WIDTH / 3) + xOffset, (yIso + Tile.HEIGHT * 1.6) + yOffset);
	}
*/
	public void render(GraphicsContext gc, double x, double y) {
		gc.drawImage( image, x, y );
	}

/*
	public void renderIsometric(GraphicsContext gc, int xIso, int yIso, int xOffset, int yOffset) {
		gc.drawImage( image, xIso + xOffset, yIso + yOffset);
	}
*/
	public void render(GraphicsContext gc, double x, double y, double xoffset, double yoffset) {
		gc.drawImage( image, x + xoffset, y + yoffset);
	}
}
