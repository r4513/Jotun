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

	//public static double scale = 1.25; // The scale for scaling the screen by 3 to increase performance
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;private Level level;
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
		//setScaleX(scale);
		//setScaleY(scale);
		level = new TownLevel(TownLevel.WIDTH, TownLevel.HEIGHT);
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
		GraphicsContext gc = getGraphicsContext2D();
		clear(gc);
		double xP = player.getX();
		double yP = player.getY();
		int xScroll = (int) Math.round(xP - (getWidth() / Tile.WIDTH) / 2);
		int yScroll = (int) Math.round(yP - (getHeight() / Tile.HEIGHT) / 2);
		double xOffset = -(xScroll * Tile.WIDTH);
		double yOffset = -(yScroll * Tile.HEIGHT + Tile.HEIGHT * 1.5);
		
		// Draw tiles
		int x0 = xScroll;
		int x1 = xScroll + (width + Tile.WIDTH) / Tile.WIDTH;
		int y0 = yScroll;
		int y1 = yScroll + (height + Tile.HEIGHT) / Tile.HEIGHT;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				this.level.getTile(x, y).getSprite().renderTile(gc, x, y, xOffset, yOffset);
			}
		}
		this.player.getSprite().render(gc, player.getX() * Tile.WIDTH, player.getY() * Tile.HEIGHT, xOffset,  yOffset);
		
		// Draw mouse
		gc.setFill(Color.RED);
	}

	private void clear(GraphicsContext gc) {
		gc.clearRect(0, 0, width, height);
	}

	public Player getPlayer() {
		return this.player;
	}
	
	public Level getLevel(){
		return this.level;
	}
}