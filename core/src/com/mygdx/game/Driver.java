package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Driver extends Game {
	public SpriteBatch sb;
	public static final int height = 1600;
	public static final int width = 2560;
	public static boolean glow;

	@Override
	public void create () {
		sb = new SpriteBatch();
		if (Utils.generate(2)==1){
			glow = false;
		}else{
			glow =true;
		}
		int shooters = 10;
		int bullets = 100;
		setScreen(new ScreenSaver(this, shooters, bullets));
	}

	@Override
	public void render () {
		super.render();
	}
}
