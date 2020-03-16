package dev.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.tilegame.Handler;

//this is a superclass that holds everything that all other entities have
public abstract class Entity {

	// to make a properly collision we going to create a rectangle that will fill
	// the collision box of an entity
	protected Rectangle bounds;

	protected Handler handler;

	// position of the entity on the screen
	protected float x, y;

	// this variables will control the size of the entity we want to render
	protected int width, height;

	// initialize the variables when instantiate the class
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		// here we initialize the collision rectangle
		bounds = new Rectangle(0, 0, width, height);
	}

	// every entity has a tick method
	public abstract void tick();

	// every entity has a render method
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
