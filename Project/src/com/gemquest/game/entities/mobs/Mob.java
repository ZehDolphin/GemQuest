package com.gemquest.game.entities.mobs;

import com.gemquest.game.MainGame;
import com.gemquest.game.entities.Entity;
import com.gemquest.main.Settings;
import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.math.Point;

public abstract class Mob extends Entity {

	public Point tilePosition;
	
	protected float health = 100;
	protected float damage = 10;
	
	/**
	 * pixels per second.
	 */
	public float speed = 50;
	
	public Mob(int tileX, int tileY) {
		super();
		tilePosition = new Point(tileX, tileY);
	}

	@Override
	public abstract void draw(Camera camera);

	/**
	 * Returns the tile on the collision layer ID relative to the mob.
	 * @return
	 */
	public int getCollisionTile(int x, int y) {
		if ((tilePosition.x + x) < 0 || (tilePosition.y + y) < 0 || (tilePosition.x + x) >= MainGame.currentMap.getLayer(Settings.COLLISION_LAYER_NAME).getWidth() || (tilePosition.y + y) >= MainGame.currentMap.getLayer(Settings.COLLISION_LAYER_NAME).getHeight()) return 24;
		return MainGame.currentMap.getLayer(Settings.COLLISION_LAYER_NAME).getData()[(int) ((tilePosition.x + x) + (tilePosition.y + y) * MainGame.currentMap.getWidth())];
	}
	

}
