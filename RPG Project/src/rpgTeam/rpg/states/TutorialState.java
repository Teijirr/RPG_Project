package rpgTeam.rpg.states;
import java.awt.Graphics;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import rpgTeam.rpg.general.Game;
import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.gfx.Assets;
/** Tutorial state.
 * 
 * @author RPG Team
 *
 */
public class TutorialState  extends State
{
	/** Tutorial state's position and size. */
	private static int x=150;
	private static int y=0;
	private static int width=Game.width-300;
	private static int height=Game.height;
	/** Tutorial state's constructor.
	 * 
	 * @param handler
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public TutorialState(Handler handler, int x, int y, int width, int height) 
	{
		super(handler);
		TutorialState.x=x;
		TutorialState.y=y;
		TutorialState.width=width;
		TutorialState.height=height;
	}
	/** Tutorial state's update. */
	@Override
	public void update() 
	{
		if(handler.getKeyManager().esc)
		{
			try 
			{
				State.setState(handler.getGame().menuState);
				Thread.sleep(500);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(handler.getKeyManager().m)
		{
			handler.getGame().getClip().close();
		}
	}
	/** Tutorial state's render. */
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.tutov2, x, y, width, height, null);
		
	}
	
	/** Getters. */

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

}
