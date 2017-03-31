package kamil_stachowicz;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created by staho on 30.03.2017.
 */
public class mainClass {
    public static void main(String[] args) {
        try {
                //Socket channel is a channel that connects to TCP network socket.

            SocketChannel socketChannel = SocketChannel.open();

                /* Są dwa sposoby na otwarcie SocketChannel
                 * pierwszym jest podłączenie się do strony internetowej
                 * drugim jest podłączenie się do połączenia z ServerSocketChannel
                 */

            socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
                /*
                 * W tym momencie podłączamy się do strony internetowej na porcie 80
                 */

        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
