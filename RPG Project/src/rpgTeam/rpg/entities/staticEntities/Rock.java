package rpgTeam.rpg.entities.staticEntities;
import java.awt.Graphics;

import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.gfx.Assets;
import rpgTeam.rpg.tiles.Tile;
/**
 * Rock.
 * Is a static entity..
 * @author RPG Team
 *
 */
public class Rock extends StaticEntity
{
	/**
	 * Rock's constructor. 
	 * @param handler
	 * @param x
	 * @param y
	 */
	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*2,  Tile.TILEHEIGHT*2);
		
		
		// Bounds box of the rock -- experimental
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Tile.TILEWIDTH*2;
		bounds.height = Tile.TILEHEIGHT*2;
	}

	@Override
	public void update() {
		
		
	}
	/** Rock's render. */
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.rock, (int)(x- handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);
	}
	


}
