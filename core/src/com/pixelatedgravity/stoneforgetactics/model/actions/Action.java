package com.pixelatedgravity.stoneforgetactics.model.actions;

public class Action {
	
	public static final int TARGET_SELF = 1;
	public static final int TARGET_ALLY = 2;
	public static final int TARGET_ENEMY = 4;
	public static final int TARGET_GROUND = 8;
	
	public enum TargetType {
		Single, AoE, Line, Close
	}
	
	public String name;
	public int id;
	public String description;
	public int cost;
	public int cooldown;
	public int validTargets;
	public TargetType targetType;
	public int minRange;
	public int maxRange;

}
