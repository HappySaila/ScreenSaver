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
    ArrayList<Texture> textures;
    enum State{
        SHOOT, MOVE;
    }

    public Shooter(){
        super(new Texture("shooter0.png"));
        State state = State.SHOOT;
        createTextures();
        Texture t = fetchTexture();
        setPosition(Utils.generate(Driver.width), Utils.generate(Driver.height));
        setSize(t.getWidth(), t.getHeight());
        setTexture(t);
    }

    public void render(SpriteBatch sb, float delta){
        update(delta);
        draw(sb);
    }

    private void update(float delta){
    }

    private void createTextures(){
        textures = new ArrayList<Texture>();
        for (int i = 0; i < 8; i++) {
            textures.add(new Texture("shooter"+i+".png"));
        }
    }

    private void fire(){

    }


    private Texture fetchTexture(){
        Texture t = textures.get(Utils.generate(textures.size()));
        return t;
    }

}
