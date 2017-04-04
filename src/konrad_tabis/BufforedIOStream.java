import java.io.*;

/**
 * Created by Dell on 03.04.2017.
 */
public class BufforedIOStream {
    public static void main(String[] args) throws IOException {
        //BufforedOutputStream
        FileOutputStream fileOutputStream=new FileOutputStream("testout2.txt");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);

        String s="Welcome to javaTpoint.";
        byte b[]=s.getBytes();

        bufferedOutputStream.write(b);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        fileOutputStream.close();
        System.out.println("success");


        //FileInputStream
        try{
            FileInputStream fileInputStream=new FileInputStream("testout2.txt");
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);

            int i;
            while((i=bufferedInputStream.read())!=-1){
                System.out.print((char)i);
            }
            bufferedInputStream.close();
            fileInputStream.close();
        }catch(Exception e){System.out.println(e);}
    }

}
