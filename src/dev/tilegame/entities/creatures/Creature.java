package dev.tilegame.entities.creatures;

import dev.tilegame.entities.Entity;

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
	
	// every creature has the possibility to move, so we going to use this variables to make a more
	// generic move method
	protected float xMove, yMove;

	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		yMove = 0;
		xMove = 0;
	}
	
	public void move() {
		x += xMove;
		y += yMove;
	}

	//GETTERS AND SETTERS
	
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
