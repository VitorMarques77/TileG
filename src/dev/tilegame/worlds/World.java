package dev.tilegame.worlds;

import java.awt.Graphics;

import dev.tilegame.Handler;
import dev.tilegame.tiles.Tile;
import dev.tilegame.tiles.TileManager;
import dev.tilegame.utils.Utils;

public class World {

	private Handler handler;

	// defines how much tiles going to have. Ex.: 5 width and 5 height means that
	// the world is going to have 5 tiles(64px) width and 5 tiles(64px) height
	public int width, height;

	// the location the player will spawn in the world
	private int spawnX, spawnY;

	private int[][] worldTiles;

	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}

	public void tick() {

	}

	// this method will loop through the width and height of the world
	// drawing the Tiles from the getTile method
	public void render(Graphics g) {

		// with this variables we now can render using the camera as reference only the
		// tiles that are in the screen and as we move the player around the map we
		// render the tiles that are appearing and stop rendering the tiles that are
		// disappearing

		// the xStart marks where we should start rendering, it's either 0 or the far
		// right of the screen
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);

		// the xEnd marks where we should stop rendering, it's either width or the or
		// the far left of the screen
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);

		// the yStart marks where we should start rendering, it's either 0 or the far
		// down of the screen
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);

		// the xEnd marks where we should stop rendering, it's either width or the or
		// the far up of the screen
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {

				// where we render the tiles of our world we apply the xOffset and yOffset of
				// the camera so we move the tiles in our world accordingly to the movement of
				// the camera
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	// this method takes the array of tiles and return the referenced tile that
	// needs to be draw
	public Tile getTile(int x, int y) {

		// if the player somehow get off the map, then it will return a grass tile by
		// default
		if (x < 0 || y < 0 || x == width || y >= height) {
			return TileManager.grassTile;
		}

		Tile t = TileManager.tiles[worldTiles[x][y]];
		if (t == null) {
			return TileManager.dirtTile;
		}
		return t;
	}

	// using the static method from utils.class we load our path and stores in an
	// array of strings
	// after we assign the first 4 values that holds respectively width, height, and
	// the coordinates x and y to the spawn of our player
	// after doing this we call 2 for loops to read pass through worldTiles array
	// storing in each position the respective value accordingly to the world file
	private void loadWorld(String path) {
		String[] tokens = Utils.loadFileAsString(path).split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		worldTiles = new int[width][height];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				worldTiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}
