package rpgTeam.rpg.gfx;
import java.awt.image.BufferedImage;
/**
 * Class for pictures, musics...
 * @author RPG Team
 *
 */
public class Assets 
{
	/**
	 * Picture's size in pixels.
	 */
	private static final int width=32, height=32;
	/**
	 * Attribute for all images.
	 */
	public static BufferedImage player, dirt, grass, tree, rock, rocktile, buttons, pokeball, npc, npc2,npc3, npc4, background, pp, tuto, zeus, watertile, ship, sandtile, inventory, monster1, monster2, potion, explosion, girl,girldown, tutov2, buttonv2; // We put them static so they can be accessed from anywhere
	public static BufferedImage[] player_down, player_up, player_left, player_right; // These arrays will store all the images of the animations
	/**
	 * Load pictures.
	 * 
	 * This method call only once, because we do not need to load new textures every time.
	 */
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/128x128-basicspritesheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/da_rpg_characters.png"));
		SpriteSheet rockSheet = new SpriteSheet(ImageLoader.loadImage("/textures/rocktiles.png"));
		SpriteSheet waterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/watertile.png"));
		SpriteSheet sandSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sandtile.png"));
		SpriteSheet potionSheet = new SpriteSheet(ImageLoader.loadImage("/textures/potionsprite.png"));
		SpriteSheet monica = new SpriteSheet(ImageLoader.loadImage("/textures/Monica.png"));
		
		
		buttons = ImageLoader.loadImage("/textures/buttonsheet.png");
		buttonv2 = ImageLoader.loadImage("/textures/buttonv2.png");
		tutov2 = ImageLoader.loadImage("/textures/tutov2.png");
		tuto = ImageLoader.loadImage("/textures/tutorial.png");
		tree = ImageLoader.loadImage("/textures/tree.png"); // No need of a sprite sheet for the tree
		pokeball = ImageLoader.loadImage("/textures/pokeball64.png");
		background = ImageLoader.loadImage("/textures/background.png");
		pp = ImageLoader.loadImage("/textures/profilepicture.png");
		zeus = ImageLoader.loadImage("/textures/_zeus_by_el_grimlock_2.jpg");
		ship = ImageLoader.loadImage("/textures/ship.png");
		inventory = ImageLoader.loadImage("/textures/inventory.png");
		monster1= ImageLoader.loadImage("/textures/veromos.png");
		monster2 = ImageLoader.loadImage("/textures/theomars.png");
		explosion = ImageLoader.loadImage("/textures/explosion-2964038_960_720.png");
//		girl = ImageLoader.loadImage("/textures/Monica.png");
//		girldeath=j;
		
		player = playerSheet.crop(width*7, 0, width, height);
		npc = playerSheet.crop(width, 0, width, height);
		npc2 = playerSheet.crop(width*4, 0, width, height);
		npc3 = playerSheet.crop(width*4, 0, width, height);
		npc4 = playerSheet.crop(width, height*4, width, height);/////////////////////////////
		potion = potionSheet.crop(45, 0, 45, 45);
		girl =monica.crop(0, 0,65, 65);
		girldown=monica.crop(380, 340,60, 40);
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		
		// We tell where the image of the player is on the sprite sheet
		player_down[0] = playerSheet.crop(width*6, 0, width, height);
		player_down[1] = playerSheet.crop(width*8, 0, width, height);
		
		
		player_up[0] = playerSheet.crop(width*6, height*3, width, height);
		player_up[1] = playerSheet.crop(width*8, height*3, width, height);
		
		
		player_left[0] = playerSheet.crop(width*6, height, width, height);
		player_left[1] = playerSheet.crop(width*8, height, width, height);
		

		player_right[0] = playerSheet.crop(width*6, height*2, width, height);
		player_right[1] = playerSheet.crop(width*8, height*2, width, height);
		
		
		grass = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width*2, 0, width, height);
		
		
		rocktile = rockSheet.crop(285, 136, width, height);
		rock = rockSheet.crop(185, 0, width, height);
		sandtile = sandSheet.crop(0, 0,width, height);
		watertile = waterSheet.crop(0, 0,width, height);
		
	}
}
