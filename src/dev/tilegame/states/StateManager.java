package dev.tilegame.states;

//this class is responsible to set and return the states of our game
public class StateManager {

	//create a state object that will hold the current state of our game
	private static State currentState = null;
	
	//set the current state of our game to the variable currentState using the parameter 
	public static void setState(State state) {
		currentState = state;
	}
	
	//return what state is active in our game
	public static State getState() {
		return currentState;
	}
}
