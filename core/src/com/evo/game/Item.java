package com.evo.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Item{

    private Texture texture;
    private float x, y;
    private boolean isEmpty;

    public Item(Texture texture, float x, float y, boolean isEmpty){
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.isEmpty = isEmpty;
    }


    public void act(float delta){

    }

    public void draw(Batch batch){
        batch.draw(texture, x, y);
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public Texture getTexture(){
        return texture;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

}
