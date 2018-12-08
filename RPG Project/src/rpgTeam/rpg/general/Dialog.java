package rpgTeam.rpg.general;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rpgTeam.rpg.entities.creatures.Player;
import rpgTeam.rpg.entities.staticEntities.NPC;
import rpgTeam.rpg.gfx.Assets;
/**
 * Dialog with NPC.
 * @author RPG Team
 *
 */
public class Dialog 
{
	/** Object NPC. */
	@SuppressWarnings("unused")
	private NPC npc;
	/** Object handler. */ 
	private Handler handler;
	private BufferedImage backgrounddialog = Assets.background;
	private BufferedImage ppdialog = Assets.pp;
	

	/** Attribute for the placement of the dialog. */
	private int x=0; 
	private int y=(Game.height/2)+50; // dialog will start a bit after the middle of the height of the screen
	private int dialogwidth = Game.width;
	private int dialogheight = Game.height/2;
	
	/**
	 * Constructor of the dialog.
	 * @param handler
	 * @param npc
	 */
	public Dialog(Handler handler, NPC npc)
	{
		this.handler=handler;
		this.npc=npc;
	}
	
	// Method to get NPC Position
	// The dialog will depend on which npc we talk to, so we check where the npc is from the player, around 70pixels
	public boolean NPCIsClose(NPC npc)
	{
		if (handler.getWorld().getEntityManager().getPlayer().getX() -70 < npc.getX() && npc.getX() < handler.getWorld().getEntityManager().getPlayer().getX() + 70 )
		{
			if (handler.getWorld().getEntityManager().getPlayer().getY() -70 < npc.getY() && npc.getY() < handler.getWorld().getEntityManager().getPlayer().getY() + 70 )
			{
				return true;
			}
		}
		return false;
	}
	
	// Second method, depending on a variables entered in parameter // USED FOR TESTS ONLY
	public boolean NPCIsClose(NPC npc, int var)
	{
		if (handler.getWorld().getEntityManager().getPlayer().getX() -var < npc.getX() && npc.getX() < handler.getWorld().getEntityManager().getPlayer().getX() + var )
		{
			if (handler.getWorld().getEntityManager().getPlayer().getY() -var < npc.getY() && npc.getY() < handler.getWorld().getEntityManager().getPlayer().getY() + var )
			{
				return true;
			}
		}
		return false;
	}
	
	
	public static void drawStringMultiLine(Graphics g, String text, int lineWidth, int x, int y) {
	    FontMetrics m = g.getFontMetrics();
	    if(m.stringWidth(text) < lineWidth) {
	        g.drawString(text, x, y);
	    } else {
	        String[] words = text.split(" ");
	        String currentLine = words[0];
	        for(int i = 1; i < words.length; i++) {
	            if(m.stringWidth(currentLine+words[i]) < lineWidth) {
	                currentLine += " "+words[i];
	            } else {
	                g.drawString(currentLine, x, y);
	                y += m.getHeight();
	                currentLine = words[i];
	            }
	        }
	        if(currentLine.trim().length() > 0) {
	            g.drawString(currentLine, x, y);
	        }
	    }
	}
	
	
	
	/* Method for display the dialog. */
	public void render(Graphics g)  // The dialog can draw itself to the screen
	{

		g.drawImage(backgrounddialog, x, y, dialogwidth, dialogheight, null); // Draw background
		if(g.drawImage(backgrounddialog, x, y, dialogwidth, dialogheight, null) == true)
		{
			g.setFont(new Font("Arial", Font.PLAIN, 30)); // The font we'll be using
//			String newline = System.getProperty("line.separator");
//			String newline2 = "\n";
		
				if (NPCIsClose(handler.getWorld().npc1))
				{
					Player.playerCantMove=true; // The player can't move when dialog is up
					g.drawImage(ppdialog, x+40, y+10, dialogwidth/6, dialogheight/2, null); // Draw the picture of the character talking
					//g.drawString("Hello, I'm NPC number 1" + newline + "And another line now too.", dialogwidth/3, y+80); // draw the text the character says
					drawStringMultiLine(g,"Their is a lot of monsters here, you can fight them. Take care !", 700, dialogwidth/3, y+80);
				
					if(handler.getKeyManager().p)
					{
						NPC.isTalking=false; // If p is pressed, dialog is closed
						Player.playerCantMove=false; // Player can move again
						
					}
				}

				if (NPCIsClose(handler.getWorld().npc2))
				{
					Player.playerCantMove=true; // The player can't move when dialog is up
					g.drawImage(Assets.zeus, x+40, y+10, dialogwidth/6, dialogheight/2, null); // Draw the picture of the character talking
					drawStringMultiLine(g,"Let's go to the lost island.", 700, dialogwidth/3, y+80); // draw the text the character says
				
					if(handler.getKeyManager().p)
					{
						NPC.isTalking=false; // If p is pressed, dialog is closed
						Player.playerCantMove=false; // Player can move again
						
						Player player1 = handler.getWorld().getEntityManager().getPlayer();
						player1.setXposition(975);
						player1.setYposition(1985);
					}
				}
				
				if (NPCIsClose(handler.getWorld().npc3))
				{
					Player.playerCantMove=true; // The player can't move when dialog is up
					g.drawImage(Assets.zeus, x+40, y+10, dialogwidth/6, dialogheight/2, null); // Draw the picture of the character talking
					drawStringMultiLine(g,"Back on land.", 700, dialogwidth/3, y+80); // draw the text the character says
				
					if(handler.getKeyManager().p)
					{
						NPC.isTalking=false; // If p is pressed, dialog is closed
						Player.playerCantMove=false; // Player can move again
						
						Player player1 = handler.getWorld().getEntityManager().getPlayer();
						player1.setXposition(2120);
						player1.setYposition(1000);
					}
				}
				
				if (NPCIsClose(handler.getWorld().npc4))
				{
					Player.playerCantMove=true; // The player can't move when dialog is up
					g.drawImage(Assets.zeus, x+40, y+10, dialogwidth/6, dialogheight/2, null); // Draw the picture of the character talking
					drawStringMultiLine(g,"Hello, I've lost my items on an island. Keep what you find! I don't care :) ", 700, dialogwidth/3, y+80); // draw the text the character says
				
					if(handler.getKeyManager().p)
					{
						NPC.isTalking=false; // If p is pressed, dialog is closed
						Player.playerCantMove=false; // Player can move again
						
						//Player player1 = handler.getWorld().getEntityManager().getPlayer();
						
					}
				}
		
			

			

		}
	}
}
