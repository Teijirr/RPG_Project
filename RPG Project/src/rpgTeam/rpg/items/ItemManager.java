package rpgTeam.rpg.items;
import java.awt.Graphics;
import java.util.ArrayList;

import rpgTeam.rpg.general.Handler;
/**
 * Manage items.
 * @author RPG Team
 *
 */
public class ItemManager 
{
	/** Object handler. */
	private Handler handler;
	/** Item's list. */
	private ArrayList<Item> items;
	
	/** Item. */
	private Item e;
	/**
	 * Item's manager constructor.
	 * @param handler
	 */
	public ItemManager(Handler handler)
	{
		this.handler=handler;
		items = new ArrayList<Item>();
	}
	/** Update. */
	public void update()
	{
		
		for (int i = 0;i<items.size();i++)
		{
			e=items.get(i);
			e.update();
			
//			if(e.isPickedup()) // The player has picked up the Item
//				items.iterator().remove();
		}
			

	}
	/** Render. */
	public void render(Graphics g)
	{
		for(Item i : items)
		{
			i.render(g);
		}
			
		
	}
	/**
	 * Add an item.
	 * @param i
	 * @return
	 */
	public Item addItem(Item i)
	{
		i.setHandler(handler);
		items.add(i);
		return i;
	}
	
	/** Getters and setters. */
	
	public Item getItem(Item i)
	{
		return i;
	}
	

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
}
