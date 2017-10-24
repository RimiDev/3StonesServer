import java.util.ArrayList;
import java.util.List;

public class Game
{
	private int scoreClient;
	private int scoreServer;
	private int stoneClient;
	private int stoneServer;
	private int lastPlayX;
	private int lastPlayY;
	private GameBoard gameBoard;
	private boolean whiteTurn;
	
	public Game(GameBoard gameBoard)
	{
		this.gameBoard = gameBoard;
		whiteTurn = true;
		scoreClient = 0;
		scoreServer = 0;
		stoneClient = 15;
		stoneServer = 15;
		lastPlayX = -1;
		lastPlayY = -1;
	}
	
	public void play(int x, int y)
	{
		if(whiteTurn)
		{
			scoreClient += gameBoard.setTile(x, y, Tile.WHITE);
		}
		else
		{
			//scoreServer += gameBoard.setTile(x, y, Tile.BLACK);
		}
	}
	
	public List<Point> getAvailableTiles()
	{
		List<Point> availableTiles = new ArrayList<>();
		for(int i = 0; i < gameBoard.getBoard().length; i++)
		{
			for(int j = 0; j < gameBoard.getBoard()[0].length; j++)
			{
				if(i == lastPlayX || j == lastPlayY)
				{
					if(gameBoard.getBoard()[i][j] == Tile.EMPTY)
						availableTiles.add(new Point(i,j));
				}
			}
		}
		
		return availableTiles;
	}
	
	public boolean checkGameEnd()
	{
		if(stoneClient == 0 && stoneServer == 0)
			return true;
		
		return false;
	}
	
	public int getScoreClient()
	{
		return scoreClient;
	}

	public void setScoreClient(int scoreClient)
	{
		this.scoreClient = scoreClient;
	}

	public int getScoreServer()
	{
		return scoreServer;
	}

	public void setScoreServer(int scoreServer)
	{
		this.scoreServer = scoreServer;
	}

	public int getStoneClient()
	{
		return stoneClient;
	}

	public void setStoneClient(int stoneClient)
	{
		this.stoneClient = stoneClient;
	}

	public int getStoneServer()
	{
		return stoneServer;
	}

	public void setStoneServer(int stoneServer)
	{
		this.stoneServer = stoneServer;
	}

	public int getLastPlayX()
	{
		return lastPlayX;
	}

	public void setLastPlayX(int lastPlayX)
	{
		this.lastPlayX = lastPlayX;
	}

	public int getLastPlayY()
	{
		return lastPlayY;
	}

	public void setLastPlayY(int lastPlayY)
	{
		this.lastPlayY = lastPlayY;
	}
}
