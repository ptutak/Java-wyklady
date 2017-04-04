package serverSocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by madrimas on 03.04.2017.
 */
public class ServerSocketChannelExample {

    public static void main(String[] args) {
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.socket().bind(new InetSocketAddress(5454));

            while (true) {
                SocketChannel socketChannel =
                        serverSocketChannel.accept();

                System.out.println("Nadeszło połączenie!");

                //do something with socketChannel...
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
