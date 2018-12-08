package rpgTeam.rpg.items;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import rpgTeam.rpg.general.Handler;
import rpgTeam.rpg.utils.Sound;
/**
 * Items.
 * @author RPG Team
 *
 */
public class Item
{

	/** Array for items. */
	public static Item[] items = new Item[256];
//	public static Item poke = new Item(Assets.pokeball, "Pokeball", 0, 400,700);
//	public static Item potion = new Item(Assets.potion, "Potion", 1, 400,800);
	/** Rectangle for collisions. */
	protected Rectangle bounds; // The rectangle we will use to detect collisions
	
	/** Default size of items. */
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	

	/** Object handler. */
	protected Handler handler;
	/** Item's picture. */
	protected BufferedImage texture;
	/** Item's name. */
	protected String name;
	/** Item's state. */
	protected boolean pickedup=false;
	/** Item's id. */
	protected final int id;
	/** Item's position. */
	protected int x;
	protected int y;
	/** Counter for items. */
	protected int count;
	/**
	 * Item's constructor.
	 * @param texture
	 * @param name
	 * @param id
	 * @param x
	 * @param y
	 */
	public Item(BufferedImage texture, String name, int id, int x, int y)
	{
		this.texture=texture;
		this.name=name;
		this.id=id;
		
		this.x=x;
		this.y=y;
		
		count=1;
		
//		bounds = new Rectangle(0,0,ITEMWIDTH,ITEMHEIGHT); // The bounds will be the same as the item
//		bounds.x = 0; // We parameter where we want our bounds to be from the item
//		bounds.y = 0;
//		bounds.width = 200;
//		bounds.height = 200;
		
		items[id] = this;
		
	}
	/** Update item. */
	public void update()
	{
		//System.out.println(handler.getWorld().getEntityManager().getPlayer().getX());
		//System.out.println(handler.getWorld().getItemManager().getItem(items[id]).getX());
		if (pickedup == false) // If item is'nt alreay picked
		{
			// If item is around the player, around 70pixels
			if (handler.getWorld().getItemManager().getItem(items[id]).getX() -70 < handler.getWorld().getEntityManager().getPlayer().getX() && handler.getWorld().getEntityManager().getPlayer().getX() < handler.getWorld().getItemManager().getItem(items[id]).getX() +70) // Check x axe
			{
				if (handler.getWorld().getItemManager().getItem(items[id]).getY() -70 < handler.getWorld().getEntityManager().getPlayer().getY() && handler.getWorld().getEntityManager().getPlayer().getY() < handler.getWorld().getItemManager().getItem(items[id]).getY() +70) // Check y axe
				{
					if(handler.getKeyManager().enter)
					{
						Sound.loadMusic("res/song/Item Found - Sound Effect.wav");
						pickedup=true;
						handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this); // Add the item to the inventory
						
						
					}
				}
			}
		}
	}

	/** Render item on the ground.
	 * 
	 * @param g
	 */
	public void render(Graphics g)
	{
		if(handler==null)
			return;
		if (pickedup!=false) // If object is picked up, do not render it
		{
			return;
		}
		render(g,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()));
	}
	/**
	 * Render item in inventory.
	 * @param g
	 * @param x
	 * @param y
	 */
	public void render(Graphics g, int x, int y) // Item in the inventory
	{
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
		
//		// Collision box
//		g.setColor(Color.red);
//		g.fillRect(x, y,bounds.width, bounds.height);
	}
	/** 
	 * Create an item and add in inventory. 
	 * @param count
	 * @return
	 */
	public Item createNew(int count) 
	{
		Item i = new Item(texture,name,id, x,y);
		i.setPickedup(true);
		i.setCount(count);
		return i;
	}
	/**
	 * Generate an item.
	 * @param x
	 * @param y
	 * @return
	 */
	public Item createNew(int x, int y)
	{
		Item i = new Item(texture,name,id, x,y);
		//i.setPosition(x, y);
		return i;
	}
	/** Check collisions.
	 * 
	 * @param xOffset
	 * @param yOffset
	 * @return
	 */
	public boolean checkItemCollision(float xOffset, float yOffset)
	{
		for(Item e : handler.getWorld().getItemManager().getItems()) // For every items
		{
			if(e.equals(this)) // Not calculate itself
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset)))
				return true;
		}
		return false;
			
	}
	/** 
	 * Get bounds collisions. 
	 * @param xOffset
	 * @param yOffset
	 * @return
	 */
	public Rectangle getCollisionBounds(float xOffset, float yOffset)
	{
		return new Rectangle((int) (x+bounds.x + xOffset), (int) (y+bounds.y + yOffset), bounds.width, bounds.height); // Covers the area of the item
	}
	
	/** Getters and setters. */
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isPickedup() {
		return pickedup;
	}

	public void setPickedup(boolean pickedup) {
		this.pickedup = pickedup;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}
	

	
}
