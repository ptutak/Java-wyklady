/*
 * Copyright (C) 2017 Szysz
 */
package byteArrayIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author Szysz
 */
public class ByteArrayIOStreamExample {
    
    
    public static void main(String[] args) throws IOException{
    
        
        
        byte[] bytes = new byte[10];
        for(int i = 0; i<10;i++)
            bytes[i] = (byte) i;
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);

        int data = input.read();
        while(data != -1) {
            System.out.println(data);
            data = input.read();
        }
        input.close();
        
        /***************************************************************/
        
        System.out.println("\n");
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        output.write(20);
        output.write(15);
        
        bytes = output.toByteArray();
        
        for(byte a : bytes)
            System.out.println(a);
        
    }
    
}
