package dev.tilegame.gfx;

import dev.tilegame.Game;
import dev.tilegame.entities.Entity;

// basically this class will create a camera that is going to move all the position of all tiles in the world based on the xOffset and yOffset variables
public class GameCamera {

	// xOffset will move tiles in the x axis, positive values will move to the left
	// and negative values the right same with yOffset, positive values will move up
	// and negative values will move down
	private float xOffset, yOffset;

	private Game game;

	public GameCamera(Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	// a method that will center the camera in a specifically entity
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
	}

	// this method will move the tiles accordingly to amount given in the parameters
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
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
