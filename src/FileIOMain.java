import java.io.*;


public class FileIOMain {
    public static void main(String args[]){

        //FileOutputStream PrintStream
        try{
            FileOutputStream fout=new FileOutputStream("test1.txt");
            fout.write(65); //A


            byte[] tab = new byte[3];
            tab[0] = 'B';
            tab[1] = 'C';
            tab[2] = 'D';
            fout.write(tab);


          //PrintStream
            PrintStream pout=new PrintStream(fout);
            pout.println(2017);
            pout.println("Hello Java");

            pout.close();

            fout.close();
            System.out.println("Success?");

        }catch(Exception e){System.out.println(e);}

       //FileInputStream

        try{
            FileInputStream fin=new FileInputStream("test1.txt");

            byte[] tab = new byte[3];
            fin.read(tab);
            for (int j = 0; j<tab.length ; j++)
            {
                System.out.println((char)tab[j]);
            }

            int byte1=fin.read();
            System.out.println("FileInputStream : "+byte1);


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
            writer1.write("ABC");
            writer1.flush();
            writer1.close();
        }catch(IOException ex) {System.out.printf("Error : %s\n", ex);}

    }
}
