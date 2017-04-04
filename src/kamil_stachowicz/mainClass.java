package kamil_stachowicz;

import com.sun.xml.internal.bind.v2.TODO;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by staho on 30.03.2017.
 */
public class mainClass {
    public static void main(String[] args) {
        try {
            /*//Socket channel is a channel that connects to TCP network socket.

            SocketAddress address = new InetSocketAddress("localhost",5454);
            *//* tworzymy klasę z adresem socketu,
             * niezbędny do tego jest poprawny adres Inet
             * oraz port na którym program ma nasłuchiwać
             *//*
            // TODO: 31.03.2017   Poprawić opisy

            SocketChannel socketChannel = SocketChannel.open();

                *//* Są dwa sposoby na otwarcie SocketChannel
                 * pierwszym jest podłączenie się do strony internetowej
                 * drugim jest podłączenie się do połączenia z ServerSocketChannel
                 *//*


            socketChannel.connect(address);
                *//*
                 * W tym momencie podłączamy się do serwera na laptopie który się kryje pod adresem
                 *
                 * Następną rzeczą jest zapisanie danych do bufera
                 *//*
            ByteBuffer buffer = ByteBuffer.allocate(255);
                // alokacja bufera na dane bitowe

            int bytesRead = socketChannel.read(buffer);
                // funkcja read wczytuje do bufera

            String result = new String(buffer.array()).trim();

                //Dane z buffera wrzucane są do stringa

            System.out.println("Wczytano " + bytesRead + " bajtow");
            System.out.println(result);

            socketChannel.close();
            //zamknięcie kanału
*/
            {
                //Pipe

                Pipe pipe = Pipe.open();
                //stworzenie pipe

                Pipe.SinkChannel sinkChannel = pipe.sink();
                //sink channel jest to kanał który będzie przyjmował dane

                String message = "Dzien dobry";

                ByteBuffer buffer1 = ByteBuffer.allocate(48);
                // alokacja bufferu na dane bitowe

                buffer1.clear();
                buffer1.put(message.getBytes());
                //do buferu przepisuję dane ze string w formie bitowej

                buffer1.flip();
                //flip służy do zmiany bufferu z zapisu do odczytu (i na odwrót)

                while (buffer1.hasRemaining()) sinkChannel.write(buffer1);
                //wrzucanie danych z bufferu do sinkChannelu pipe

                Pipe.SourceChannel sourceChannel = pipe.source();
            /*
             * source channel jest przeciwieństwem sinkChannelu
             * służy do pobierania danych z pipe
             */
                ByteBuffer buffer2 = ByteBuffer.allocate(48);

                while (sourceChannel.read(buffer2) > 0) {
                    //odczyt danych z pipe do buferu
                    buffer2.flip();
                    // do buferu zostały wpisane dane, należy je teraz z niego pobrać, tak więc znowu zmieniamy jego tryb

                    while (buffer2.hasRemaining()) {
                        char ch = (char) buffer2.get();
                        System.out.print(ch);
                    }
                    System.out.println("");
                    //wypisywanie danych na ekran

                    buffer2.clear();
                }
            }

            //Path
            {
                Path path = Paths.get("/Users/staho/Documents/Project/JavaFX-wyklady/README.md");
                
            }

        }
        catch (UnresolvedAddressException x){
            x.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
