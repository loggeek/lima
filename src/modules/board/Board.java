package modules.board;

/**
 * Chinese checkers board.
 * 
 * @author loggeek
 */

public class Board
{
	byte[][] board1; // No rotation
	byte[][] board2; // Flipped 90° right
	byte[][] board3; // Flipped 90° left
	int playerNum;
	
	/**
	 * Creates a new board.
	 * 
	 * @param playerNum
	 * <ul>
	 * <li>	0 for an empty board; </li>
	 * <li> of {2, 4, 6} for a board filled with the specified amount of players. </li>
	 * </ul>
	 * @throws IllegalArgumentException if any argument is invalid.
	 * @author loggeek
	 */
	
	public Board(int playerNum) throws IllegalArgumentException
	{
		this.playerNum = playerNum; // Saves the number of players
		
		switch (playerNum)
		{
			case 0: break;
			case 2: break;
			case 4: break;
			case 6: break;
			default:throw new IllegalArgumentException(String.format(
						"Invalid number of players (given %d, expected of {0, 2, 4, 6}.", playerNum));
		}
	}
	
	/**
	 * Checks if a specified square is valid.
	 * 
	 * @param x of {0:24}
	 * @param y of {0:16}
	 * @return the result of the verification.
	 * @throws IllegalArgumentException if any argument is invalid.
	 * @author loggeek
	 */
	
	public static boolean isSquareValid(int x, int y)
	{
		// Sanity check
		if (x < 0 || x > 24) throw new IllegalArgumentException(String.format(
				"Invalid x coordinate (given %d, expected of {0:24}.", x));
		if (y < 0 || y > 16) throw new IllegalArgumentException(String.format(
				"Invalid y coordinate (given %d, expected of {0:16}.", x));
		
		// Verifies if the coordinates are either both even or both odd
		if ((x%2 == 0 && y%2 == 0) || (x%2 == 1 && y%2 == 1))
		{
			if (y > 8) y = 16 - y; // The board is symmetrical, so that saves time
			switch (y)
			{
				case 0: return (x == 12);
				case 1:
				case 2:
				case 3: return (x > 11 - y && x < 13 + y);
				case 4:
				case 5: return true;
				case 6:
				case 7:
				case 8: return (x > -5 + y && x < 30 - y);
				default:throw new AssertionError(); // Should never happen
			}
		}
		else return false;
	}
}
