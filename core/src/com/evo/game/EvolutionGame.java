package com.evo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;


public class EvolutionGame extends ApplicationAdapter {

	SpriteBatch batch;
	Stage game, menu, pause, mine1, mine2, mine3;
	String scene = "menu";
	//ImageButton startGameButton, continueGameButton, exitGameButton, continuePauseButton, exitPauseButton;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		game = new Stage();
		menu = new Stage();
		pause = new Stage();
		mine1 = new Stage();
		mine2 = new Stage();
		mine3 = new Stage();
		Gdx.input.setInputProcessor(menu);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
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
