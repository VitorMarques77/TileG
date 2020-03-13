package dev.tilegame.states;

import java.awt.Graphics;

import dev.tilegame.Handler;

//create a abstract class State that holds everything that every state have
public abstract class State {
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
