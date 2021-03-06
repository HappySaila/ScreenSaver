package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by HappySaila on 10/31/16.
 * class will shoot bullet and move to another positon after the bullets have been fired.
 */
public class Shooter extends Sprite {
    xY position;
    xY destination;
    Vector2 shootDirection;
    int rotateSpeed;
    ArrayList<Texture> textures;
    ArrayList<Bullet> bullets;
    float timer;
    float shootDelay = 0.1f;
    enum State{
        SHOOT, MOVE;
    }
    State state;
    Driver game;

    public Shooter(Driver game, int numberBullets){
        super(new Texture("bullet0.png"));
        this.game = game;
        shootDirection = new Vector2(0,1);
        rotateSpeed = Utils.generate(1000);
        state = State.SHOOT;
        setPosition(Driver.width/2, Driver.height/2);
//        setPosition(Utils.generate(Driver.width), Utils.generate(Driver.height));
        bullets = new ArrayList<Bullet>();
        for (int i = 0; i < numberBullets; i++) {
            bullets.add(new Bullet(new Vector2(getX(), getY()), shootDirection.rotate(Utils.generate(360)), game));
        }
    }

    public void render(SpriteBatch sb, float delta){
        update(delta);
//        draw(sb);
        for (Bullet b:bullets){
            b.render(sb, delta);
        }
    }

    private void update(float delta){
        if (state == State.SHOOT){
//            fire(delta);
        }
    }
}
