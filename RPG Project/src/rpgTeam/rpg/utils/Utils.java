package rpgTeam.rpg.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/** Utilities for help us.
 * We can change our txt file for change the world. 
 * @author RPG Team
 *
 */
public class Utils 
{
	/**
	 * Load the world. 
	 * @param path
	 * @return
	 */
	public static String loadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path)); // Will read the file
			String line;
			while((line=br.readLine()) != null) // Reads the next line of the file
			{
				builder.append(line + "\n"); // Append allows to add to a string
			}
			br.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		return builder.toString();
	}
	
	public static int parseInt(String number)
	{
		try
		{
			return Integer.parseInt(number);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
}
