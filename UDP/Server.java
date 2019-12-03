import java.io.*;
import java.net.*;

public class Server{

	public static void main(String[] args) throws Exception{
		DatagramSocket serverSocket = new DatagramSocket(1234);
		byte[] input = new byte[1024];
		BufferedReader serverData = new BufferedReader(new InputStreamReader(System.in));
		InetAddress ipAdd = InetAddress.getByName("localhost");
		byte[] output = new byte[1024];
		while(true){
			DatagramPacket packetRcd = new DatagramPacket(input, input.length);
			serverSocket.receive(packetRcd);

			InetAddress clientIp = packetRcd.getAddress();
			int port = packetRcd.getPort();

			String str = new String(packetRcd.getData());
			System.out.println(str);

			String send_str = serverData.readLine();
			output = send_str.getBytes();
			DatagramPacket packet3 = new DatagramPacket(output, output.length, clientIp, port);

			serverSocket.send(packet3);
 		}
	}
}
