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
		    say("remaining :" + b.remaining()); //Metoda remaining() zwraca liczbê elementów znajduj¹cych siê pomiêdzy pozycj¹ a limitem.
	 }

	public static void main(String[] args)
	{
		// alokacja bufora 10 bajtowego (inicjalnie waroœci elementów = 0)
	    ByteBuffer b = ByteBuffer.allocate(10);
	    showParms("Po utworzeniu", b);

	    // Zapis dwóch bajtów do bufora
	    b.put((byte) 7).put((byte) 9);
	    showParms("Po dodaniu dwóch elementów", b);

	    // Przestawienie bufora
	    b.flip();
	    showParms("Po przestawieniu", b);

	    // Teraz mo¿emy czytaæ wpisane dane
	    say("Czytamy pierwszy element: " + b.get());
	    showParms("Po pobraniu pierwszego elementu", b);
	    say("Czytamy drugi element: " + b.get());
	    showParms("Po pobraniu drugiego elementu", b);

	    say("Czy mo¿emy jeszcze czytaæ?");
	    try {
	      byte x = b.get();
	    } catch (BufferUnderflowException exc) {					// Wyjatek wyrzucany jeœli chcemy odczytac cos poza limitem
	       say("No, nie - proszê spojrzeæ na ostatni limit!");
	    }

	    // Jeszcze raz odczytajmy dane z bufora
	    // w tym celu musimy go przewin¹æ
	    b.rewind();													// Przewijanie po odczytaniu bufora 
	    showParms("Po przewiniêciu", b);

	    say("Czytanie wszystkiego, co wpisaliœmy");
	    while (b.hasRemaining()) //Metoda hasRemaining() zwraca true, jeœli liczba jest wiêksza od 0.
	      say("Jest: " + b.get());

	}
	
	//**************************************************************************************************************************
	
//	 //Tworzymy kilka buforów
	
//	 ByteBuffer header = ByteBuffer.allocate(128);
//	 ByteBuffer body = ByteBuffer.allocate(1024);
//	 ByteBuffer ps = ByteBuffer.allocate(1024);
//	 
//	 //bufory s¹ wstawiane do tablicy, a nastêpnie tablica przekazana jako parametr do metody channel.read()
	
//	 ByteBuffer[] bufferArray = { header, body , ps };
//
//	// jedno czytanie z kana³u zapisuje kilka buforów !
	
//	 channel.read(bufferArray);
//	 channel.write(bufferArray);
}
