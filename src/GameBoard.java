import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameBoard
{
	private Tile[][] board;
	
	public GameBoard(String csvFile)
	{
		// File loading logic not tested yet
		
		
		File file = new File(csvFile);
		
		List<String> lines = new ArrayList<>();
		
		// Storing a string of each line into a List
		try(Scanner scanner = new Scanner(file))
		{
			while(scanner.hasNextLine())
			{
				lines.add(scanner.nextLine());
			}
			
			// Instantiating board
			board = new Tile[lines.size()][lines.get(0).split(",").length];
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		// Setting the Tiles to the board
		for(int i = 0; i < board.length; i++)
		{
			String[] tiles = lines.get(i).split(",");
			
			for(int j = 0; j < board[0].length; j++)
			{
				switch(tiles[j])
				{
					case "n": 
						board[i][j] = Tile.NOTTILE;
						break;
					case "e": 
						board[i][j] = Tile.EMPTY;
						break;
					default: throw new IllegalArgumentException("CSV file was either not read correctly or an unexpected string was read");
				}
			}
		}
	}
	
	public Tile[][] getBoard()
	{
		return board;
	}
	
	public int setTile(int x, int y, Tile tile)
	{
		board[x][y] = tile;
		
		return checkThreeInARow(x, y, tile);
	}
	public boolean isEmpty(int x, int y)
	{
		return board[x][y] == Tile.EMPTY;
	}
	
	private int checkThreeInARow(int x, int y, Tile tile)
	{
		int points = 0;
		
		if(tile == Tile.WHITE)
		{
			// Diagonal checking from the upper side
			if(board[x-1][y-1] == Tile.WHITE)
			{
				// Check upper-left corner for points
				if(board[x-2][y-2] == Tile.WHITE)
				{
					points += 1;
				}
				
				// Checks if the set tile creates a three in a row diagonal
				if(board[x+1][y+1] == Tile.WHITE)
				{
					points += 1;
				}
			}
			
			// Diagonal checking from the bottom side
			if(board[x+1][y+1] == Tile.WHITE)
			{
				// Checks bottom-right corner for points
				if(board[x+2][y+2] == Tile.WHITE)
				{
					points += 1;
				}
			}
			
			// Horizontal checking
			if(board[x-1][y] == Tile.WHITE)
			{
				if(board[x-2][y] == Tile.WHITE)
				{
					points += 1;
				}
				
				if(board[x+1][y] == Tile.WHITE)
				{
					points += 1;
				}
			}
			
			if(board[x+1][y] == Tile.WHITE)
			{
				if(board[x+2][y] == Tile.WHITE)
				{
					points +=1;
				}
			}
			
			// Vertical checking
			if(board[x][y-1] == Tile.WHITE)
			{
				if(board[x][y-2] == Tile.WHITE)
				{
					points += 1;
				}
				
				if(board[x][y+1] == Tile.WHITE)
				{
					points += 1;
				}
			}
			
			if(board[x][y+1] == Tile.WHITE)
			{
				if(board[x][y+2] == Tile.WHITE)
				{
					points +=1;
				}
			}
		}
		else if(tile == Tile.BLACK)
		{
			// Diagonal checking from the upper side
			if(board[x-1][y-1] == Tile.BLACK)
			{
				// Check upper-left corner for points
				if(board[x-2][y-2] == Tile.BLACK)
				{
					points += 1;
				}
				
				// Checks if the set tile creates a three in a row diagonal
				if(board[x+1][y+1] == Tile.BLACK)
				{
					points += 1;
				}
			}
			
			// Diagonal checking from the bottom side
			if(board[x+1][y+1] == Tile.BLACK)
			{
				// Checks bottom-right corner for points
				if(board[x+2][y+2] == Tile.BLACK)
				{
					points += 1;
				}
			}
			
			// Horizontal checking
			if(board[x-1][y] == Tile.BLACK)
			{
				if(board[x-2][y] == Tile.BLACK)
				{
					points += 1;
				}
				
				if(board[x+1][y] == Tile.BLACK)
				{
					points += 1;
				}
			}
			
			if(board[x+1][y] == Tile.BLACK)
			{
				if(board[x+2][y] == Tile.BLACK)
				{
					points +=1;
				}
			}
			
			// Vertical checking
			if(board[x][y-1] == Tile.BLACK)
			{
				if(board[x][y-2] == Tile.BLACK)
				{
					points += 1;
				}
				
				if(board[x][y+1] == Tile.BLACK)
				{
					points += 1;
				}
			}
			
			if(board[x][y+1] == Tile.BLACK)
			{
				if(board[x][y+2] == Tile.BLACK)
				{
					points +=1;
				}
			}
		}
		
		return points;
	}
}
