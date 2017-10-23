
public class app {

	public static void main(String[] args)
	{
		GameBoard b = new GameBoard("./src/ThreeStonesBoard.csv");
		
		System.out.println(b.getTile(2, 1));
	}
}
