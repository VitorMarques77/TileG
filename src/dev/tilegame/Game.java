package dev.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.tilegame.display.Display;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.GameCamera;
import dev.tilegame.input.KeyManager;
import dev.tilegame.states.GameState;
import dev.tilegame.states.MainMenuState;
import dev.tilegame.states.SettingsState;
import dev.tilegame.states.State;
import dev.tilegame.states.StateManager;

//Runnable allow class to run on a thread
public class Game implements Runnable {

	private Display display;

	private int width, height;

	private Thread thread;

	public String title;

	// controls the game loop
	private boolean running = false;

	// defines how the computer is going to draw things with canvas. Use buffer to
	// prevent flickering in the screen
	private BufferStrategy bs;

	// the paint brush to draw things to the canvas
	private Graphics g;

	// States

	private State gameState;
	private State mainMenuState;
	private State settingsState;

	// Input
	private KeyManager keyManager;

	// Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}

	// initialize all the stuff(display, images, etc)
	private void init() {
		display = new Display(title, width, height);

		// add to the frame, the keyListener responsible to map the inputs from the
		// keyboard
		display.getFrame().addKeyListener(keyManager);

		// calling this initializes the Assets and load all the stuff we going to use in
		// our game
		Assets.init();
		
		handler = new Handler(this);
		
		gameCamera = new GameCamera(handler, 0, 0);
		
		// initialize the State
		gameState = new GameState(handler);
		mainMenuState = new MainMenuState(handler);
		settingsState = new SettingsState(handler);
		StateManager.setState(gameState);
	}

	@Override
	public void run() {
		init();

		// how many times per second we want tick and render method to be called
		int fps = 60;

		// measure time in nanoseconds divided by fps return the amount of time between
		// calling tick and render methods
		double timePerTick = 1000000000 / fps;

		double delta = 0;

		long now;

		// return the current time of computer in nanoseconds
		long lastTime = System.nanoTime();

		// stores the amount of time until reaches 1 second in nanoseconds
		long timer = 0;

		int ticks = 0;

		// Game Loop
		while (running) {

			now = System.nanoTime();

			// how much time we have until we have to call render and tick methods again
			delta += (now - lastTime) / timePerTick;

			// we add the amount of time that passed
			timer += (now - lastTime);

			// set the lastTime variable equals now so we can count again in the while loop
			lastTime = now;

			// delta >= 1 means that we have to call tick and render method and do minus 1
			// from delta, so we can calculate again
			if (delta >= 1) {
				tick();
				render();
				// every time we tick and render we add 1 to the ticks variable
				ticks++;
				delta--;
			}

			// if the timer is greater or equal to 1 second in nanosecond measure we show in
			// the screen the amount of ticks
			// and reset the variables so we can count again
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// update all variables, positions, etc
	private void tick() {

		// call the tick method from keyManager that is going to check
		// if the movement keys are pressed
		keyManager.tick();

		// calls the tick method from the current state of our game
		// we have to check if it's not null before calling the method
		if (StateManager.getState() != null) {
			StateManager.getState().tick();
		}
	}

	// render or draw everything to the screen
	private void render() {

		// get the bufferStrategy from canvas and assign to the variable
		bs = display.getCanvas().getBufferStrategy();

		if (bs == null) {

			// if this is the first time the game is running we have to create a
			// bufferStrategy to our Canvas
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		// allow the paint brush to draw in this canvas by assigning the DrawGraphics to
		// the g variable
		g = bs.getDrawGraphics();

		// Clear Screen
		g.clearRect(0, 0, width, height);

		// Draw here

		// calls the render method from the current state of our game
		// we have to check if it's not null before calling the method
		if (StateManager.getState() != null) {
			StateManager.getState().render(g);
		}

		// End drawing

		// after the draw we have to show the graphics we painted in the canvas using
		// this method
		bs.show();

		// if you finished the draw, call this method to assure the drawing process will
		// be closed
		g.dispose();
	}

	// Use the synchronized word when working with threads
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;

		// constructor of thread takes which class do you want to run on the thread
		thread = new Thread(this);

		// this method calls the run method
		thread.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			// this method close the thread when the game stop
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
