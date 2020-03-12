package dev.tilegame.entities.creatures;

import java.awt.Graphics;

import dev.tilegame.Game;
import dev.tilegame.gfx.Assets;

//the player entity has the attributes of creature(health) and entity(position) and its a class
//that is going to implement everything from the creature and entity
public class Player extends Creature {

	// we need a game object here to access the keymanager class
	private Game game;

	public Player(Game game, float x, float y) {

		// pass through the constructor the default width and height of a creature
		// this parameters are going to the entity constructor and going to be store in
		// the variables width and height
		super(x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	// where we update the position of player
	@Override
	public void tick() {

		// calling the input method first are going to set the direction where the
		// player should move and the speed
		getInput();

		// calling the move method from the super class (creature) will apply in the x
		// and y variables how much they should move and the direction
		move();
	}

	private void getInput() {

		// every time we call this method we have to reset the value of xMove and yMove
		// otherwise we are going to add even more movement to the player instead of the
		// standard speed
		xMove = 0;
		yMove = 0;

		// moving up in the y axis means that we have to subtract from the y variable
		// so we set the yMove to negative speed
		if (game.getKeyManager().up) {
			yMove = -speed;
		}

		// moving down in the y axis means that we have to add the value in the y
		// variable
		// so we set the yMove to positive speed
		if (game.getKeyManager().down) {
			yMove = speed;
		}

		// moving left in the x axis means that we have to subtract from the x variable
		// so we set the xMove to negative speed
		if (game.getKeyManager().left) {
			xMove = -speed;
		}

		// moving right in the x axis means that we have to add the value in the x
		// variable
		// so we set the xMove to positive speed
		if (game.getKeyManager().right) {
			xMove = speed;
		}
	}

	// where we draw our player
	@Override
	public void render(Graphics g) {

		// we can draw an image specifying the width and height we want
		// to draw on the screen
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}

}
