package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
    OrthographicCamera camera;

    float rotateSpeed;
    float maxSpeed;
    boolean clockWise;

    public ScreenSaver(Driver game, int shooters, int bullets){
        this.game = game;
        createShooters(shooters, bullets);
        position = new Vector2(Driver.width/2, Driver.height/2);
        camera = new OrthographicCamera(Driver.width, Driver.height);
        camera.setToOrtho(true, Driver.width, Driver.height);
        camera.zoom = (2);
        maxSpeed = 1;
    }

    @Override
    public void render(float delta) {
        camera.update();
        camera.rotate(rotateSpeed);
        updateRotateSpeed(delta);
        if (Gdx.input.isTouched()){
            System.exit(0);
        }
        game.sb.setProjectionMatrix(camera.combined);
        game.sb.begin();
        clearScreen();
        renderShooters(game.sb, delta);
        game.sb.end();
    }

    private void renderShooters(SpriteBatch sb, float delta){
        for (Shooter s:shooters){
            s.render(game.sb, delta);
            s.setPosition(Gdx.input.getX() - s.getWidth()/2, Driver.height - Gdx.input.getY() - s.getHeight()/2);
        }
    }

    private void updateRotateSpeed(float delta){
        if (clockWise){
            rotateSpeed+=delta/10;
            if (rotateSpeed>maxSpeed){
                clockWise=false;
            }
        }else{
            rotateSpeed-=delta/10;
            if (rotateSpeed<-maxSpeed){
                clockWise=true;
            }
        }
    }

    private void clearScreen(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void createShooters(int shooters, int bullets){
        this.shooters = new ArrayList<Shooter>();
        for (int j = 0; j < shooters; j++) {
            this.shooters.add(new Shooter(game, bullets));
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
