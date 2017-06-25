package com.ja.mrsss.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.ja.mrsss.handelers.GameStateManager;

public class Play extends GameState{
	
	private BitmapFont font = new BitmapFont();
	
	private Texture img;
	
	public Play(GameStateManager gsm){
		super(gsm);
		img = new Texture("badlogic.jpg");
	}
	
	public void handleInput(){
		
	}
	
	public void update(float dt){
		
	}

	public void render(){
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		sb.draw(img, 0, 0);
		font.draw(sb, "play state", 100, 100);
		sb.end();
		
		
	}
	
	public void dispose(){
		img.dispose();
		font.dispose();
	}
}
