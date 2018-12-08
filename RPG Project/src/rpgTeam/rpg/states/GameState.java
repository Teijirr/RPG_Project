package rpgTeam.rpg.states;
import java.awt.Graphics;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import rpgTeam.rpg.entities.creatures.Player;
import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.general.World;
/**
 * Actual game.
 * Separate this and menus. 
 * @author RPG Team
 *
 */
public class GameState extends State
{
	/** World for the game. */
	private World world;
	/** Inventory's state. */
	public static boolean InventoryisOpened=false;;
	/** Constructor GameState.
	 * 
	 * @param handler
	 */
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);

		
		
		
//		Invent = new Inventory(handler);
		
		
		
	}
	/** Update gamestate. */
	public void update() 
	{
		world.update();
			
		if(handler.getKeyManager().esc)
		{
			try 
			{
				State.setState(handler.getGame().menuState);
				Thread.sleep(500); // Wait a bit so that it doesn't exit game
			} 
			catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(handler.getKeyManager().m) // Mute the music ingame
		{
			if (State.gamemusic!=null)
			{
				gamemusic.close();
			}
		}
		
		if(handler.getKeyManager().i) // Open the inventory
		{
				InventoryisOpened = true;
				Player.playerCantMove=true;
		}
		
		if(handler.getKeyManager().j) // Close the inventory
		{
				InventoryisOpened = false;
				Player.playerCantMove=false;
				

				
		}
		
		
		
	}

	/** Render the game. */
	public void render(Graphics g) 
	{
		//Tile rendering is done in the world class
		
		world.render(g);
		
//		if (InventoryisOpened==true)
//		{
//			Invent.render(g);
//		}
//		else
//			return;
		
	}
	
}
