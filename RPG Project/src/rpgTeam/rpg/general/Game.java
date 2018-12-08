package rpgTeam.rpg.general;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import rpgTeam.rpg.display.Display;
import rpgTeam.rpg.gfx.Assets;
import rpgTeam.rpg.gfx.GameCamera;
import rpgTeam.rpg.input.KeyManager;
import rpgTeam.rpg.states.GameState;
import rpgTeam.rpg.states.MenuState;
import rpgTeam.rpg.states.State;
import rpgTeam.rpg.states.TutorialState;
import rpgTeam.rpg.utils.Sound;
/** RPG.
 * 
 * @author RPG Team.
 *
 */
public class Game implements Runnable // Game is a thread
{
	/** Display of the game. */
	private Display display;
	/** Title of the game. */
	public String title;
	/** Size of the game. */
	public static int width, height; // Every classes can know the width and height of the game (in pixels)
	/** State of the game. */
	private boolean running=false;
	/** Game Thread. */
	private Thread gameThread;
	/**
	 * Buffer of the game.
	 * A buffer is like a hidden screen, so it will switch the different 'layers' to the screen.
	 * This will allow the game to be smooth.
	 */
	private BufferStrategy bs; // BufferStrategy tells the computer how to draw things to the screen -- Uses a buffer
	private Graphics g; // Allows to draw things, like a paint brush
	
	/** Different states of the game. */
	public State gameState;
	public State menuState;
	public State tutorialState;
	
	/** Input key. */
	private KeyManager keyManager;
	
	/** Game camera. */
	private GameCamera camera;
	
	/** Handler. */
	private Handler handler;
	
	/** Game's sounds. */
	private Clip clip;
	
	/**
	 * Constructor of the game.
	 * @param title
	 * @param width
	 * @param height
	 */
	public Game(String title, int width, int height)
	{
		Game.width = width;
		Game.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	/** Graphic's initialize. */
	private void init()
	{
		display = new Display(title, width, height); // When we create a game, the display is also created
		display.getFrame().addKeyListener(keyManager); // We add the keyListener to the Jframe object, so we can access the keyboard
		Assets.init();
		
		handler = new Handler(this);
		camera = new GameCamera(this, 0,0); // We instanciate a camera
		
		
		gameState = new GameState(handler); // Here we initialize the states
		menuState = new MenuState(handler,MenuState.getX(),MenuState.getY(),MenuState.getWidth(),MenuState.getHeight());
		tutorialState = new TutorialState(handler, TutorialState.getX(), TutorialState.getY(), TutorialState.getWidth(), TutorialState.getHeight());
		
		clip = Sound.loadMusic("res/song/beethoven.wav"); // Launch this song ony at the beginning of the game
		
		try 
		{
			State.setState(menuState); // The active state is now the menuState
		} 
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	/**
	 * Update the game.
	 * The game will run at the same speed on every computers.
	 */
	private void update() // Update all our variables, positions of objects...
	{
		keyManager.update();
		if (State.getState()!= null) // Check if there is a state running atm
		{
			State.getState().update();
		}
	}
	/** Render the game. */
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy(); // Will set bs to the current buffer strategy of the canvas
		if(bs == null) // If there is no bufferstrategy created yet, we make it
		{
			display.getCanvas().createBufferStrategy(3); // We have 3 buffers
			return;
		}
		g = bs.getDrawGraphics(); // Create the paint brush
		// Clear the whole screen
		g.clearRect(0, 0, width, height);
		// Beginning of the drawing
		
											// To add an image to eclipse : add a folder, drop the image in the new folder, add the build path of the project to the folder
		if (State.getState()!= null) // If the state exists, we render every frames
		{
			State.getState().render(g);
		}
		
		// End of the drawing
		bs.show();
		g.dispose(); // Free the memory;
	}
	/** Run.
	 * Run method is mandatory in a thread
	 */
	public void run() { 
		init();
		
		int fps = 60; // The game will run a 60 Frames Per Seconds
		double timePerUpdate = 1000000000 / fps; // One second in nanoseconds divided by the fps
		double delta = 0;
		long now;
		long lastTime=System.nanoTime(); // Returns the amount of time in nanoseconds the computer is running at, only way tp get time in java
		long timer = 0; // Variable to know when to print fps
		@SuppressWarnings("unused")
		int ticks = 0; // The actual fps the game is running at
		
		while(running) // Loop while our boolean is true, so when the game is running
		{
			now = System.nanoTime();
			delta = delta + (now - lastTime)/timePerUpdate; // Delta will tell when to call update and render
			timer = timer + now - lastTime;
			lastTime=now;
			
			if(delta >= 1)
			{
				update();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000)
			{
				//System.out.println("FPS : " + ticks);
				ticks = 0;
				timer = 0;
			}
						
		}
		stop();

		
	}
	/** Getters. */
	public KeyManager getKeyManager()
	{
		return keyManager; // Return the keyManager
	}
	
//	public Sound getSound()
//	{
//		return sound;
//	}
	
	public GameCamera getGameCamera()
	{
		return camera;
	}
	
	public State getGameState()
	{
		return gameState;
	}
	
	public Clip getClip() {
		return clip;
	}
	/** Start game.
	 * Synchronized means we target the thread. */
	public synchronized void start()
	{
		if(running) // We check if the thread is not already running
			return;
		running = true;
		gameThread = new Thread(this); // The thread is the game class
		gameThread.start(); // Start our thread -- Reads run method
	}
	/** Stop the game. */
	public synchronized void stop()
	{
		if(running==false) // We check if the thread is not already stoped
			return;
		running=false;
		try 
		{
			gameThread.join(); // Close the thread properly, actually wait until the threa dies
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace(); // Print the error in console
		}
	}
	
}
