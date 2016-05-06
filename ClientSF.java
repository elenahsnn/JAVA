import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	
	public static void main(String[] args) throws Exception {
		
	}

	public void run() throws Exception {
	
	Socket mySocket = new Socket("localhost", 9999);

	SocketChannel sock = SocketChannel.open();
	sock.setOption(StandardSocketOptions.TCP_NODELAY, true);
	sock.setOption(StandardSocketOptions.SO_LINGER, 240);
	sock.setOption(StandardSocketOptions.SO_TIMEOUT, 180000);
	sock.setOption(StandardSocketOptions.SO_RCVBUF, 1024);
	sock.setOption(StandardSocketOptions.SO_SNDBUF, 1024);
	sock.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
	sock.setOption(StandardSocketOptions.OOBINLINE, true);
	sock.setOption(StandardSocketOptions.SO_REUSEADDR, true);
	sock.setOption(StandardSocketOptions.IP_TOS, true);

	System.out.println("Hello server");

	BufferedReader myBR = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));

	String temp = myBR.readLine();
	System.out.println(temp);
	}
}}
}
