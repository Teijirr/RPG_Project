package rpgTeam.rpg.gfx;
import java.awt.image.BufferedImage;
/**
 * SpriteSheet.
 * A SpriteSheet allows us to load one image, with every images needed in it.
 * @author RPHG Team
 */
public class SpriteSheet 
{
	/** Sheets. */
	private BufferedImage sheet;
	/** SpriteSheet constructor's. */
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	/**
	 * Croped part of the image.
	 * x, y, width and height are in pixels.
	 * x and y starting pos, width and height ending pos
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return sheet.getSubimage(x, y, width, height); // This method will return the part of the image we specified
	}
}
