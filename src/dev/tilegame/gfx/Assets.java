package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

//doing the draw image in game class using Assets secure that we only crop the images one time and then use it for our game
public class Assets {

	// width and height of the tile images from sprite sheet
	public static final int width = 32, height = 32;

	// create all the images in form of variable that our sprite sheet has
	public static BufferedImage dirt, grass, stone, tree;

	// we can create animations in a game storing the frames of the movement in a
	// buffered image array the length of the array will be defined by the quantity
	// of images that will compose the animation
	public static BufferedImage[] player_down, player_up, player_left, player_right;

	// method responsible for loading everything that our game is going to
	// user(images, sounds, musics)
	public static void init() {

		// load the Sprite Sheet image and assign to our Sprite Sheet class so we can
		// crop it
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

		// crop the tiles and assign to the variables

		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_left = new BufferedImage[2];

		player_down[0] = sheet.crop(width * 4, 0, width, height);
		player_down[1] = sheet.crop(width * 5, 0, width, height);

		player_up[0] = sheet.crop(width * 6, 0, width, height);
		player_up[1] = sheet.crop(width * 7, 0, width, height);

		player_right[0] = sheet.crop(width * 4, height, width, height);
		player_right[1] = sheet.crop(width * 5, height, width, height);

		player_left[0] = sheet.crop(width * 6, height, width, height);
		player_left[1] = sheet.crop(width * 7, height, width, height);

		tree = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);

	}

}
