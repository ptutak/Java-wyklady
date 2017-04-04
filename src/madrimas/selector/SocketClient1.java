package madrimas.selector;

import java.nio.channels.SocketChannel;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class SocketClient1 {

	public static void main (String [] args)
			throws IOException, InterruptedException {

		InetSocketAddress hostAddress = new InetSocketAddress("localhost", 5454);
		SocketChannel client = SocketChannel.open(hostAddress);

		System.out.println("Client1 sending messages to server...");

		// Send messages to server
		
		String [] messages = new String [] {"Time goes fast.", "What now?", "Bye."};

		for (int i = 0; i < messages.length; i++) {

			byte [] message = new String(messages [i]).getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(message);
			client.write(buffer);

			System.out.println(messages [i]);
			buffer.clear();
			Thread.sleep(5000);
		}

		client.close();		
	}
}
