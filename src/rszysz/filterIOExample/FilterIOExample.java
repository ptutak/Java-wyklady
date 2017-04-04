/*
 * Copyright (C) 2017 Szysz
 */
package filterIOExample;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/**
 *
 * @author Szysz
 */
public class FilterIOExample {
    
    public static void main(String[] args) throws Exception {
      
        FileInputStream is = null; 
        FilterInputStream fis = null;
            
        try
        {
         
            is = new FileInputStream("data.txt");
            fis = new BufferedInputStream(is);
         
            int r;
            System.out.println();
            while ((r = fis.read()) != -1)
            {
                System.out.print((char)r);
            }    
            System.out.println();
        }
        catch(IOException e)
        {         
           System.out.println(e);
        }
        finally
        {         
            if(is!=null)
                is.close();
            if(fis!=null)
                fis.close();
        }
        
        /************************************************************************/
        
//       FileInputStream is2 = null;
//       FilterInputStream fis2 = null; 
//       FileOutputStream fos = null;
//       FilterOutputStream fltros = null;		
//       try{
//            fos = new FileOutputStream("xyz.txt");              
//            fltros = new FilterOutputStream(fos);
//        
//            System.out.println();
//            System.out.println("Zapisywanie bajtow do pliku xyz.txt......");
//            System.out.println();
//            fltros.write(73);
//            fltros.write(83);
//            fltros.write(32);
//            fltros.write(87);
//            fltros.write(73);
//            fltros.write(77);
//            fltros.write(105);
//            fltros.write(73);
//            fltros.write(80);
//            System.out.println();
//            System.out.println("******* Zawartosc zostala zapisana do pliku xyz.txt ***********");
//            System.out.println();
//        
//            is2 = new FileInputStream("xyz.txt");
//            fis2 = new BufferedInputStream(is2);
//            System.out.println("Czytanie z pliku xyz.txt.......");
//            System.out.println();
//            int r;
//            while((r= fis2.read()) != -1){
//                System.out.print((char)r);
//            }
//            System.out.println();
//        }
//        catch(IOException e){
//            System.out.println("IOException caught..!!");
//            e.printStackTrace();
//        }
//	finally{
//	    if(is2 != null){
//	        try{
//	            is2.close();
//	        }
//	        catch (IOException ioe){
//                    System.out.println(ioe);
//	         }
//            }
//	    if(fltros != null){
//                try{
//                    fltros.close();
//                    }
//                    catch(IOException ie){
//                        System.out.println(ie);
//                    }
//            }
//	    if(fis2 != null){
//                try
//                {
//                    fis2.close();
//                }
//                catch(IOException iex){
//		     System.out.println(iex);
//                }
//            }
//	    if(fos != null){
//                try{
//                    fos.close();
//                }
//                catch(IOException iex1){
//		    System.out.println(iex1);
//                }
//            }  
//        }
        
   }
    
}
