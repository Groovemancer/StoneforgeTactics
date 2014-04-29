package com.pixelatedgravity.stoneforgetactics.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class World {
	
	private final static String testMap = "maps/testmap01.tmx"; // Located in the android project's assets folder
	
	private TiledMap map;
	private List<Entity> entities;
	
	public World() {
		this(testMap);
		createTestMap();
	}
	
	public World(String mapFile) {
		map = loadMap(mapFile);
		entities = new ArrayList<Entity>();
	}
	
	public void createTestMap() {		
		Entity knight = new Entity(new Texture(Gdx.files.internal("sprites/knight.png")), 2.75f, 3f);
		addEntity(knight);
	}

	private TiledMap loadMap(String mapFile) {
		return new TmxMapLoader().load(mapFile);
	}
	
	public TiledMap getMap() {
		return map;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	public void keyDown(int keycode) {
		
	}
	
	public void keyUp(int keycode) {
		
		if (keycode == Keys.RIGHT) {
			for (Entity e : entities) {
				e.position.x += 1;
			}
		}
		if (keycode == Keys.LEFT) {
			for (Entity e : entities) {
				e.position.x -= 1;
			}
		}
		if (keycode == Keys.UP) {
			for (Entity e : entities) {
				e.position.y += 1;
			}
		}
		if (keycode == Keys.DOWN) {
			for (Entity e : entities) {
				e.position.y -= 1;
			}
		}
	}
	
	public void addEntity(Entity e) {
		e.init(this);
	}
	
	public void dispose() {
		map.dispose();
		
		for (Entity e : entities) {
			e.dispose();
		}
	}

}
