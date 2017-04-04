package datagramChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by madrimas on 03.04.2017.
 */
public class SocketClient3 {
    public static void main(String[] args) throws IOException {

        DatagramChannel channel = DatagramChannel.open();
        //channel.socket().bind(new InetSocketAddress(80));

        String newData = "New String to write to file..."
                + System.currentTimeMillis();

        String test = "test";
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(test.getBytes());
        buf.flip();

        int bytesSent = channel.send(buf, new InetSocketAddress("localhost", 80));

    }
}
