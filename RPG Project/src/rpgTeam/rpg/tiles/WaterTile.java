package rpgTeam.rpg.tiles;

import rpgTeam.rpg.gfx.Assets;

/**
 * Water tile.
 * A type of tile.
 * @author RPG Team
 *
 */
public class WaterTile extends Tile
{
	/** Walkable state. */
	public boolean Walkable = false;
	/** Water tile's constructor. */
	public WaterTile(int id) 
	{
		super(Assets.watertile, id);
	}
	/** Walkable by characters state. */
	@Override
	public boolean isNotWalkable()
	{
		return true;
	}

}
