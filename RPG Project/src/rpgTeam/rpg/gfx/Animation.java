package rpgTeam.rpg.gfx;
import java.awt.image.BufferedImage;
/**
 * Animation of entities.
 * @author RPG Team
 *
 */
public class Animation 
{
	/** Animation's speed. */
	private int speed, index;
	/** Time since the start. */
	private long lastTime, timer;
	private BufferedImage[] frames;
	/**
	 * Constructor of the animation.
	 * @param speed
	 * @param frames
	 */
	public Animation(int speed, BufferedImage[] frames)
	{
		this.speed = speed; // in milliseconds, specific below
		this.frames = frames;
		index=0;
		timer=0;
		lastTime=System.currentTimeMillis(); // Get the time that has past since the start
	}
	/**
	 * Update image every second.
	 */
	public void tick()
	{
		timer = timer + System.currentTimeMillis() - lastTime; // Time that has passed between tick methods
		lastTime=System.currentTimeMillis();
		
		if(timer>speed)
		{
			index++;
			timer=0;
			if(index>=frames.length) // prevent errors
			{
				index=0;
			}
		}
	}
	/**
	 * Get actual frame.
	 * @return frames
	 */
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
}
