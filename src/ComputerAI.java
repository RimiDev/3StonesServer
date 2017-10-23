import java.util.HashMap;
import java.util.Map;



public class ComputerAI
{
	private final GameBoard board;
	
	public ComputerAI(GameBoard board)
	{
		this.board = board;
	}
	
	public int getPoints(Point point)
	{
		return getPoints(point.getX(), point.getY());
	}
	
	public int getPoints(int x, int y)
	{
		//TODO validation
		
		int totalPoints = 0;
		
		Point row1col1 = new Point(x-1, y-1);
		Point row1col2 = new Point(  x, y-1);
		Point row1col3 = new Point(x+1, y-1);
		
		Point row2col1 = new Point(x-1, y);
		Point row2col2 = new Point(  x, y);
		Point row2col3 = new Point(x+1, y);
		
		Point row3col1 = new Point(x-1, y+1);
		Point row3col2 = new Point(  x, y+1);
		Point row3col3 = new Point(x+1, y+1);
		
		//////ROW 1/////////
		
		// Check stone in row1col1
		if(!board.isEmpty(row1col2) && !board.isEmpty(row1col3))
			totalPoints++;
		if(!board.isEmpty(row2col1) && !board.isEmpty(row3col1))
			totalPoints++;
		if(!board.isEmpty(row2col2) && !board.isEmpty(row3col3))
			totalPoints++;
		
		// Check stone in row1col2
		if(!board.isEmpty(row1col1) && !board.isEmpty(row1col3))
			totalPoints++;
		if(!board.isEmpty(row2col2) && !board.isEmpty(row3col2))
			totalPoints++;
		
		// Check stone in row1col3
		if(!board.isEmpty(row1col1) && !board.isEmpty(row1col2))
			totalPoints++;
		if(!board.isEmpty(row2col3) && !board.isEmpty(row3col3))
			totalPoints++;
		if(!board.isEmpty(row2col2) && !board.isEmpty(row3col1))
			totalPoints++;
		
		//////ROW 2////////
		
		// Check stone in row2col1
		if(!board.isEmpty(row1col1) && !board.isEmpty(row3col1))
			totalPoints++;
		if(!board.isEmpty(row2col2) && !board.isEmpty(row2col3))
			totalPoints++;
		
		// Check stone in row2col2
		if(!board.isEmpty(row3col1) && !board.isEmpty(row1col3))
			totalPoints++;
		if(!board.isEmpty(row1col1) && !board.isEmpty(row3col3))
			totalPoints++;
		if(!board.isEmpty(row2col1) && !board.isEmpty(row2col3))
			totalPoints++;
		if(!board.isEmpty(row1col2) && !board.isEmpty(row3col2))
			totalPoints++;
		
		// Check stone in row2col3
		if(!board.isEmpty(row2col1) && !board.isEmpty(row2col2))
			totalPoints++;
		if(!board.isEmpty(row1col3) && !board.isEmpty(row3col3))
			totalPoints++;
		
		//////ROW 3////////
		
		// Check stone in row3col1
		if(!board.isEmpty(row3col2) && !board.isEmpty(row3col3))
			totalPoints++;
		if(!board.isEmpty(row1col1) && !board.isEmpty(row2col1))
			totalPoints++;
		if(!board.isEmpty(row2col2) && !board.isEmpty(row1col3))
			totalPoints++;
		
		// Check stone in row3col2
		if(!board.isEmpty(row3col1) && !board.isEmpty(row3col3))
			totalPoints++;
		if(!board.isEmpty(row1col2) && !board.isEmpty(row2col2))
			totalPoints++;
		
		// Check stone in row3col3
		if(!board.isEmpty(row1col3) && !board.isEmpty(row2col3))
			totalPoints++;
		if(!board.isEmpty(row3col1) && !board.isEmpty(row3col2))
			totalPoints++;
		if(!board.isEmpty(row1col1) && !board.isEmpty(row2col2))
			totalPoints++;
		
		return totalPoints;
	}
	
	public Point getNextMove()
	{
		Map<Point, Integer> allPoints = new HashMap<Point, Integer>();
		
		Point nextMove = new Point();
		
		// Get all points where tiles are empty
		for(int row = 0; row < 11; row++)
		{
			for(int col = 0; col < 11; col++)
			{
				Point point = new Point(row, col);
				
				if(board.isEmpty(point))
				{
					allPoints.put(point, getPoints(point));
				}
			}
		}
		
		int maxPoints = 0;
		
		// Get position with highest points
		for(Map.Entry<Point, Integer> entry : allPoints.entrySet())
		{
		    Point key = entry.getKey();
		    Integer value = entry.getValue();

		    if(value > maxPoints)
		    {
		    	maxPoints = value;
		    	nextMove = key;
		    }
		}
		
		return nextMove;
	}
}
