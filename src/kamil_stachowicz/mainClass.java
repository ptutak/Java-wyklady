package kamil_stachowicz;

import com.sun.xml.internal.bind.v2.TODO;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;
import java.nio.file.*;

/**
 * Created by staho on 30.03.2017.
 */
public class mainClass {
    public static void main(String[] args) {
        try {
            //Path
                String pathToChromeXML = "C:\\Program Files\\..\\Program Files (x86)\\.\\Google\\Chrome\\Application\\SetupMetrics\\..\\chrome.VisualElementsManifest.xml";
                Path path = Paths.get(pathToChromeXML);

                System.out.println("Path1: " + path);

                Path path1 = path.normalize();
                System.out.println("Path1(normalized): " + path1);


                Path windows = Paths.get("C:\\Windows", "System32");
                System.out.println("Path to system32: " + windows);


                Path currentDir = Paths.get(".");
                System.out.println("Current directory: " + currentDir.toAbsolutePath());


                Path parentDirectory = Paths.get("..");
                System.out.println("Parent directory from current is: " + parentDirectory.toAbsolutePath());


            //Files
            System.out.println("Czy istnieje plik \"README.md\" w folderze projektu?");
            Path pathToReadme = Paths.get(".\\README.md");


            boolean pathToReadmeExist = Files.exists(pathToReadme, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            //ta opcja oznacza że files.exists nie powinno rozpatrywać "symbolic links" żeby określić ścieżkę

            if(pathToReadmeExist)
               System.out.println("Plik readme.md istnieje");
            else System.out.println("Plik readme nie istnieje");


            Path pathToWazneRzeczyFolder = Paths.get(".\\src\\kamil_stachowicz\\wazneRzeczy");

            //tworzenie nowego folderu
            Path newDir = Files.createDirectory(pathToWazneRzeczyFolder);

            //skopiujmy wazne rzeczy bo są ważne
            //skorzystamy z ścieżki do naszego pliku i wyznaczymy mu nową nazwę
            Path destinationPath = Paths.get(".\\src\\kamil_stachowicz\\wazneRzeczyKopia");
            Files.copy(newDir, destinationPath);

            Path pathToList = Paths.get(".\\src\\kamil_stachowicz\\Lista.txt");

            Path pathToWazneRzeczyLista = Paths.get(".\\src\\kamil_stachowicz\\wazneRzeczy\\Lista.txt");

            //kopiujemy liste do waznych rzeczy
            //opcja kopiowania pozwala na zastępowanie obecnych plików
            Files.copy(pathToList, pathToWazneRzeczyLista, StandardCopyOption.REPLACE_EXISTING);

            //Przeniesmy jeszcze listę do kopii zapasowej
            Path destinationForListPath = Paths.get(".\\src\\kamil_stachowicz\\wazneRzeczyKopia\\Lista.txt");
            Files.move(pathToWazneRzeczyLista, destinationForListPath, StandardCopyOption.REPLACE_EXISTING);

            //mimo wszystko kopia listy nam jest zbędna, uwsuwamy ją
            Files.delete(destinationForListPath);

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
        catch(IOException e){
            e.printStackTrace();
        }
        catch (UnresolvedAddressException x){
            x.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
