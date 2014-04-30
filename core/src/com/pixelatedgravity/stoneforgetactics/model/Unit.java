package com.pixelatedgravity.stoneforgetactics.model;

import com.badlogic.gdx.graphics.Texture;

public class Unit extends Entity {

	public String name;
	public int id;
	public int maxHealth;
	public int health;
	public int maxActionPoints;
	public int actionPoints;
	public int speed;
	public int attack;
	public int magic;
	public int armor;
	public int resistance;
	public int accuracy;
	
	public Unit(Texture texture, float x, float y) {
		super(texture, x, y);
	}
}
