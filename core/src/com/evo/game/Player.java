package com.evo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

public class Player extends Actor {

    private Texture left, right, up, down;
    private float x, y;
    private Side side;
    private final int SPEED = 3;
    private ArrayList<Item> inventory;
    private boolean isInventoryOpened = false;

    public Player (Texture left, Texture right, Texture up, Texture down, int x, int y){
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.x = x;
        this.y = y;
        side = Side.RIGHT;
    }

    public void setInventory(ArrayList<Item> inventory){
        this.inventory = inventory;
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public void addItem(Item item){
        inventory.add(item);
    }

    @Override
    public void act(float delta){
        keyBoardControl();
    }

    public void keyBoardControl(){
        if (!isInventoryOpened) {
            if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
                setLocation(x, y + SPEED);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                setLocation(x, y - SPEED);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                setLocation(x - SPEED, y);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                setLocation(x + SPEED, y);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.E)){
                isInventoryOpened = true;
            }
        }
        else{
            if (Gdx.input.isKeyPressed(Input.Keys.E)){
                isInventoryOpened = false;
            }
        }
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    private Texture getTexture(){
        if (side.equals(Side.DOWN)){
            return down;
        }
        else if (side.equals(Side.UP)){
            return up;
        }
        else if (side.equals(Side.LEFT)){
            return left;
        }
        else{
            return right;
        }
    }

    public void setSide(Side side){
        this.side = side;
    }

    public void setLocation(float x, float y){
        if (this.x > x){
            setSide(Side.LEFT);
        }
        else if (this.x < x){
            setSide(Side.RIGHT);
        }
        if (this.y > y){
            setSide(Side.DOWN);
        }
        else if (this.y < y){
            setSide(Side.UP);
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Batch batch, float parentAlfa){
        batch.draw(getTexture(), getX(), getY());
        if (isInventoryOpened){
            for (int i = 0; i < inventory.size(); i++){
                Item item = inventory.get(i);
                batch.draw(item.getTexture(), item.getX(), item.getY());
            }
        }
    }

}
