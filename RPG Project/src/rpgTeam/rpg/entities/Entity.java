package rpgTeam.rpg.entities;
import java.awt.Graphics;
import java.awt.Rectangle;

import rpgTeam.rpg.general.Handler;
/**
 * Abstract class for an entity.
 * An entity will be anything that isn't a tile.
 * @author RPG Team
 *
 *
 */
public abstract class Entity // We need to specify a type of entity
{
	/** Object handler. */
	protected Handler handler;
	/** Entity's position. */
	protected float x,y;
	/** Entity's size. */
	protected int width, height;
	/** Rectangle for collisions. */
	protected Rectangle bounds;
	/**
	 * Constructor of an entity.
	 * @param handler
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Entity(Handler handler, float x, float y, int width, int height)
	{
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0,0,width,height); // The bounds will be the same as the actual entity
		
	}
	/** Update entities. */
	public abstract void update(); 

	/** Render themselves to the screen. */
	public abstract void render(Graphics g);

	/**
	 * Entity collision.
	 * @param xOffset
	 * @param yOffset
	 * @return boolean
	 */
	public boolean checkEntityCollision(float xOffset, float yOffset)
	{
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) // For every entities
		{
			if(e.equals(this)) // Not calculate itself
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset)))
				return true;
		}
		return false;
			
	}
	
	/** Get collision with bounds. */
	public Rectangle getCollisionBounds(float xOffset, float yOffset)
	{
		return new Rectangle((int) (x+bounds.x + xOffset), (int) (y+bounds.y + yOffset), bounds.width, bounds.height); // Covers the area of the entity
		
		
	}
	
	
	/** Getters and setters. */
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
