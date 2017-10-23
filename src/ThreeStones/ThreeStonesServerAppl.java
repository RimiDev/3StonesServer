package ThreeStones;

import java.io.IOException;

public class ThreeStonesServerAppl {
	
	public static void main(String[] args) throws IOException
	{
		ThreeStonesServer server = new ThreeStonesServer(50000);
		
		server.runServer();
	}

}
