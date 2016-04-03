package com.gemquest.game.entities;

import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.math.Rectangle;
import com.heat.engine.math.Vector;

/**
 * Entity is the parent class for every moving and static object on screen, sort of.. <br>
 * 
 * @author Pontus Wirsching
 * @since 2016-04-02
 *
 */
public abstract class Entity {

	/**
	 * The entity position and dimension, all measured in pixels. NOT in tiles! <br>
	 */
	public Rectangle bounds;
	
	/**
	 * Velocity, measured in pixels per second.
	 */
	public Vector velocity;
	
	/**
	 * Entity public ID. Used for identification (duh..)
	 */
	public String eID = "undefined";
	
	public Entity(float x, float y, float width, float height) {
		bounds = new Rectangle(x, y, width, height);
		velocity = new Vector();
	}
	
	public Entity() {
		bounds = new Rectangle();
		velocity = new Vector();
	}

	public abstract void draw(Camera camera);
	
}
