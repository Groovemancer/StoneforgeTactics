package com.pixelatedgravity.stoneforgetactics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.pixelatedgravity.stoneforgetactics.model.World;
import com.pixelatedgravity.stoneforgetactics.view.WorldRenderer;

public class GameScreen implements Screen, InputProcessor {
	
	private WorldRenderer renderer;
	private World world;

	@Override
	public void show() {
		world = new World();
		renderer = new WorldRenderer(world);
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderer.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		renderer.setSize(width, height);
	}

	@Override
	public void hide() {
		renderer.dispose();
		world.dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		renderer.dispose();
		world.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		world.keyDown(keycode);
		if (keycode == Keys.ESCAPE) {
			Gdx.app.exit();
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		world.keyUp(keycode);
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
