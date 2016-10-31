package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by HappySaila on 10/31/16.
 */
public class Bullet extends Sprite {
    int speed;
    Vector2 position;
    Vector2 direction;
    boolean alive;
    ArrayList<Texture> textures;
    Driver game;

    public Bullet(Vector2 position, Vector2 direction, Driver game) {
        super(new Texture("bullet0.png"));
        this.game = game;
        this.position = position;
        this.direction = new Vector2(direction);
        speed = Utils.generate(3,14);
        createTextures();
        Texture t = fetchTexture();
        setSize(t.getWidth(), t.getHeight());
        setTexture(t);
    }

    public void render(SpriteBatch sb, float delta){
        update(delta);
        draw(sb);
    }

    private void update(float delta){
        if (position.x > Driver.width || position.y > Driver.height || position.x < 0-getX() || position.y < 0 - getY()){
            position.set(Driver.width/2, Driver.height/2);
        }
        position.add(direction.x*speed, direction.y*speed);
        setPosition(position.x, position.y);
        setRotation(delta*speed);
    }

    private void createTextures(){
        textures = new ArrayList<Texture>();
        for (int i = 0; i < 8; i++) {
            if (game.glow){
                textures.add(new Texture("shooter"+i+".png"));
            }else{
                textures.add(new Texture("bullet"+i+".png"));
            }
        }
    }

    private Texture fetchTexture(){
        Texture t = textures.get(Utils.generate(textures.size()));
        return t;
    }
}
