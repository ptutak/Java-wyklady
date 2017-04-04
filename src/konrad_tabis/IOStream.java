import java.io.*;

/**
 * Created by Dell on 03.04.2017.
 */

public class IOStream
{
    public static void main(String[] args) throws IOException {

        //DataInputStream
        InputStream input = new FileInputStream("testout.txt");
        DataInputStream dataInputStream = new DataInputStream(input);
        int count = input.available();

        byte[] arr = new byte[count];
        if(count>90) {
            dataInputStream.read(arr, 0, 91);
        }

        dataInputStream.skipBytes(10);
        for(int i=101,j=91;i<count;i++,j++) {
            arr[j]= dataInputStream.readByte();
        }

        for (byte bt : arr) {
            char k = (char) bt;
            System.out.print(k);
        }

        //DataOutputStream
        FileOutputStream file = new FileOutputStream("testout1.txt");
        DataOutputStream data = new DataOutputStream(file);

        try {
            data.writeInt(65);
            data.writeChar('C');
            System.out.println("\n\n\ndotychczas wczytano "+data.size()+" bajtów");
            data.flush();
        }finally{
            data.close();
        }
        System.out.println("Succcess...");


    }
}
