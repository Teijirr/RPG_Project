package rpgTeam.rpg.gfx;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Load images.
 * @author RPG Team
 *
 */
public class ImageLoader // The only purpose of this class is to load the image
{
	/**
	 * Load a image. 
	 * @param path
	 * @return
	 */
	public static BufferedImage loadImage(String path)
	{
		try {
			return ImageIO.read(ImageLoader.class.getResource(path)); // Get the image
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1); // Stop the app, no purpose launching it without image
		}
		return null;
	}
}
