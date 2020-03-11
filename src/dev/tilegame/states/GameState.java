package dev.tilegame.states;

import java.awt.Graphics;

import dev.tilegame.gfx.Assets;

public class GameState extends State {

	public GameState() {
		
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.dirt, 0, 0, null);
	}

}
