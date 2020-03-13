package dev.tilegame.tiles;

import dev.tilegame.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stone, id);
	}

	// a rock tile is not walkable so we call the method from the super class and
	// override it with the return of true so the tile block is solid
	@Override
	public boolean isSolid() {
		return true;
	}

}
