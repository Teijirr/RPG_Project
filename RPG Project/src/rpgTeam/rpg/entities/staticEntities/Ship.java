package rpgTeam.rpg.entities.staticEntities;
import java.awt.Graphics;

import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.gfx.Assets;
import rpgTeam.rpg.tiles.Tile;
/** Ship on the world.
 * 
 * @author RPG Team.
 *
 */
public class Ship extends StaticEntity 
{
	/** Ship's constructor. */
	public Ship(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*10,  Tile.TILEHEIGHT*8);
		
		
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Tile.TILEWIDTH;
		bounds.height = Tile.TILEHEIGHT;
	}

	@Override
	public void update() {
		
		
	}
	/** Ship's render. */
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.ship, (int)(x- handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);
	}
	


}
