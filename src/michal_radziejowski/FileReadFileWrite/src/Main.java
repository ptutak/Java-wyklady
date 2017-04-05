import java.io.FileWriter;
import java.io.FileReader;

public class Main {

    public static void main(String[] args)throws Exception{
        try{
            FileWriter fw=new FileWriter("D:\\java.txt");
            fw.write("Odczyt udany");
            fw.close();
        }catch(Exception e)
        {System.out.println(e);}

        System.out.println("Zapis Udany");

        FileReader fr=new FileReader("D:\\java.txt");
        int i;
        while((i=fr.read())!=-1)
            System.out.print((char)i);
        fr.close();
    }

}

