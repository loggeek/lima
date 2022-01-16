package utils;

import java.io.*;
import java.util.logging.*;

/**
 * Custom logging class.
 * 
 * @author logan
 */

public class Log
{
	private static final Logger logger = Logger.getLogger("logger");
	
	static
	{
		// Sets up the formatter.
		System.setProperty("java.util.logging.SimpleFormatter.format",
	              "%1$tF %1$tT.%1$tL %1$tZ [%4$s] @ %2$s: %5$s%n");
		
		try
		{
			// Sets up the file handler.
			Handler handler = new FileHandler("%t/lima-log_%g.log", 100000, 10);
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
		}
		catch (IOException | SecurityException e)
		{
			logger.severe("Couldn't initialize the file handler for the logger.");
			System.exit(-1);
		}
	}
	
	private Log()
	{
		throw new IllegalStateException("An utility class shall not be instantiated.");
	}
	
	/**
	 * Returns the raw logger.
	 * 
	 * @author logan
	 */
	
	public static Logger getLogger()
	{
		return logger;
	}
}
