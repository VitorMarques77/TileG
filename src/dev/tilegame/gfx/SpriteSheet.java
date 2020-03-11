package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	//Load the image through the constructor you want to crop
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	//method to cut a part of the image using x, y coordinates and width and height parameters
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
