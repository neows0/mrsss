package com.ja.mrsss.handelers;

import java.util.Stack;

import com.ja.mrsss.Game;
import com.ja.mrsss.states.GameState;
import com.ja.mrsss.states.Play;

public class GameStateManager {
	private Game game;
	
	private Stack<GameState> gameStates;
	
	public static final int PLAY = 89;
	
	public GameStateManager(Game game){
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(PLAY);
	}
	public void update(float dt) {
		gameStates.peek().update(dt);
	}
	
	public void render() {
		gameStates.peek().render();
	}
	
	public Game getGame() { return game; }
	
	// Helper method!
	private GameState getState(int state){
		if(state == PLAY) return new Play(this);
		return null;
	}
	
	public void setState(int state){
		popState();
		pushState(state);
		
	}
	public void pushState(int state){
		gameStates.push(getState(state));
	}
	public void popState(){
		GameState g = gameStates.pop();
		g.dispose();
	}
}
