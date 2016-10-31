package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by HappySaila on 10/31/16.
 */
public class ScreenSaver implements Screen{
    Driver game;
    Shooter shooter;
    ArrayList<Shooter> shooters;
    Vector2 position;

    public ScreenSaver(Driver game){
        this.game = game;
        shooter = new Shooter();
        createShooters(5);
        position = new Vector2(Driver.width/2, Driver.height/2);
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isTouched()){
            System.exit(0);
        }
        game.sb.begin();
        clearScreen();
        renderShooters(game.sb, delta);
        game.sb.end();
    }

    private void renderShooters(SpriteBatch sb, float delta){
        for (Shooter s:shooters){
            s.render(game.sb, delta);
            s.setPosition(position.x - s.getWidth()/2, position.y - s.getHeight()/2);
        }
    }

    private void clearScreen(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void createShooters(int i){
        shooters = new ArrayList<Shooter>();
        for (int j = 0; j < i; j++) {
            shooters.add(new Shooter());
        }
    }
    //region rubbish
    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    //endregion
}
