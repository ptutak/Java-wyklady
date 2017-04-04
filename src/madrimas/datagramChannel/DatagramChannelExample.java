package madrimas.datagramChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by madrimas on 03.04.2017.
 */
public class DatagramChannelExample {
    public static void main(String[] args) {
        try{
           // while(true) {
                DatagramChannel channel = DatagramChannel.open();
                channel.socket().bind(new InetSocketAddress(80));

            String newData = "New String to write to file..."
                    + System.currentTimeMillis();

            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());
            buf.flip();

            int bytesSent = channel.send(buf, new InetSocketAddress("localhost", 80));

            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();

            channel.receive(buffer);
            String output = new String(buffer.array()).trim();
            System.out.println(output);

           // channel.connect(new InetSocketAddress("localhost", 80));

           // int bytesRead = channel.read(buf);

           // int bytesWritten = channel.write(buf);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
