package rpgTeam.rpg.display;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
/**
 * Graphics Java.
 * @author RPG Team
 *
 */
public class Display
{
	/** JFrame . */
	private JFrame frame;
	/** Canvas */
	private Canvas canvas; // Canvas = toile, we can draw on it
	/** Title. */
	private String title;
	/** Size in pixels. */
	private int width, height; // Pixels
	/**
	 * Constructor of display.
	 * @param title
	 * @param width
	 * @param height
	 */
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	
	}
	/** Handle the display.*/
	private void createDisplay() 
	{
		frame = new JFrame(title); // Instanciate JFrame, the title of the windows is in parameter
		frame.setSize(width, height); // The size of our window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Really close the processus when the window is closed
		
		frame.setResizable(false); // Can't change the size of the window
		frame.setLocationRelativeTo(null); // Open window in the center of the screen
		frame.setVisible(true); // We can see the window!
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height)); // Our canvas will always be the size we give to
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false); // JFrame is the only thing than can have focus, so the keys pressed will actually be captured
		
		frame.add(canvas); // Add the canvas to JFrame
		frame.pack(); //Resize the window a little bit so we can see fully the canvas
		
	}
	/** @return canvas*/
	public Canvas getCanvas() 
	{
		return canvas;
	}
	/** @return frame*/
	public JFrame getFrame()
	{
		return frame;
	}

}
