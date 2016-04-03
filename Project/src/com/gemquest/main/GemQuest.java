package com.gemquest.main;

import com.gemquest.game.MainGame;
import com.heat.engine.game.Game;
import com.heat.engine.graphics.screen.ScreenManager;

public class GemQuest extends Game {

	
	public MainGame game;
	
	
	public GemQuest() {
		super(Settings.WIDTH, Settings.HEIGHT, Settings.TITLE);
		
		enableDebugging(DEBUG_ALL);
		
		
		ScreenManager.add(game = new MainGame());
		
		ScreenManager.setSelcted("GAME");
		
		start();
	}

	@Override
	public void draw() {
		
		ScreenManager.render(getDelta());
		
	}

}
