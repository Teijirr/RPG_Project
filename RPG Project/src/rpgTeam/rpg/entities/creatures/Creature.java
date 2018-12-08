package rpgTeam.rpg.entities.creatures;
import rpgTeam.rpg.entities.Entity;
import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.tiles.Tile;

/**
 * Abstract class for a creature.
 * Creature is an entity.
 * @author RPG Team
 *
 */
public abstract class Creature extends Entity{
	/** Default creature's Health. */
	public static final int DEFAULT_HEALTH = 10; 
	/**  Default creature's size. */
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64; 
	/** Creature's health. */
	protected int health; // Protected so extended classes can access this
	/** Creature's position */
	protected float xMove, yMove;
	protected float displacement = 4; // Will tell the "speed" of the displacement
	
	/**
	 * Constructor of a creature.
	 * @param handler
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Creature(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height); // Calls the entity constructor
		health = DEFAULT_HEALTH;
		
		xMove=0; // A creature doesn't move at first
		yMove=0;
	}
	/* Creature move. */
	protected void move() 
	{
		if(!checkEntityCollision(xMove,0f))
			moveX();
		if(!checkEntityCollision(0f,yMove))
			moveY();
		
	}
	/* Moving right and left and checking collisions. */
	public void moveX()
	{
		if(xMove>0) // Right
		{
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH; // Give the x coordinate of the tile we're moving to
			if(Player.playerCantMove==false && !collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) // If it is walkable, checking right up and right down of the rectangle, also, check if the creature is talking then she can't move
			{
				x=x+xMove;
			}
			
		}
		else if (xMove<0) // Left
		{
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if(Player.playerCantMove==false && !collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) // If it is walkable, checking left up and left down of the rectangle
			{
				x=x+xMove;
			}
			
		}
		
	}
	
	
	/* Moving up and down and checking collisions. */
	public void moveY()
	{
		if (yMove <0) // Up
		{
			int a = (int) (y + yMove + bounds.y)/ Tile.TILEHEIGHT;
			
			if(Player.playerCantMove==false && !collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, a) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, a)) // If it is walkable, checking up right and up left of the rectangle
			{
				y = y+yMove;
			}
		}
		else if (yMove>0) // Down
		{
			int b = (int) (y + yMove + bounds.y + bounds.height)/ Tile.TILEHEIGHT;
			
			if(Player.playerCantMove==false &&!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, b) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, b))  // If it is walkable, checking down right and down left of the rectangle
			{
				y = y+yMove;
			}
		}
	}
	
	/**
	 * Check collisions.
	 * @param x
	 * @param y
	 * @return boolean
	 */
	protected boolean collisionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isNotWalkable();
	}
	
	


	/**
	 * Getters and setters.
	 * @return
	 */
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
