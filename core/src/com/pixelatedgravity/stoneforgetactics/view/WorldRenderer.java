package com.pixelatedgravity.stoneforgetactics.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.pixelatedgravity.stoneforgetactics.model.Entity;
import com.pixelatedgravity.stoneforgetactics.model.World;

public class WorldRenderer {
	
	public static final float CAMERA_WIDTH = 10f;	// The screen's width in units
	public static final float CAMERA_HEIGHT = 6f;	// The screen's height in units
	public static final float UNIT_SIZE = 128f;		// The number of pixels per unit
	
	public static float ppuX, ppuY;	// Pixels per unit on the X and Y axis
	
	@SuppressWarnings("unused")
	private int width, height;
	private SpriteBatch spriteBatch;
	
	private World world;
	private OrthographicCamera camera;
	private OrthogonalTiledMapRenderer mapRenderer;
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		ppuX = (float)width / CAMERA_WIDTH;
		ppuY = (float)height / CAMERA_HEIGHT;
		
		System.out.println("PPUX: " + ppuX + ", PPUY: " + ppuY);
	}

	public WorldRenderer(World world) {
		this.world = world;
		spriteBatch = new SpriteBatch();
		
		// Initialize the Tiled Map Renderer, passing the tiledmap retrieved from world, and setting unit size
		// Unit Size = 1 unit per 32 pixel(s) = 1 / 32
		mapRenderer = new OrthogonalTiledMapRenderer(world.getMap(), 1f / UNIT_SIZE);
		
		// Width/Height = number of units displayed in the camera, i.e. 10 units x 32 pixels
		// 6 x 32 = 320 x 192 pixels camera resolution
		this.camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
		this.camera.position.set(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2, 0);
		this.camera.update();
		
		System.out.println("Camera Combined: " + camera.position);
		
		loadTextures();
	}
	
	private void loadTextures() {		
	}

	public void render(float delta) {
		// Update camera, in case there's some changes made else where
		camera.update();
		
		// Set up camera for tiled map render, then render
		mapRenderer.setView(camera);
		mapRenderer.render();
		
		spriteBatch.begin();
			
			renderEntities(delta);
		
		spriteBatch.end();
	}
	
	public void renderEntities(float delta) {
		for (Entity e : world.getEntities()) {
			e.render(spriteBatch, camera, delta);
		}
	}
	
	public void dispose() {
		spriteBatch.dispose();
		mapRenderer.dispose();
	}
}
