package rpgTeam.rpg.entities;
import java.util.ArrayList;

import rpgTeam.rpg.entities.creatures.Player;
import rpgTeam.rpg.entities.staticEntities.Monster;
import rpgTeam.rpg.entities.staticEntities.NPC;
import rpgTeam.rpg.general.Handler;

import java.awt.Graphics;
/**
 * Manage entities.
 * @author RPG Team
 *
 */
public class EntityManager 
{
	/** Object handler. */
	private Handler handler;
	/** Player of the game. */
	private Player player;
	/** Array of entities. */
	private ArrayList<Entity> entities; // Array of Entities without size, so we can have as many entities as we want
	/** Constructor of EntityManager. */
	public EntityManager(Handler handler, Player player)
	{
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
	}
	/** Update entities. */
	public void update()
	{
		for (int i = 0;i<entities.size();i++)
			{
				Entity e = entities.get(i);
				e.update();
			}
			player.update();
		
	}
	/** Render entities. */
	public void render(Graphics g)
	{
		for (int i = 0;i<entities.size();i++)
			{
				Entity e = entities.get(i);
				e.render(g);
			}
			player.render(g);
	}
	/** Add entities.
	 * 
	 * @param entity
	 */
	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	/** Add NPC. 
	 * 
	 * @param NPC
	 * @return 
	 */
	public NPC addNPC(NPC n)
	{
		entities.add(n);
		return n;
	}
	/** 
	 * Add monsters.
	 * @param Monster
	 * @return
	 */
	public Monster addMonster(Monster m)
	{
		entities.add(m);
		return m;
	}
	
	/** Getters and setters. */
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}
	

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}
	

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
}
