package dev.tilegame.entities.creatures;

import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;
import dev.tilegame.tiles.Tile;

//the creature class extends entity but still not implement the abstract methods
public abstract class Creature extends Entity {

	// default health that every creature going to have
	// we can change in the particularly class where we implements creature
	public static final int DEFAULT_HEALTH = 10;

	// default speed that every creature going to have
	// we can change in the particularly class where we implements creature
	public static final float DEFAULT_SPEED = 3.0f;

	// set the default width and height that the creatures are going to be draw
	// in the screen by the render method
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;

	protected int health;

	protected float speed;

	// every creature has the possibility to move, so we going to use this variables
	// to make a more
	// generic move method
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		yMove = 0;
		xMove = 0;
	}

	public void move() {
		moveX();
		moveY();
	}

	public void moveX() {

		if (xMove > 0) { // Moving right

			// this variable stores the down right position of the collision rectangle we
			// created so we can check if collide with any tile
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

			if (!colisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !colisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}

		} else if (xMove < 0) { // Moving left

			// this variable stores the down left position of the collision rectangle we
			// created so we can check if collide with any tile
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			// here we check if the tile is solid or not and we also check the whole height
			// line of the rectangle
			if (!colisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !colisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}

	public void moveY() {

		if (yMove < 0) { // Moving up

			// this variable stores the upper left position of the collision rectangle we
			// created so we can check if collide with any tile
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

			// here we check if the tile is solid or not and we also check the whole width
			// line of the rectangle
			if (!colisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !colisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}

		else if (yMove > 0) { // Moving down

			// this variable stores the upper right position of the collision rectangle we
			// created so we can check if collide with any tile
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

			if (!colisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !colisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}

		}
	}

	// this method will return true or false based in the position x and y of the
	// world if the tile is solid or not
	protected boolean colisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	// GETTERS AND SETTERS

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
