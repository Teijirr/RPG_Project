package rpgTeam.rpg.tiles;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** Contains tiles for the world.
 * @author RPG Team
 */
public class Tile 
{
	/** Array of different tiles. */
	public static Tile[] tiles = new Tile[256]; // Holds one instance of every single tile in our game
	public static Tile grassTile = new GrassTile(0); // ID is 0
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	public static Tile waterTile = new WaterTile(3);
	public static Tile sandTile = new SandTile(4);
	
	
	
	/** Tile's size. */
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	/** Tile's skin. */
	protected BufferedImage texture;
	/** Tile's unique id. */
	protected final int id; 
	/**
	 * Tile's constructor.
	 * @param texture
	 * @param id
	 */
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id=id;
		
		tiles[id] = this; // Depends on the ID, it can create a GrassTile, a TreeTile...
	}
	
	public void update()
	{
		
	}
	/** Tile's render. */
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	/** Tile's state, if tile walkable by characters. */
	public boolean isNotWalkable() {
		return false;
	}
	
	/**
	 * Get id of the tile. 
	 * @return
	 */
	public int getID()
	{
		return id;
	}
	
}
