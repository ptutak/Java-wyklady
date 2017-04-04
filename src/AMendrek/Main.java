package AMendrek;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * Created by Ola on 04.04.2017.
 */
public class Main {
    public static void main(String[] args) {

        char [] chars="Java - wyklad z IO".toCharArray(); //konwersja string-charArray
        char [] chars1=null;


        try(CharArrayWriter myWriter = new CharArrayWriter();) {

            CharArrayReader myReader=new CharArrayReader(chars); //tworzenie obiektu klasy, z tablicą charów jako argumentem konstruktora

            int data=1;
            while(data!=-1) {
                data = myReader.read(); //czytanie znakow od drugiego
                myWriter.write((char)data);
            }

            //myWriter.write(data);

            chars1 = myWriter.toCharArray(); //konwersja stringa do char array


            myReader.close(); //zamkniecie strumienia - nie jest potrzebne, jezeli ten plik nie odnosi sie do polaczen sieciowych lub systemowych
        }
        catch(IOException e) {
            System.out.println(e);
        }

        System.out.println(chars1);


        // poprzez uzywanie bloku try-catch, try zadba o zamkniecie strumienia Writera


    }

}
