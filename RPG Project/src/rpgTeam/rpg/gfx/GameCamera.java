package rpgTeam.rpg.gfx;
import rpgTeam.rpg.entities.Entity;
import rpgTeam.rpg.general.Game;

/**
 * Camera for game.
 * @author RPG Team.
 *
 */
public class GameCamera 
{	
	/** Camera's position. */
	private float xOffset, yOffset; // in pixels, will move the tiles from the offsets
	/**
	 * Constructor of GameCamera.
	 * @param game
	 * @param xOffset
	 * @param yOffset
	 */
	public GameCamera(Game game, float xOffset, float yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	/**
	 * Center the camera.
	 * @param entity
	 */
	public void centerOnEntity(Entity e) // So the camera is centered on an entity
	{
		xOffset = e.getX() - Game.width/2 + e.getWidth()/2;
		yOffset = e.getY() - Game.height/2 + e.getHeight()/2;
	}
	/** Move Camera. */
	public void move(Game game, float xAmount, float yAmount)
	{
		xOffset = xOffset + xAmount;
		yOffset = yOffset + yAmount;
	}
	
	/** Getters and setters. */
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}


}
