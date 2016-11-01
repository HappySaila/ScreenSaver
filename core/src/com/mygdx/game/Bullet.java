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
    boolean clockWise;
    float timer;
    float lifeTimer;
    float aliveTimer;

    public Bullet(Vector2 position, Vector2 direction, Driver game) {
        super(new Texture("bullet0.png"));
        lifeTimer = (float)Utils.generate(200, 300)/10;
        this.game = game;
        this.position = position;
        this.direction = new Vector2(direction);
        speed = Utils.generate(3,5);
        this.direction.scl(speed);
        createTextures();
        Texture t = fetchTexture();
        setTexture(t);
        float alpha = (float)Utils.generate(1,10)/10;
        if (alpha>0.6){
            alpha=1;
        }
        int i = Utils.generate(2);
        if (i==1){
            clockWise = true;
        }
        setAlpha(alpha);
        setSize(t.getWidth(), t.getHeight());
        aliveTimer = (float)Utils.generate(200)/10;
    }

    public void render(SpriteBatch sb, float delta){
        if (alive){
            update(delta);
            draw(sb);
        }else{
            timer+=delta;
            if (timer>aliveTimer){
                alive=true;
            }
        }
    }

    private void update(float delta){
        position.add(direction);
        if (clockWise){
            direction.rotate(-delta*speed);
        }else{
            direction.rotate(delta*speed);
        }
        setPosition(position.x, position.y);
        setRotation(delta*speed);
        timer+=delta;
        if (timer>lifeTimer){
            timer = 0;
            position.set(Driver.width/2, Driver.height/2);
            direction.scl(-1);
        }
        int i;
        setSize(i = (int)Math.abs(getX()-Driver.width/2)/10, i);
    }

    private void createTextures(){
        textures = new ArrayList<Texture>();
        for (int i = 0; i < 8; i++) {
            textures.add(new Texture("bullet" + i + ".png"));
        }
    }

    private Texture fetchTexture(){
        Texture t = textures.get(Utils.generate(textures.size()));
        return t;
    }
}
