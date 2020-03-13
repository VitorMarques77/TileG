package dev.tilegame.tiles;

public class TileManager {

	// a array of tiles so we can store every tile we have in our world inside it
	public static Tile[] tiles = new Tile[256];

	// we are going to instantiate every tile and store inside a Tile variable
	// passing an ID. Doing this the tiles array will store every tile inside it
	// the position will be related to the ID assign to the tile
	public static Tile grassTile = new GrassTile(0);

	public static Tile dirtTile = new DirtTile(1);

	public static Tile rockTile = new RockTile(2);
	
	

}
