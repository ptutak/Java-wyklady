package piotr_tutak;

import java.io.IOException;

public class InOutErr {

	public static void main(String[] args) {
		// System.out - podstawowy strumieñ PrintStream - standardowe wyjœcie - konsola / ekran:
		
		System.out.println("Czeœæ!!!");
		
		// System.in - podstawowy strumieñ InputStream - standardowe wejœcie - klawiatura 
		byte[] input=new byte[20];
		try {
			System.in.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.write(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// System.err - podstawowy strumieñ b³êdów PrintStream - standardowe wyjœcie b³êdów:
		
		byte[] inputerr=null;
		
		try {
			System.in.read(inputerr);
		} catch (Exception e) {
			System.err.println("Z³apa³em wyjatek, wyrzucam na System.err");
			System.err.print(e.toString());
		}
	}

}
