package rpgTeam.rpg.tiles;

import rpgTeam.rpg.gfx.Assets;

/**
 * Rock tile.
 * A type of tile.
 * @author RPG Team
 *
 */
public class RockTile extends Tile 
{
	/** State of Walkable. */
	public boolean Walkable = false;
	/** Constructor. */
	public RockTile(int id) 
	{
		super(Assets.rocktile, id);
	}
	
	
	@Override // This method is overwritting the tile method
	public boolean isNotWalkable() // Is the tile walkable by the character?
	{
		return true;
	}

}
