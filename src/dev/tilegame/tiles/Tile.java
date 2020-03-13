package dev.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

// class that holds everything that every tile has like a
// width an height, a position in the screen and the 
// possibility to draw yourself in the screen
public class Tile {

	// default width and height of a tile
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

	// the variable where we store the image of the tile
	protected BufferedImage texture;

	// the id we going to assign to the tile
	// every tile will have a different id
	protected final int id;

	//
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		TileManager.tiles[id] = this;
	}

	public int getId() {
		return id;
	}

	public void tick() {

	}

	// in the subclass we going to call this method so we can draw the tile
	// on the screen
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	// return if the tile block is walkable or not
	public boolean isSolid() {
		return false;
	}

}
