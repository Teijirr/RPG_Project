package rpgTeam.rpg.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import rpgTeam.rpg.entities.creatures.Player;


/** Load the music.
 * 
 * @author RPG Team
 *
 */
public class Sound 
{
	public static Clip clip;
	
	/** LoadMusic constructor. 
	 * Java only support Wav.
	 * @param path
	 * @return
	 */
	public static Clip loadMusic(String path)
	{
		
		AudioInputStream audioInputStream;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(path));
			clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        return clip;
			}
		catch (UnsupportedAudioFileException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		catch (LineUnavailableException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
        
}