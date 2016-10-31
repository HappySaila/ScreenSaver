package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Driver extends Game {
	public SpriteBatch sb;
	public static final int height = 768;
	public static final int width = 1366;

	@Override
	public void create () {
		sb = new SpriteBatch();
		setScreen(new ScreenSaver(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
