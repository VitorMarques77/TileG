package dev.tilegame.entities;

import java.awt.Graphics;

//this is a superclass that holds everything that all other entities have
public abstract class Entity {

	//position of the entity on the screen
	protected float x, y;
	
	//this variables will control the size of the entity we want to render
	protected int width, height;
	
	//initialize the variables when instantiate the class
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	//every entity has a tick method
	public abstract void tick();
	
	//every entity has a render method
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
