package rpgTeam.rpg.general;
/**
 * Start the game.
 * @author RPG Team
 *
 */
public class GameLauncher {

	public static void main(String[] args) 
	{
		Game game = new Game("RPG", 1280,720);
		game.start(); // As a thread
		
	}

}
