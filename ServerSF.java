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

		try{

		SS_accept.configureBlocking(false);
		SS_accept.setOption(StandardSocketOptions.TCP_NODELAY,PropertiesReader.getTCPNoDelay());
		SS_accept.setOption(StandardSocketOptions.SO_SNDBUF, PropertiesReader.getSoSndBuf());
		SS_accept.setOption(StandardSocketOptions.SO_RCVBUF, PropertiesReader.getSoRcvBuf());
		SS_accept.setOption(StandardSocketOptions.SO_KEEPALIVE,PropertiesReader.getKeepAlive());
		SS_accept.setOptions(StandardSocketOptions.SO_REUSEADDR,PropertiesReader.getReuseAddress());
		SS_accept.setOptions(StandardSocketOptions.IP_TOS, PropertiesReader.getIPTos());

		SS_accept.register(selector,selectionKey.OP_READ);

		}
		BufferedReader SS_BF = new BufferedReader(new InputStreamReader(SS_accept.getInputStream()));
		
		String temp = SS_BF.readLine();
		System.out.println(temp);

		if(temp != null) {

			PrintStream SSPS = new PrintStream(SS_accept.getOutputStream());
			SSPS.println("Have something");
		}
	}
}
 
