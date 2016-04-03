package com.gemquest.game;

import java.awt.Color;

import com.gemquest.game.entities.mobs.Player;
import com.gemquest.main.Settings;
import com.heat.engine.Engine;
import com.heat.engine.graphics.Graphics;
import com.heat.engine.graphics.camera.PerspectiveCamera;
import com.heat.engine.graphics.image.DynamicRenderObject;
import com.heat.engine.graphics.screen.Screen;
import com.heat.engine.graphics.windowEvents.ResizeListener;
import com.heat.engine.input.Mouse;
import com.heat.engine.math.Math;
import com.heat.tiled.Parser;
import com.heat.tiled.graphics.MapRenderer;
import com.heat.tiled.map.Map;

public class MainGame extends Screen {

	public PerspectiveCamera camera;
	
	public static Map currentMap;
	
	public MapRenderer renderer;
	
	public Player player;
	
	public MainGame() {
		super("GAME");
		
		camera = new PerspectiveCamera(Settings.CAMERA_WIDTH, Settings.CAMERA_HEIGHT);

		Engine.getWindow().setResizeListener(new ResizeListener() {
			
			@Override
			public void resize(float w, float h) {
				camera.adaptTo(Settings.CAMERA_WIDTH, Settings.CAMERA_HEIGHT);
			}
			
		});
		
		Mouse.fit(camera);
		
		currentMap = Parser.parse("level1.json");
		
		renderer = new MapRenderer(currentMap);
		
		renderer.loadLayer(tiles, 0);
		
		player = new Player(2, 2);
		
	}

	public DynamicRenderObject tiles = new DynamicRenderObject();
	
	@Override
	public void draw(float delta) {

		float tx = (16 * 12) / 2 - 8 + (int)(player.tilePosition.x / 12) * (16 * 12); // Camera target x
		float ty = (16 * 12) / 2 - 8 + (int)(player.tilePosition.y / 12) * (16 * 12); // Camera target y
		
		// Camera "movement speed/smoothing"
		float smoothing = 5;
		
		float angle = Math.getAngle(camera.x, camera.y, tx, ty);	// Angle from camera to target position.
		float distance = Math.getDistance(camera.x, camera.y, tx, ty); // Distance between camera and target position.
		
		// Move the camera using the variables above..
		camera.x += Math.cos(angle) * distance * smoothing * Engine.getDelta();
		camera.y += Math.sin(angle) * distance * smoothing * Engine.getDelta();
		
		int w = (int) (12*16/camera.pixelWidth);
		Engine.getRenderer().getGraphics().setClip(Engine.getWidth() / 2 - w / 2, Engine.getHeight() / 2 - w/ 2, w, w);
		
		
		camera.drawImage(tiles.image, tiles.width / 2 - currentMap.getTileWidth() / 2, tiles.height / 2 - currentMap.getTileHeight() / 2, tiles.image.getWidth(), tiles.image.getHeight());
//		renderer.drawLayer(0, camera);
		
//		renderer.drawLayer(1, camera);
		
		player.draw(camera);
		
		Engine.getRenderer().getGraphics().setClip(0, 0, Engine.getWidth(), Engine.getHeight());
		
		
		
	}

	@Override
	public void resize(float w, float h) {
		
	}

}
