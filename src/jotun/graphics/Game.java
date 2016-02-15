package jotun.graphics;

import java.io.Serializable;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import jotun.entity.mob.Player;
import jotun.level.Level;
import jotun.level.impl.TownLevel;
import jotun.level.tile.Tile;

/**
 * Game class extends Canvas and implements Runnable
 * 
 * @author Rasmus Soee Christensen aka r4513
 *
 */
public class Game extends Canvas implements Serializable{

	private static final long serialVersionUID = 1L;
	private static int width;
	private static int height;
	//public static int _scale = 3; // The scale for scaling the screen by 3 to increase performance

	private Level level;
	private Player player;

	/**
	 * Game constructor
	 * 
	 * @param title
	 */
	public Game(int width) {
		super(width, width / 16 * 9);
		this.width = width;
		height = width / 16 * 9;
		//setScaleX(_scale);
		//setScaleY(_scale);
		level = new TownLevel(100,100);
		player = new Player(1 * Tile.WIDTH,1 * Tile.HEIGHT);
		level.addEntity(player);
	}

	/**
	 * Updates the game
	 */
	public void update() {
		level.update();
	}

	/**
	 * Renders to the buffers
	 */
	public void render() {
		GraphicsContext gc2d = getGraphicsContext2D();
		clear(gc2d);
		
		int viewportWidth = width;
		int viewportHeight = height;
		int offsetMaxX = this.level.getWidth() - viewportWidth;
		int offsetMaxY = this.level.getHeight() - viewportHeight;
		int offsetMinX = 0;
		int offsetMinY = 0;
		int camX = (int) Math.floor(this.player.getX()/ Tile.WIDTH - (viewportWidth/ Tile.WIDTH) / 2 ) ;
		int camY = (int) Math.ceil(this.player.getY() / Tile.HEIGHT + (viewportHeight/ Tile.HEIGHT) / 2) ;
		/*
		if (camX > offsetMaxX){
		    camX = offsetMaxX;
		}
		else if (camX < offsetMinX){
		    camX = offsetMinX;
		}
		if (camY > offsetMaxY){
		    camY = offsetMaxY;
		}
		else if (camY < offsetMinY){
		    camY = offsetMinY;
		}*/
		for(int x = camX; x < camX + 30; x++){
			for(int y = camY; y > camY - 30; y--){
				Tile tile = this.level.getTile(Math.round(x), Math.round(y));
				tile.getSprite().render(gc2d, x * Tile.WIDTH , y * Tile.HEIGHT);
			}
		}
		/*
		int xScroll = (int) Math.round(player.getX() - (getWidth())) / Tile.WIDTH;
		int yScroll = (int) Math.round(player.getY() + (getHeight())) / Tile.HEIGHT;
		//System.out.println("Scroll: " + xScroll + "," + yScroll);
		// Draw tiles
		for(int x = xScroll; x < xScroll+30; x++){
			for(int y = yScroll; y > yScroll - 30; y--){
				Tile tile = this.level.getTile(Math.round(x), Math.round(y));
				tile.getSprite().render(gc2d, x * Tile.WIDTH , y * Tile.HEIGHT);
			}
		}*/
		this.player.getSprite().render(gc2d, player.getX(), player.getY());
		
		// Draw mouse
		gc2d.setFill(Color.RED);
	}
	
	public void setToIsometricX(int isoX, int cartX, int cartY){
		isoX = cartX - cartY;
	}
	
	public void setToIsometricY(int isoY, int cartX, int cartY){
		isoY = (cartX + cartY) / 2;
	}

	private void clear(GraphicsContext gc2d) {
		gc2d.clearRect(0, 0, width, height);
	}

	public Player getPlayer() {
		return this.player;
	}
}