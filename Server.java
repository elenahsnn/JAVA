import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) throws Exception {
		Server myServer = new Server();
		myServer.run();
	}

	public void run() throws Exception {
		
		ServerSocket SS = new ServerSocket(9999);
		Socket SS_accept = SS.accept();

		BufferedReader SS_BF = new BufferedReader(new InputStreamReader(SS_accept.getInputStream()));
		
		String temp = SS_BF.readLine();
		System.out.println(temp);

		if(temp != null) {

			PrintStream SSPS = new PrintStream(SS_accept.getOutputStream());
			SSPS.println("Have something");
		}
	}
}
