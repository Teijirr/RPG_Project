package rpgTeam.rpg.entities.staticEntities;
import java.awt.Graphics;

import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.gfx.Assets;
import rpgTeam.rpg.tiles.Tile;
/**
 * Tree on the world. 
 * The tree is a static entity.
 * @author RPG Team
 *
 */
public class Tree extends StaticEntity {
	/** Tree's constructor.
	 * 
	 * @param handler
	 * @param x
	 * @param y
	 */
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*4,  Tile.TILEHEIGHT*5);
		
		
		// Bounds box of the tree -- experimental
		bounds.x = 65;
		bounds.y = 30;
		bounds.width = Tile.TILEWIDTH*2;
		bounds.height = Tile.TILEHEIGHT*2+30;
	}

	@Override
	public void update() {
		
		
	}
	/** Tree's render. */
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.tree, (int)(x- handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);
	}
	


}
