package com.ja.mrsss;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ja.mrsss.handelers.GameStateManager;

public class Game extends ApplicationAdapter {
	SpriteBatch sb;
	
	
	public static final String TITLE = "Stab Slash Slice - The Game";
	public static final int V_WIDTH = 320;
	public static final int V_HEIGHT = 240;
	public static final int SCALE = 2;
	
	private OrthographicCamera cam;
	private OrthographicCamera hudCam;
	
	public static final float STEP = 1 / 60f;
	private float accum;
	
	private GameStateManager gsm;
	
	public SpriteBatch getSB() {
		return sb;
	}

	public OrthographicCamera getCam() {
		return cam;
	}

	public OrthographicCamera getHudCam() {
		return hudCam;
	}

	public void setBatch(SpriteBatch batch) {
		this.sb = batch;
	}

	public void setCam(OrthographicCamera cam) {
		this.cam = cam;
	}

	public void setHudCam(OrthographicCamera hudCam) {
		this.hudCam = hudCam;
	}

	@Override
	public void create () {
		sb = new SpriteBatch();
		
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		
		hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		//gsm must be below the cams
		gsm = new GameStateManager(this);
	}

	@Override
	public void render () {
		
		accum += Gdx.graphics.getDeltaTime();
		while(accum >= STEP){
			accum -= STEP;
			gsm.update(STEP);
			gsm.render();
		}
	}
	
	@Override
	public void dispose () {
		sb.dispose();
	}
}
