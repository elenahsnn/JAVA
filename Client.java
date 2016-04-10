import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	
	public static void main(String[] args) throws Exception {
		
		Client myClient = new Client();
		myClient.run();
	}

	public void run() throws Exception {
	
	Socket mySocket = new Socket("localhost", 9999);
	//PrintStream PS = new PrintSream(mySocket.getOutputStream());
	
	System.out.println("Hello server");

	BufferedReader myBR = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));

	String temp = myBR.readLine();
	System.out.println(temp);
	}
}
