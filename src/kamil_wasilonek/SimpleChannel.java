import java.nio.*;
import java.nio.channels.FileChannel;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.FileInputStream;  
import java.nio.ByteBuffer;  
import java.nio.channels.FileChannel;  
import java.nio.channels.ScatteringByteChannel;  
import java.nio.channels.GatheringByteChannel;  

public class SimpleChannel
{
	  String fname = "test.tmp";
	  byte[] data = {1,2,3,4,5};

	  
	  void writeChannel(String fname, byte[] data) throws Exception
	  {

	    // Mo�emy utworzy� bufor przez opakowanie istniej�cej tablicy
	    ByteBuffer buf = ByteBuffer.wrap(data);

	    FileOutputStream out = new FileOutputStream(fname);          // Uzyskanie kana�u klasy FileChannel "do zapisu"

	    // Uzyakanie kana�u
	    FileChannel fc = out.getChannel();

	    //Zapis
	    fc.write(buf);
	    fc.close();
	  }

	  byte[] readChannel(String fname) throws Exception
	  {


	    // Stworzenie strumienia na podstawie obiektu klasy File
	    FileInputStream in = new FileInputStream(fname);         // Uzyskanie kana�u klasy FileChannel "do odczytu"

	    // Uzyskanie kana�u
	    FileChannel fc = in.getChannel();

	    // Metoda size() z klasy FileChannel
	    // zwraca long -rozmiar plku, do kt�rego podl�czony jest kana�
	    int size = (int) fc.size();

	    // Utworzenie bufora
	    ByteBuffer buf = ByteBuffer.allocate(size);

	    // Czytanie do bufora
	    // nbytes - liczba przeczytanych bajt�w
	    int nbytes = fc.read(buf);
	    fc.close();

	    // Po przeczytaniu danych musimy bufor przestawi�
	    buf.flip();

	    // Stworzenie tablicy na wynik czytania
	    // jej rozmiar b�dzie okre�lony przez liczb� przeczytanych bajt�w
	    // kt�r� mo�emy poda� na dwa sposoby: poprzednie nbytes
	    // lub uzyskuj�c informacj� o liczbie jeszcze nieodczytanych bajt�w z bufora

	    byte[] wynik = new byte[buf.remaining()];
	    buf.get(wynik);
	    return wynik;
	  }
	  
	  SimpleChannel()
	  {
	    try 
	    {
	      writeChannel(fname, data);
	      byte[] wynik = readChannel(fname);
	      for (int i=0; i < wynik.length; i++) System.out.println(wynik[i]);
	    } 
	    
	    catch(Exception exc)
	    {
	        exc.printStackTrace();
	        System.exit(1);
	    }
	  }
	 
	  
	  public static void main(String args[])
	  {
	   new SimpleChannel();
	  }

}
