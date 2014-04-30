package com.pixelatedgravity.stoneforgetactics.model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.pixelatedgravity.stoneforgetactics.view.WorldRenderer;

public class Entity {
	
	protected Vector2 position;
	protected Texture texture;
	
	public Entity(Texture texture, float x, float y) {
		this.texture = texture;
		this.position = new Vector2(x, y);
	}
	
	public void init(World world) {
		world.getEntities().add(this);
	}

	public void render(SpriteBatch spriteBatch, Camera camera, float delta) {
		spriteBatch.draw(texture,
				(position.x - camera.position.x + (WorldRenderer.CAMERA_WIDTH / 2f)) * WorldRenderer.ppuX,
				(position.y - camera.position.y + (WorldRenderer.CAMERA_HEIGHT / 2f)) * WorldRenderer.ppuY,
				texture.getWidth() * WorldRenderer.ppuX / WorldRenderer.UNIT_SIZE, texture.getHeight() * WorldRenderer.ppuY / WorldRenderer.UNIT_SIZE);
	}

	public void dispose() {
		texture.dispose();
	}

}
