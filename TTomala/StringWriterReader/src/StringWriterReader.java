import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringWriterReader
{
    public static void main( String[] args ) throws IOException
    {
        //Sposób 1
        StringWriter stringWriter1 = new StringWriter();

        stringWriter1.write( "Example text1" );
        String data1 = stringWriter1.toString();
        System.out.println( data1 );
        //stringWriter1.close();

        //Sposób2
        try ( StringWriter stringWriter2 = new StringWriter() )
        {
            stringWriter2.write( "Example text2" );

            String data2 = stringWriter2.toString();
            System.out.println( data2 );
        }
        System.out.println("");



        //Sposób1
        String input1 = "Input String1";
        StringReader stringReader1 = new StringReader( input1 );

        int data3 = stringReader1.read();
        String s1 = "";
        while ( data3 != -1 )
        {
            s1 += ( char ) data3;
            data3 = stringReader1.read();
        }
        System.out.println( s1 );
        stringReader1.close();

        //Sposób2
        String input2 = "Input String2";
        String s2 = "";
        try ( StringReader stringReader2 = new StringReader(input2) )
        {
            int data4 = stringReader2.read();
            while ( data4 != -1 )
            {
                s2 += ( char ) data4;
                data4 = stringReader2.read();
            }
            System.out.println( s2 );
        }
    }
}
