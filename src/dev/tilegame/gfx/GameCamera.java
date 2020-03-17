package dev.tilegame.gfx;

import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;
import dev.tilegame.tiles.Tile;

// basically this class will create a camera that is going to move all the position of all tiles in the world based on the xOffset and yOffset variables
public class GameCamera {

	// xOffset will move tiles in the x axis, positive values will move to the left
	// and negative values the right same with yOffset, positive values will move up
	// and negative values will move down
	private float xOffset, yOffset;

	private Handler handler;

	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	// this method will check if the camera is showing any blank space and rearrange
	// the xOffset and yOffset accordingly to not show then
	public void checkBlankSpace() {

		// if the xOffset is less than 0 then in the left corner of the map we are
		// showing blank spaces so we need to set it to 0
		if (xOffset < 0) {
			xOffset = 0;
		}

		// if the xOffset is greater than the width of the map then in the right corner
		// of the map we are showing blank spaces so we need to set it to width
		else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}

		// if the yOffset is less than 0 then in the up corner of the map we are
		// showing blank spaces so we need to set it to 0
		if (yOffset < 0) {
			yOffset = 0;
		}

		// if the yOffset is greater than the height of the map then in the bottom
		// corner of the map we are showing blank spaces so we need to set it to height
		else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
	}

	// a method that will center the camera in a specifically entity
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}

	// this method will move the tiles accordingly to amount given in the parameters
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
