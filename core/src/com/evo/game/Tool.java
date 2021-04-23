package com.evo.game;

import com.badlogic.gdx.graphics.Texture;

public class Tool extends Item{

    private Texture texture;
    private float x, y;
    private Tools type;

    public Tool(Texture texture, float x, float y, Tools type){
        super(texture, x, y, false);
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.type = type;
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

}
