package com.ja.mrsss.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ja.mrsss.Game;
import com.ja.mrsss.handelers.GameStateManager;

public abstract class GameState {
	protected GameStateManager gsm;
	protected Game game;
	
	protected SpriteBatch sb;
	protected OrthographicCamera cam;
	protected OrthographicCamera hudCam;
	
	protected GameState(GameStateManager gsm){
		this.gsm = gsm;
		game = gsm.getGame();
		sb = game.getSB();
		cam = game.getCam();
		if (cam == null){
			System.out.println("cam is null here at 1");
		}
		hudCam = game.getHudCam();
	}
	
	public abstract void handleInput();
	
	public abstract void update(float dt);

	public abstract void render();
	
	public abstract void dispose();
	
	
}
