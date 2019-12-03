import java.io.*;
import java.net.*;

public class Server{


	public static void main(String[] args) throws Exception{
		Server myServ = new Server();
		myServ.run();
	}

	public void run() throws Exception {
		ServerSocket mySS = new ServerSocket(9999);
		Socket ss_accept = mySS.accept();
		System.out.println("Connection established");

		// Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(ss_accept.getInputStream()));

		String temp = br.readLine();

		System.out.println(temp);


		PrintStream ssps = new PrintStream(ss_accept.getOutputStream());
		ssps.println("Hello from server side---succesful Connection");
	}
}
