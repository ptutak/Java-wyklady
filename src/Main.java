import java.io.*;

/**
 * Created by Piotruś on 2017-04-03.
 */
public class Main {
    public static void main(String args[]){

        //FileOutputStream PrintStream
        try{
            FileOutputStream fout=new FileOutputStream("test1.txt");
            fout.write(65);

            PrintStream pout=new PrintStream(fout);
            pout.println(2017);
            pout.println("Hello Java");
            pout.println("next line");
            pout.close();

            fout.close();
            System.out.println("Success?");

        }catch(Exception e){System.out.println(e);}

       //FileInputStream

        try{
            FileInputStream fin=new FileInputStream("test1.txt");
            int i=fin.read();
            System.out.println("FileInputStream : "+(char)i);

            fin.close();
        }catch(Exception e){System.out.println(e);}

        //PrintWriter
        try{
            PrintWriter writer = new PrintWriter(System.out);
            writer.write("Hello from writer.");
            writer.flush();
            writer.close();

            PrintWriter writer1 =null;
            writer1 = new PrintWriter(new File("test3.txt"));
            writer1.write("Hello from writer in file.");
            writer1.flush();
            writer1.close();
        }catch(IOException ex) {System.out.printf("Error : %s\n", ex);}

    }
}
