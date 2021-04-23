package com.evo.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Date;

public class Sapling extends Actor {

    private Texture texture;
    private Date growStarts = new Date();
    private long growsMillis;
    private float x, y;

    public Sapling(Texture texture, long growsMillis, float x, float y){
        this.texture = texture;
        this.growsMillis = growsMillis;
        this.x = x;
        this.y = y;
    }

    public Texture getTexture(){
        return texture;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isGrows(){
        Date nowDate = new Date();
        if (nowDate.getTime() - growStarts.getTime() >= growsMillis){
            return true;
        }
        return false;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, x, y);
    }
}
