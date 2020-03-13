package dev.tilegame.tiles;

import dev.tilegame.gfx.Assets;

public class GrassTile extends Tile {

	// pass through constructor the image of a grass
	// that is stored in the Assets class
	public GrassTile(int id) {
		super(Assets.grass, id);
	}

}
