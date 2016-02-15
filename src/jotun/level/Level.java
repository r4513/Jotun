package jotun.level;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jotun.entity.Entity;
import jotun.entity.mob.Player;
import jotun.graphics.Sprite;
import jotun.level.tile.Tile;
import jotun.level.tile.WaterTile;
import jotun.utils.Vector2I;

public abstract class Level  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Player> _players = new ArrayList<Player>();
	private List<Entity> _entities = new ArrayList<Entity>();
	public int width, height;
	protected Tile[][] tiles;

	public Level(int width, int height){
		tiles = new Tile[width][height];
		this.width = width;
		this.height= height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public abstract void generateLevel();
	
	public void addEntity(Entity e) {
		e.init(this);
		if (e instanceof Player) {
			_players.add((Player) e);
		} else {
			_entities.add(e);
		}
	}

	public void removeEntity(Entity e) {
		if (e instanceof Player) {
			_players.remove(e);
		} else {
			_entities.remove(e);
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return new WaterTile(new Sprite(Sprite.water1,x,y,Tile.WIDTH, Tile.HEIGHT));
		}
		return tiles[x][y];
	}

	public void update() {
		for (int i = 0; i < _entities.size(); i++) {
			_entities.get(i).update();
		}

		for (int i = 0; i < _players.size(); i++) {
			_players.get(i).update();
		}

		remove();
		tickTime();
	}
	
	private boolean isVecInList(List<Node> list, Vector2I vec) {
		for (Node n : list) {
			if (n.getTile().equals(vec)) {
				return true;
			}
		}
		return false;
	}

	private double getDistance(Vector2I start, Vector2I goal) {
		double x = start.getX() - goal.getX();
		double y = start.getY() - goal.getY();
		double distance = Math.sqrt(x * x + y * y);
		if (distance == 1) {
			return 1;
		}
		return 0.95;
	}

	public boolean tileCollision(int x, int y, int size, int xOffset,
			int yOffset) {
		boolean collition = false;
		int xt, yt;
		for (int c = 0; c < 4; c++) {
			xt = (x - c % 2 * size + xOffset) / Tile.WIDTH;
			yt = (y - c / 2 * size + yOffset) / Tile.HEIGHT;
			if (getTile(xt, yt).solid()) {
				collition = true;
			}
		}
		return collition;
	}
	
	private Comparator<Node> _nodeSorter = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
			if (n2.getFCost() < n1.getFCost()) {
				return 1;
			}
			if (n2.getFCost() > n1.getFCost()) {
				return -1;
			}
			return 0;
		}
	};
	
	public List<Node> findPath(Vector2I start, Vector2I goal) {
		List<Node> openList = new ArrayList<Node>(); // Consider these tiles
		List<Node> closedList = new ArrayList<Node>(); // Don't consider
		Node current = new Node(start, null, 0, getDistance(start, goal));

		openList.add(current);

		while (openList.size() > 0) {
			Collections.sort(openList, _nodeSorter);
			current = openList.get(0);
			if (current.getTile().equals(goal)) {
				List<Node> path = new ArrayList<Node>();
				while (current.getParent() != null) {
					path.add(current);
					current = current.getParent();
				}
				openList.clear();
				closedList.clear();

				return path;
			}
			openList.remove(current);
			closedList.add(current);
			for (int i = 0; i < 9; i++) {
				if (i == 4) {
					continue;
				}
				int x = current.getTile().getX();
				int y = current.getTile().getY();
				int xi = (i % 3) - 1;
				int yi = (i / 3) - 1;
				Tile tile = getTile(x + xi, y + yi);
				if (tile == null) {
					continue;
				}
				if (tile.solid()) {
					continue;
				}

				Vector2I vec = new Vector2I(x + xi, y + yi);
				double gCost = current.getGCost()
						+ (getDistance(current.getTile(), vec) == 1 ? 1 : 0.95);
				double hCost = getDistance(vec, goal);
				Node node = new Node(vec, current, gCost, hCost);

				if (isVecInList(closedList, vec) && gCost >= node.getGCost()) {
					continue;
				}
				if (!isVecInList(openList, vec) || gCost < node.getGCost()) {
					openList.add(node);
				}

			}
		}
		closedList.clear();
		return null;
	}
	
	private void tickTime() {
		// TODO Auto-generated method stub
		
	}

	private void remove() {
		for (int i = 0; i < _entities.size(); i++) {
			if (_entities.get(i).isRemoved()) {
				_entities.remove(i);
			}
		}
		for (int i = 0; i < _players.size(); i++) {
			if (_players.get(i).isRemoved()) {
				_players.remove(i);
			}
		}
	}

	
	public List<Player> getPlayers() {
		return _players;
	}

	public Player getPlayerAt(int i) {
		return _players.get(i);
	}

	public Player getClientPlayer() {
		return _players.get(0);
	}

	public List<Entity> getEntities(Entity e, int radius) {
		List<Entity> result = new ArrayList<Entity>();
		double ex = e.getX();
		double ey = e.getY();
		double x, y, dx, dy;
		double dist;
		Entity entity;
		for (int i = 0; i < _entities.size(); i++) {
			entity = _entities.get(i);
			if (e.equals(entity)) {
				continue;
			}
			x = entity.getX();
			y = entity.getY();
			dx = Math.abs(x - ex);
			dy = Math.abs(y - ey);
			dist = Math.sqrt((dx * dx) + (dy * dy));
			if (dist <= radius) {
				result.add(entity);
			}
		}
		return result;
	}

	public List<Player> getPlayers(Entity e, int radius) {
		List<Player> result = new ArrayList<Player>();
		double ex = e.getX();
		double ey = e.getY();
		double x, y, dx, dy;
		double dist;
		Player en;
		for (int i = 0; i < _players.size(); i++) {
			en = _players.get(i);
			x = en.getX();
			y = en.getY();
			dx = Math.abs(x - ex);
			dy = Math.abs(y - ey);
			dist = Math.sqrt((dx * dx) + (dy * dy));
			if (dist <= radius) {
				result.add(en);
			}
		}
		return result;
	}
}
