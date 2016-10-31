package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

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

    public Shooter(){
        super(new Texture("shooter0.png"));
        shootDirection = new Vector2(0,1);
        rotateSpeed = Utils.generate(1000);
        state = State.SHOOT;
        createTextures();
        Texture t = fetchTexture();
        setPosition(Driver.width/2, Driver.height/2);
//        setPosition(Utils.generate(Driver.width), Utils.generate(Driver.height));
        setSize(t.getWidth(), t.getHeight());
        setTexture(t);
        bullets = new ArrayList<Bullet>();
        int numberBullets = 10;
        for (int i = 0; i < numberBullets; i++) {
            bullets.add(new Bullet(new Vector2(getX(), getY()), shootDirection.rotate(Utils.generate(360))));
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

    private void createTextures(){
        textures = new ArrayList<Texture>();
        for (int i = 0; i < 8; i++) {
            textures.add(new Texture("shooter"+i+".png"));
        }
    }

    private void fire(float delta){
        timer+=delta;
        if (timer>shootDelay){
            timer = 0;
            bullets.add(new Bullet(new Vector2(getX(), getY()), shootDirection.rotate(delta*rotateSpeed)));
        }
    }


    private Texture fetchTexture(){
        Texture t = textures.get(Utils.generate(textures.size()));
        return t;
    }
}
