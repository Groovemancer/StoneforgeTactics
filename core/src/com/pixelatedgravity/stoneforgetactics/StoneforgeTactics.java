package com.pixelatedgravity.stoneforgetactics;

import com.badlogic.gdx.Game;
import com.pixelatedgravity.stoneforgetactics.screens.GameScreen;

public class StoneforgeTactics extends Game {
	
	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
