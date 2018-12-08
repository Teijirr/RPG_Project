package rpgTeam.rpg.general;
import rpgTeam.rpg.gfx.GameCamera;
import rpgTeam.rpg.input.KeyManager;

/**
 * Handler for game.
 * Only purpose is to access game object and world object.
 * @author RPG Team
 *
 */
public class Handler 
{
	/** Game. */
	private Game game;
	/** World for game. */
	private World world;
	/** Handler's constructor. */
	public Handler(Game game)
	{
		this.game = game;
	}
	
	/** Getters and setters. */
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public int getWidth()
	{
		return Game.width;
	}
	
	public int getHeight()
	{
		return Game.height;
	}
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
