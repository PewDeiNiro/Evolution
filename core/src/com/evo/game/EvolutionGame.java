package com.evo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class EvolutionGame extends ApplicationAdapter {

	SpriteBatch batch;
	Stage game, menu, pause;
	String scene = "menu";
	
	@Override
	public void create () {
		Gdx.graphics.setDisplayMode(1280, 720, true);
		batch = new SpriteBatch();
		game = new Stage();
		menu = new Stage();
		pause = new Stage();
		Gdx.input.setInputProcessor(menu);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (scene.equals("menu")){
			Gdx.input.setInputProcessor(menu);
			menu.act();
			for (Actor actor : menu.getActors()){
				actor.draw(batch, 1.0f);
			}
		}
		else if (scene.equals("pause")){
			Gdx.input.setInputProcessor(pause);
			pause.act();
			for (Actor actor : menu.getActors()){
				actor.draw(batch, 1.0f);
			}
		}
		else if (scene.equals("game")){
			Gdx.input.setInputProcessor(game);
			game.act();
			for (Actor actor : menu.getActors()){
				actor.draw(batch, 1.0f);
			}
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		game.dispose();
		pause.dispose();
		menu.dispose();
	}
}
