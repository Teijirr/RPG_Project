package rpgTeam.rpg.general;
import java.awt.Graphics;

import rpgTeam.rpg.entities.EntityManager;
import rpgTeam.rpg.entities.creatures.Player;
import rpgTeam.rpg.entities.staticEntities.Monster;
import rpgTeam.rpg.entities.staticEntities.NPC;
import rpgTeam.rpg.entities.staticEntities.Rock;
import rpgTeam.rpg.entities.staticEntities.Ship;
import rpgTeam.rpg.entities.staticEntities.Tree;
import rpgTeam.rpg.gfx.Assets;
import rpgTeam.rpg.items.Item;
import rpgTeam.rpg.items.ItemManager;
import rpgTeam.rpg.tiles.Tile;
import rpgTeam.rpg.utils.Utils;
/** World of the game.
 * It is composed of tiles and entitys.
 * @author RPG Team
 *
 */
public class World 
{
	/** Handler object. */
	private Handler handler;
	/** World's size (tiles). */
	private int width, height;
	/** Character's spawn. */
	private int spawnx, spawny;
	/** World is a table of tiles. */
	private int[][] tiles;
	
	/** World's entities. */
	private EntityManager entityManager;
	
	/** World's items. */
	private ItemManager itemManager;
	/** World's NPC. */
	public NPC npc1;
	public NPC npc2;
	public NPC npc3;
	public NPC npc4;
	/** World's monsters. */
	public Monster monster1;
	public Monster monster2, monster3;
	/** World's constructor. */
	public World(Handler handler, String path)
	{
		this.handler = handler;
		itemManager = new ItemManager(handler);
		entityManager = new EntityManager(handler, new Player(handler,100,100));
		
		
		
		// Here we initialize entities 
		entityManager.addEntity(new Tree(handler,500,250));
		entityManager.addEntity(new Tree(handler,1200,2200));
		entityManager.addEntity(new Rock(handler,1800,1500));
		entityManager.addEntity(new Rock(handler,350,160));
		entityManager.addEntity(new Rock(handler,850,160));
		entityManager.addEntity(new Rock(handler,520,1510));
		entityManager.addEntity(new Rock(handler,1800,510));
		entityManager.addEntity(new Rock(handler,460,2200));
		entityManager.addEntity(new Ship(handler,1850,520));
		entityManager.addEntity(new Ship(handler,700,1480));
		npc1 = entityManager.addNPC(new NPC(handler, 1000,800, 1, Assets.npc));
		npc2 = entityManager.addNPC(new NPC(handler, 2050,1000, 2, Assets.npc2));
		npc3 = entityManager.addNPC(new NPC(handler, 900,1980, 2, Assets.npc3));
		npc4 = entityManager.addNPC(new NPC(handler, 980,1000, 2, Assets.npc4));
		
		// Initialize monsters
		monster1 = entityManager.addMonster(new Monster(handler, 960,400, 1, Assets.monster1));
		monster2 = entityManager.addMonster(new Monster(handler, 1900,1060, 2, Assets.monster2));
		monster3 = entityManager.addMonster(new Monster(handler, 1400,700, 2, Assets.girl));


		
		// Here we initialize items
		itemManager.addItem(new Item(Assets.pokeball, "poke1",0, 900, 2200));
		itemManager.addItem(new Item(Assets.pokeball, "poke2",1, 1000, 2400));
		itemManager.addItem(new Item(Assets.potion, "potion1",2, 950, 2100));
		
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnx);
		entityManager.getPlayer().setY(spawny);
		
	}
	/** World's update. */
	public void update()
	{
		itemManager.update();
		entityManager.update();

		if (monster3.death)
		{
			monster3 = entityManager.addMonster(new Monster(handler, 1400,800, 2, Assets.girldown));
			monster3.setHp(99999);
		}
	}
	/** World's render. */
	public void render(Graphics g) // draw every tiles, even if it is not on the screen, may need optimization
	{
		
		for (int y = 0; y<height;y++)
		{
			for(int x=0; x<width;x++)
			{
				// Render the world, and take into account the camera
				getTile(x,y).render(g, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int)(y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		// Now render the items
		itemManager.render(g);
		
		
		// Now render the entities
		entityManager.render(g);
	}
	/** Get entity manager. */
	public EntityManager getEntityManager() {
		return entityManager;
	}
	/**
	 * Get a tile with his position. 
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile getTile(int x, int y)
	{
		if(x<0 || y<0|| x >= width||y >= height) // If the player went ouf of map, just in case, to prevent errors
			return Tile.grassTile; 
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t== null)
			return Tile.grassTile;
		return t;
	}
	
	/** Load world with txt file. */
	private void loadWorld(String path) // Load a world from a file
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); // Every char (number here) separated by a space and each placed in an array
		width = Utils.parseInt(tokens[0]); // First number is the width of the world
		height = Utils.parseInt(tokens[1]); // Second number is the height of the world
		spawnx = Utils.parseInt(tokens[2]);
		spawny = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0; y<height;y++) // We go through all the world
			for(int x=0; x<width; x++)
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width) + 4]); // Each char becomes an int
	}
	
	/** Getters and setters. */
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}
