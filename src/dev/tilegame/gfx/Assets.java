package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

//doing the draw image in game class using Assets secure that we only crop the images one time and then use it for our game
public class Assets {

	//width and height of the tile images from sprite sheet
	public static final int width = 32, height = 32;
	
	//create all the images in form of variable that our sprite sheet has
	public static BufferedImage player, dirt, grass, stone, tree;
	
	//method responsible for loading everything that our game is going to user(images, sounds, musics)
	public static void init() {
		
		//load the Sprite Sheet image and assign to our Sprite Sheet class so we can crop it
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		//crop the tiles and assign to the variables
		player = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width*2, 0, width, height);
		stone = sheet.crop(width*3, 0, width, height);
		tree = sheet.crop(0, height, width, height);
	}
	
}
