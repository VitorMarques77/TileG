package dev.tilegame;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("TileGame", 300, 300);
		game.start();
	}
}
