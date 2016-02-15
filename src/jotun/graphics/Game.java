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
		player = new Player(3,3);
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
		double xP = player.position.x;
		double yP = player.position.y;
		int xScroll = (int) Math.round(xP - (getWidth() / Tile.WIDTH) / 2);
		int yScroll = (int) Math.round(yP - (getHeight() / Tile.HEIGHT) / 2);
		
		// Draw tiles
		int x0 = xScroll;
		int x1 = xScroll + (width + Tile.WIDTH) / Tile.WIDTH;
		int y0 = yScroll;
		int y1 = yScroll + (height + Tile.HEIGHT) / Tile.HEIGHT;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				this.level.getTile(x, y).getSprite().renderTile(gc2d, x, y , -(xScroll * Tile.WIDTH), -(yScroll * Tile.HEIGHT + Tile.HEIGHT * 1.5));
			}
		}
		this.player.getSprite().render(gc2d, player.position.x * Tile.WIDTH, player.position.y* Tile.HEIGHT, -(xScroll * Tile.WIDTH),  -(yScroll * Tile.HEIGHT + Tile.HEIGHT * 1.5));
		
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