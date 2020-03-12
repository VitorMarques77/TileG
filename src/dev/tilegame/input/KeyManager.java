package dev.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//class to map all the inputs we going to make through the keyboard
//link pressing, release and type keys
public class KeyManager implements KeyListener{

	/*every single key on the keyboard has a code called keycode
	using an array of boolean we going to relate the id code with
	the position of the array, so if the key is pressed and has an
	id of 123 then in the keys array we going to set the position
	[123] to true.*/
	private boolean[] keys;
	
	public boolean up, down, left, right;
	
	
	public KeyManager () {
		keys = new boolean[256];
	}
	
	/* in this method we are going to check every time if the position of the
	keys we wanted to assign to the movement of the player are true or false
	and store that in the variables we declare*/
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		/*this line of code is going to set
		 any keycode pressed to true*/
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		/*this line of code is going to set
		 any keycode released to false*/
		keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
