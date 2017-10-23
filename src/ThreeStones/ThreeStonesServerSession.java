package ThreeStones;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ThreeStonesServerSession {
	private boolean playAgain;
	private boolean gameOver;
	
	public ThreeStonesServerSession()
	{
		playAgain = true;
		gameOver = false;
	}
	
	public void playSession(Socket clientSocket) throws IOException
	{
		int messageSize;
		byte[] byteBuffer = new byte[32];
		
		while(playAgain)
		{
			while(!gameOver)
			{
				InputStream in = clientSocket.getInputStream();
				OutputStream out = clientSocket.getOutputStream();

				// Receive until client closes connection, indicated by -1 return
				while ((messageSize = in.read(byteBuffer)) != -1)
					out.write(byteBuffer, 0	, messageSize);

				System.out.println("byteBuffer: " + new String(byteBuffer));
				
				
				clientSocket.close();						// Close the socket. This client is finished.
				System.out.println("Client socket has been closed");
				
				// Change this later
				playAgain = false;
				gameOver = false;
			}
		}
	}

}
