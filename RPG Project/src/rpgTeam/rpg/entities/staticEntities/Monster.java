package rpgTeam.rpg.entities.staticEntities;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.utils.Sound;
/**
 * Monsters.
 * A Monster is a static entity it won't move.
 * @author RPG Team
 *
 */
public class Monster extends StaticEntity{
	/** Monsters health. */
	private int hp=4;

	/** Apparences of monster. */
	private BufferedImage monster;
	/** Monster's id. */
	public final int id;
	/** Monster's state. */
	public boolean death=false;
	/**
	 * Monster's constructor.
	 * @param handler
	 * @param x
	 * @param y
	 * @param id
	 * @param monster
	 */
	public Monster(Handler handler, float x, float y, int id, BufferedImage monster) // Different monsters can be created with different images
	{
		super(handler, x, y, 113, 150);//113 150
		this.monster=monster;
		this.id=id;
	
		bounds.x = 5; // We parameter where we want our bounds to be from the monster
		bounds.y = -10;
		bounds.width = 90;
		bounds.height = 150;
	}
	

	/** Monster's update. */
	public void update()
	{
		if (death==false)
		{
			if(handler.getWorld().getEntityManager().getEntities().contains(this))
			{
				if (this.getXposition() -90< handler.getWorld().getEntityManager().getPlayer().getX() && handler.getWorld().getEntityManager().getPlayer().getX() < this.getXposition() +130) // Check x axe
				{
					if (this.getYposition() -70 < handler.getWorld().getEntityManager().getPlayer().getY() && handler.getWorld().getEntityManager().getPlayer().getY() < this.getYposition() +150) // Check y axe
					{
						if(handler.getKeyManager().enter)
						{
							hp = hp-1;
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							if(hp==0) {
								death=true;
								Sound.loadMusic("res/song/PacMan Dying Sound Effect.wav");
							}
						}
					}
				}
			}
		
		}
	}
	


	/**
	 * Monster's render.
	 * THe monster can draw itself tot he screen.
	 */
	public void render(Graphics g)
	{
		if (death!= false) {
			bounds.x = 0; // We delete the hitbox when monster disapear
			bounds.y = 0;
			bounds.width = 0;
			bounds.height = 0;
			return;
		}
		g.drawImage(monster, (int)(x- handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);		
	}
	
	
	/** Getters. */
	/** Get monster's health. */
	public int getHp() {
		return hp;
	}
	
	
	
	public void setHp(int hp) {
		this.hp = hp;
	}


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
