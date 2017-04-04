import java.io.*;

public class BufferedWriterReader
{
    public static void main( String[] args ) throws IOException
    {
        //Sposób1
        int bufferWriterSize = 8 * 1024;
        BufferedWriter bufferedWriter1 = new BufferedWriter( new FileWriter( "example1.txt" ), bufferWriterSize );

        bufferedWriter1.write( "Example1 Line1" );
        bufferedWriter1.newLine();
        bufferedWriter1.write( "Example1 Line2" );
        bufferedWriter1.close();

        //Sposób2
        FileWriter output = new FileWriter( "example2.txt" );
        try ( BufferedWriter bufferedWriter2 = new BufferedWriter( output ) )
        {
            bufferedWriter2.write( "Example2 Line1" );
            bufferedWriter2.write( "Example2 Line2" );
        }


        //Sposób1
        int bufferReaderSize = 8 * 1024;
        BufferedReader bufferedReader1 = new BufferedReader( new FileReader( "example1.txt" ), bufferReaderSize );

        String line1 = bufferedReader1.readLine();
        if ( line1 != null )
            System.out.println( line1 );
        bufferedReader1.close();
        System.out.println("");

        //Sposób2
        Reader reader = new FileReader( "example2.txt" );
        try ( BufferedReader bufferedReader2 = new BufferedReader( reader ) )
        {
            String line2 = bufferedReader2.readLine();
            while ( line2 != null )
            {
                System.out.println(line2);
                line2 = bufferedReader2.readLine();
            }
        }
    }
}
