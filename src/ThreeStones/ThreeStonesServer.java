package ThreeStones;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreeStonesServer {
	
	private int port;
	
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private Socket clientSocket;
	
	public ThreeStonesServer(int port)
	{
		this.port = port;
	}

	public void runServer() throws IOException
	{	
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("IP address of server: " + serverSocket.getInetAddress().getHostAddress());
		
		for(;;)
		{
			clientSocket = serverSocket.accept();
			System.out.println("Handling client at " + clientSocket.getInetAddress().getHostAddress() + " on port " + clientSocket.getPort());
			
			ThreeStonesServerSession session = new ThreeStonesServerSession();
			session.playSession(clientSocket);
		}
	}

}
