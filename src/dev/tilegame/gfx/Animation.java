package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

// generic class responsible for change frames of a image to create an 
// animation perspective using time and speed as parameters
public class Animation {

	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;

	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}

	// this method we check if the time passed during the tick is greater than the
	// time we define to change frames
	// if is then we changed the frame of the image
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length) {
				index = 0;
			}
		}
	}

	// here we return the current buffered image to be render in the screen
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
}
