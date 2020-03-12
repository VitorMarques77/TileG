package dev.tilegame.states;

import java.awt.Graphics;

import dev.tilegame.Game;
import dev.tilegame.entities.creatures.Player;

//class that hold specifically what game state has like the player
public class GameState extends State {

	// the player belongs to the game state class
	private Player player;

	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
	}

	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}
