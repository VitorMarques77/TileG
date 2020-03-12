package dev.tilegame.states;

import java.awt.Graphics;

import dev.tilegame.Game;

//create a abstract class State that holds everything that every state have
public abstract class State {
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
