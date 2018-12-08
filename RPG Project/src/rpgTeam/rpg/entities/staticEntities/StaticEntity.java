package rpgTeam.rpg.entities.staticEntities;

import rpgTeam.rpg.entities.Entity;
import rpgTeam.rpg.general.Handler;

/**
 * Static entity.
 * It doesn't move.
 * @author RPG Team
 *
 */
public abstract class StaticEntity extends Entity
{
	/**
	 * Static entity's constructor.
	 * @param handler
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public StaticEntity(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x,y,width,height);
		
	}
}
