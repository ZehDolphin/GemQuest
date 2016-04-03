package com.gemquest.game.entities.mobs;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.gemquest.game.MainGame;
import com.gemquest.main.Settings;
import com.heat.engine.Engine;
import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.input.Keyboard;
import com.heat.engine.math.Rectangle;

public class Player extends Mob {

	public Player(int tileX, int tileY) {
		super(tileX, tileY);
		bounds = new Rectangle(0, 0, 16, 16);
	}

	@Override
	public void draw(Camera camera) {
		camera.setColor(Color.RED);
		camera.fillRect(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());

		if (Keyboard.isKeyPressed(KeyEvent.VK_SHIFT)) {
			speed = 200;
		} else {
			speed = 50;
		}

		boolean isWalking = false;

		if (bounds.getX() < tilePosition.x * Settings.TILE_SIZE) {
			isWalking = true;
			bounds.setX(bounds.getX() + speed * Engine.getDelta());
		}
		if (bounds.getY() < tilePosition.y * Settings.TILE_SIZE) {
			isWalking = true;
			bounds.setY(bounds.getY() + speed * Engine.getDelta());
		}
		if (bounds.getX() > tilePosition.x * Settings.TILE_SIZE) {
			isWalking = true;
			bounds.setX(bounds.getX() - speed * Engine.getDelta());
		}
		if (bounds.getY() > tilePosition.y * Settings.TILE_SIZE) {
			isWalking = true;
			bounds.setY(bounds.getY() - speed * Engine.getDelta());
		}

		float xDist = Math.abs(bounds.getX() - tilePosition.x * Settings.TILE_SIZE);
		float yDist = Math.abs(bounds.getY() - tilePosition.y * Settings.TILE_SIZE);

		if (xDist <= 1)
			bounds.setX(tilePosition.x * Settings.TILE_SIZE);
		if (yDist <= 1)
			bounds.setY(tilePosition.y * Settings.TILE_SIZE);

		if (Keyboard.isKeyPressed(KeyEvent.VK_W) && yDist <= 1) {
			int t = getCollisionTile(0, -1);
			if (t != 24 && t != 8) {
				tilePosition.y--;
				isWalking = true;
			}

		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_A) && xDist <= 1) {
			int t = getCollisionTile(-1, 0);
			if (t != 24 && t != 23) {
				tilePosition.x--;
				isWalking = true;
			}
		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_S) && yDist <= 1) {
			int t = getCollisionTile(0, 1);
			if (t != 24 && t != 40) {
				tilePosition.y++;
				isWalking = true;
			}
		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_D) && xDist <= 1) {

			int t = getCollisionTile(1, 0);
			if (t != 24 && t != 25) {
				tilePosition.x++;
				isWalking = true;
			}
			
		}
		
		//System.out.println(getCollisionTile(0, 0));

		camera.setColor(Color.GREEN);
		camera.drawRect(tilePosition.x * Settings.TILE_SIZE, tilePosition.y * Settings.TILE_SIZE, bounds.getWidth(), bounds.getHeight());

	}

}
