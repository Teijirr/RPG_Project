package rpgTeam.rpg.tiles;
import rpgTeam.rpg.gfx.Assets;

/**
 * Grass tile.
 * A type of tile.
 * @author RPG Team
 *
 */
public class GrassTile extends Tile
{
	/**
	 * Super constructor of Dirt Tile.
	 * @param id
	 */
	public GrassTile(int id) // A grass tile is already gonna have a grass image
	{
		super(Assets.grass, id);
		
	}

}
