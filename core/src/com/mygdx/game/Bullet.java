package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by HappySaila on 10/31/16.
 */
public class Bullet extends Sprite {
    int speed;
    Vector2 position;
    Vector2 direction;
    boolean alive;

    public Bullet(Vector2 position, Vector2 direction) {
        this.position = position;
        this.direction = direction;
    }

    public void render(SpriteBatch sb, float delta){
        update(delta);
    }

    private void update(float delta){

    }
}
