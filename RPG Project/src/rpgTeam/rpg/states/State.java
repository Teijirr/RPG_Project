package rpgTeam.rpg.states;
import java.awt.Graphics;
import java.io.IOException;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.utils.Sound;
/**
 * Game's and menu's state. 
 * @author RPG Team
 *
 */
public abstract class State
{
	/** Current sate. */
	private static State currentState = null;
	/** GAme's music. */
	public static Clip gamemusic=null;
	
	/**
	 * Set state.
	 * @param state
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * @throws LineUnavailableException
	 */
	public static void setState(State state) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		
		currentState = state;
		
		if (State.getState()==handler.getGame().gameState)
		{
			handler.getGame().getClip().close(); // Stop the old clip, because the menuState is launched before the gameState
			gamemusic = Sound.loadMusic("res/song/Eli Way - Wave.wav"); // Launch this song at the beginning of gameState	
		}


	}
	/** Get the state. */
	public static State getState()
	{
		return currentState; // return the current state
	}

	
	
	/** State need handler. */
	protected static Handler handler;
	/** State constructor. */
	public State(Handler handler)
	{
		State.handler = handler;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}
