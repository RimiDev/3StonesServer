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
	
	public Game(GameBoard gameBoard)
	{
		
	}

	public void play(Point point)
	{
		
	}
	
	public void play(int x, int y)
	{
		
	}
	
	public List<Tile> getNeighbouringTiles()
	{
		List<Tile> tiles = new ArrayList<Tile>();
		
		return tiles;
	}
	
	public boolean checkThreeInARow()
	{
		return false;
	}
	
	public boolean checkGameEnd()
	{
		return false;
	}
	
	public void incrementServerScore()
	{
		
	}
	
	public void incrementClientScore()
	{
		
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
