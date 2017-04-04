import java.nio.*;
import java.nio.channels.FileChannel;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.FileInputStream;  
import java.nio.ByteBuffer;  
import java.nio.channels.FileChannel;  
import java.nio.channels.ScatteringByteChannel;  
import java.nio.channels.GatheringByteChannel;  

public class Buffor
{
	 static void say(String s)
	 {
		 System.out.println(s);
	 }
	
	 static void showParms(String msg, Buffer b)
	 {
		    say("Charakterystyki bufora - " + msg);
		    say("capacity  :" + b.capacity());
		    say("limit     :" + b.limit());
		    say("position  :" + b.position());
		    say("remaining :" + b.remaining()); //Metoda remaining() zwraca liczb� element�w znajduj�cych si� pomi�dzy pozycj� a limitem.
	 }

	public static void main(String[] args)
	{
		// alokacja bufora 10 bajtowego (inicjalnie waro�ci element�w = 0)
	    ByteBuffer b = ByteBuffer.allocate(10);
	    showParms("Po utworzeniu", b);

	    // Zapis dw�ch bajt�w do bufora
	    b.put((byte) 7).put((byte) 9);
	    showParms("Po dodaniu dw�ch element�w", b);

	    // Przestawienie bufora
	    b.flip();
	    showParms("Po przestawieniu", b);

	    // Teraz mo�emy czyta� wpisane dane
	    say("Czytamy pierwszy element: " + b.get());
	    showParms("Po pobraniu pierwszego elementu", b);
	    say("Czytamy drugi element: " + b.get());
	    showParms("Po pobraniu drugiego elementu", b);

	    say("Czy mo�emy jeszcze czyta�?");
	    try {
	      byte x = b.get();
	    } catch (BufferUnderflowException exc) {					// Wyjatek wyrzucany je�li chcemy odczytac cos poza limitem
	       say("No, nie - prosz� spojrze� na ostatni limit!");
	    }

	    // Jeszcze raz odczytajmy dane z bufora
	    // w tym celu musimy go przewin��
	    b.rewind();													// Przewijanie po odczytaniu bufora 
	    showParms("Po przewini�ciu", b);

	    say("Czytanie wszystkiego, co wpisali�my");
	    while (b.hasRemaining()) //Metoda hasRemaining() zwraca true, je�li liczba jest wi�ksza od 0.
	      say("Jest: " + b.get());

	}
	
	//**************************************************************************************************************************
	
//	 //Tworzymy kilka bufor�w
	
//	 ByteBuffer header = ByteBuffer.allocate(128);
//	 ByteBuffer body = ByteBuffer.allocate(1024);
//	 ByteBuffer ps = ByteBuffer.allocate(1024);
//	 
//	 //bufory s� wstawiane do tablicy, a nast�pnie tablica przekazana jako parametr do metody channel.read()
	
//	 ByteBuffer[] bufferArray = { header, body , ps };
//
//	// jedno czytanie z kana�u zapisuje kilka bufor�w !
	
//	 channel.read(bufferArray);
//	 channel.write(bufferArray);
}
