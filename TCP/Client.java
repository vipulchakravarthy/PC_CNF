import java.io.*;
import java.net.*;


public class Client{

	public static void main(String[] args) throws Exception{
		Client myCLi = new Client();

		myCLi.run();
	}

	public void run() throws Exception{
		Socket myskt = new Socket("localhost", 9999);
		PrintStream myPS = new PrintStream(myskt.getOutputStream());
		myPS.println("2019501128");

		BufferedReader br = new BufferedReader(new InputStreamReader(myskt.getInputStream()));

		String temp = br.readLine();
		System.out.println(temp);
	}
}
