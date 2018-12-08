package rpgTeam.rpg.entities.creatures;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.gfx.Animation;
import rpgTeam.rpg.gfx.Assets;
import rpgTeam.rpg.inventory.Inventory;
/** 
 * Game's player.
 * @author RPG Team
 *
 */
public class Player extends Creature 
{
	/** Player's skin. */
	private BufferedImage player = Assets.player;
	/** Player's move state. */
	public static boolean playerCantMove=false;
	
	/** Player's animation. */
	private Animation animdown;
	private Animation animup;
	private Animation animleft;
	private Animation animright;
	
	/** Player's inventory. */
	private Inventory inventory;
	/**
	 * Player's constructor. 
	 * @param handler
	 * @param x
	 * @param y
	 */
	public Player(Handler handler, float x, float y) 
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		bounds.x = 0; // We parameter where we want our bounds to be from the player
		bounds.y = 0;
		bounds.width = 50;
		bounds.height = 50;
		
		// Animations
		animdown = new Animation(500, Assets.player_down); //500ms
		animup = new Animation(500, Assets.player_up);
		animleft = new Animation(500, Assets.player_left);
		animright = new Animation(500, Assets.player_right);
		
		// Here we initialize the inventory
		inventory = new Inventory(handler);
	}
	
	/** Player's update. */
	public void update() 
	{
			animdown.tick();
			animup.tick();
			animleft.tick();
			animright.tick();
			
			getInput();
			move();
			handler.getGameCamera().centerOnEntity(this); // We want to center this entity
			
			inventory.update();
	}
	
	/** Manage all the input. */
	protected void getInput() 
	{
		if (playerCantMove == false) // Checking if player is not talking
		{
			xMove=0; // So that it always wait that we push a new key
			yMove=0;
			
			if(handler.getKeyManager().up)
			{
					yMove = -displacement; // Because the y axes increases as it goes down
			}
			if(handler.getKeyManager().down)
			{
					yMove = displacement; // Because the y axes increases as it goes down

			}
			if(handler.getKeyManager().left)
			{
					xMove = -displacement; 

			}
			if(handler.getKeyManager().right)
			{
					xMove = displacement; 
			}
		}
		
	}

	/** Player's render. */
	public void render(Graphics g)  // The player can draw itself to the screen
	{
		
		// We convert x and y from float to int
		// We also tell the width and height the player will be displayed
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()) , (int)(y-handler.getGameCamera().getyOffset()), width, height, null); 
		
		inventory.render(g);
	}
	
	/** Getters. */
	public Inventory getInventory() {
		return inventory;
	}


	public BufferedImage getCurrentAnimationFrame()
	{
		if (playerCantMove == false)
		{
			if(handler.getKeyManager().up)
			{
				return animup.getCurrentFrame();
			}
			
			if(handler.getKeyManager().down)
			{
				return animdown.getCurrentFrame();
			}
			
			if(handler.getKeyManager().left)
			{
				return animleft.getCurrentFrame();
			}
			
			if(handler.getKeyManager().right)
			{
				return animright.getCurrentFrame();
			}
			else 
				return player;
		}
		else return player;
			
	}
	
	public int getXposition()
	{
		return (int)(x - handler.getGameCamera().getxOffset());
	}
	
	public int setXposition(int x)
	{
		this.x=x;
		return x;
	}
	
	public int setYposition(int y)
	{
		this.y=y;
		return y;
	}
	
	public int getYposition()
	{
		return (int)(y - handler.getGameCamera().getxOffset());
	}
	
}
