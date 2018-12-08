package rpgTeam.rpg.states;
import java.awt.Graphics;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import rpgTeam.rpg.general.Game;
import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.gfx.Assets;
/**
 * Menu's state.
 * @author RPG Team
 *
 */
public class MenuState extends State
{
	/** Default button's size. */
	private static int DEFAULT_BUTTON_WIDTH =Game.width-(Game.width/2);
	private static int DEFAULT_BUTTON_HEIGHT =Game.height-50;
	/** Button's position.
	 * The buttons position will go around the middle of the screen */
	private static int x=Game.width/4;
	private static int y=0;
	private static int width=MenuState.DEFAULT_BUTTON_WIDTH;
	private static int height=MenuState.DEFAULT_BUTTON_HEIGHT;
	/**
	 * Coordinates of button. 
	 * @param handler
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public MenuState(Handler handler, int x, int y, int width, int height) {
		super(handler);
		MenuState.x=x;
		MenuState.y=y;
		MenuState.width=width;
		MenuState.height=height;
		
	}

	/** Update menu state. */
	public void update() 
	{
		
		if (State.getState()==handler.getGame().menuState)
		{
			if (State.gamemusic!=null)
			{
				gamemusic.close();
			}
			
		}
		
		
		if(handler.getKeyManager().space)
		{
			try {
				State.setState(handler.getGame().gameState);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(handler.getKeyManager().esc)
		{
			System.exit(0);
		}
		
		if(handler.getKeyManager().p)
		{
			try 
			{
				State.setState(handler.getGame().tutorialState);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(handler.getKeyManager().m)
		{
			handler.getGame().getClip().close();
		}
		
		
	}

	/** REnder menu state. */
	public void render(Graphics g) 
	{
		g.drawImage(Assets.buttonv2, x, y, width, height, null); // draw the buttons
		
	}
	
	
	
	
	/** Getters. */

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}


	public static int getWidth() {
		return width;
	}


	public static int getHeight() {
		return height;
	}


	
}
