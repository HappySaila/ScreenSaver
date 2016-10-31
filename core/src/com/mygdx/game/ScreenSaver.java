package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by HappySaila on 10/31/16.
 */
public class ScreenSaver implements Screen{
    Driver game;
    Shooter shooter;

    public ScreenSaver(Driver game){
        this.game = game;
        shooter = new Shooter();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isTouched()){
            System.exit(0);
        }
        game.sb.begin();
        shooter.render(game.sb, delta);
        game.sb.end();
    }

    private void clearScreen(){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
