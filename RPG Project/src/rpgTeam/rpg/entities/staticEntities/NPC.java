package rpgTeam.rpg.entities.staticEntities;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rpgTeam.rpg.entities.creatures.Creature;
import rpgTeam.rpg.general.Dialog;
import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.tiles.Tile;
/**
 * NPC.
 * A npc is a staticentity it won't move.
 * @author RPG Team.
 *
 */
public class NPC extends StaticEntity 
{
	/** NPC's skin. */
	private BufferedImage npc;
	/** NPC's id. */
	public final int id;
	/** NPC's state. */
	public static boolean isTalking = false;
	
	/**
	 * NPC's constructor.
	 * Different NPC can be created with different images. 
	 * @param handler
	 * @param x
	 * @param y
	 * @param id
	 * @param npc
	 */
	public NPC(Handler handler, float x, float y, int id, BufferedImage npc) // Different npc can be created with different images
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.npc=npc;
		this.id=id;
	
		bounds.x = 0; // We parameter where we want our bounds to be from the npc
		bounds.y = 0;
		bounds.width = 50;
		bounds.height = 50;
	}
	

	/** NPC's update. */
	public void update()  
	{
		if(handler.getWorld().getEntityManager().getEntities().contains(this))
		{
			if (this.getXposition() -Tile.TILEWIDTH < handler.getWorld().getEntityManager().getPlayer().getX() && handler.getWorld().getEntityManager().getPlayer().getX() < this.getXposition() +70) // Check x axe
			{
				if (this.getYposition() -Tile.TILEWIDTH < handler.getWorld().getEntityManager().getPlayer().getY() && handler.getWorld().getEntityManager().getPlayer().getY() < this.getYposition() +70) // Check y axe
				{
					if(handler.getKeyManager().enter)
					{
						isTalking=true;	
					}
				}
			}
		}
		
		
	}
	

	
	/** NPC's render. */
	public void render(Graphics g)  
	{
		g.drawImage(npc, (int)(x- handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);
		if (NPC.isTalking==true)
		{
			Dialog dialog = new Dialog(handler, this);
			dialog.render(g);
			return;
		}
	}
	
	
	/** Getters. */
	public int getXposition()
	{
		return (int)(x);
	}
	
	public int getYposition()
	{
		return (int)(y);
	}
	
	public int getId() {
		return id;
	}
	
}
