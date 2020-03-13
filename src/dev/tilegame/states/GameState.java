package dev.tilegame.states;

import java.awt.Graphics;

import dev.tilegame.Handler;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.worlds.World;

//class that hold specifically what game state has like the player
public class GameState extends State {

	// the player belongs to the game state class
	private Player player;
	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);
		
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
