import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) throws Exception{

		//reading the input from console
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = input.readLine();

		//socket
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress ipAdd = InetAddress.getByName("localhost");

		//to send the data in packets
		byte[] output = new byte[1024];
		output = str.getBytes();

		//received data
		byte[] in = new byte[1024];


		DatagramPacket packet = new DatagramPacket(output, output.length, ipAdd, 1234);

		clientSocket.send(packet);

		DatagramPacket packetRcd = new DatagramPacket(in, in.length);
		clientSocket.receive(packetRcd);
		String received_str = new String(packetRcd.getData());
		System.out.println(received_str);
		clientSocket.close();
	}

}
