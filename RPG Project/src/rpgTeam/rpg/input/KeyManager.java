package rpgTeam.rpg.input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *  Manage keyboard input. 
 *  Only way to get the key -- We implement KeyListener so we redefine all of its methods.
 * @author RPG Team
 *
 */
public class KeyManager implements KeyListener
{
	/** Key's state. */
	public boolean[] keys;
	/** Keys */
	public boolean up,down,left,right, enter, space, esc, p, m, i, j, z, s;
	/** State of enter key. */
	public boolean enterPressed;
	
	/** Key manager constructor.
	 * Keys on the keyboard have a code.*/
	public KeyManager()
	{
		keys = new boolean[256];
		
//		So that it registers just once, not many times
//		justPressed = new boolean[keys.length];
//		cantPress = new boolean[keys.length];
	}
	
	/** Update. */
	public void update()
	{		
		// Directions keys
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
		// Global keys
		enter = keys[KeyEvent.VK_ENTER];
		space = keys[KeyEvent.VK_SPACE];
		esc = keys[KeyEvent.VK_ESCAPE];
		
		// Stop interactions and music keys
		p = keys[KeyEvent.VK_P];
		m = keys[KeyEvent.VK_M];
		
		// Inventory keys
		i = keys[KeyEvent.VK_I];
		j = keys[KeyEvent.VK_J];
		
		z = keys[KeyEvent.VK_Z];
		s = keys[KeyEvent.VK_S];
	}
	/** Press a key. 
	 * @param key 
	 */
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) // To prevent errors
			return;
		keys[e.getKeyCode()] = true;
	}
	
	/** Release a key. 
	 * @param key 
	 */	
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) // To prevent errors
			return;
		keys[e.getKeyCode()] = false;
		
	}

	
	public void keyTyped(KeyEvent e) 
	{
		
		
	}
}
