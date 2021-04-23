package com.evo.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Block extends Actor {

    private Texture texture;
    private float x, y;
    private Breakable breakable;

    public Block(Texture texture, float x, float y, Breakable breakable){
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.breakable = breakable;
    }

    public Texture getTexture() {
        return texture;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, x, y);
    }

}
