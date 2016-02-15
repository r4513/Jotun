package jotun.level;

import java.io.Serializable;

import jotun.utils.Vector2I;

public class Node  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector2I _tile;
	private Node _parent;
	private double _fCost, _gCost, _hCost;
	
	public Node(Vector2I tile, Node parent, double gCost, double hCost){
		_tile = tile;
		_parent = parent;
		_gCost = gCost;
		_hCost = hCost;
		_fCost = gCost + hCost;
	}
	
	public Vector2I getTile() {
		return _tile;
	}
	public void setTile(Vector2I tile) {
		this._tile = tile;
	}
	public Node getParent() {
		return _parent;
	}
	public void setParent(Node parent) {
		this._parent = parent;
	}
	public double getFCost() {
		return _fCost;
	}
	public void setFCost(double fCost) {
		this._fCost = fCost;
	}
	public double getGCost() {
		return _gCost;
	}
	public void setGCost(double gCost) {
		this._gCost = gCost;
	}
	public double getHCost() {
		return _hCost;
	}
	public void setHCost(double hCost) {
		this._hCost = hCost;
	}
}
