package piotr_tutak;

import java.io.IOException;

public class InOutErr {

	public static void main(String[] args) {
		// System.out - podstawowy strumie� PrintStream - standardowe wyj�cie - konsola / ekran:
		
		System.out.println("Cze��!!!");
		
		// System.in - podstawowy strumie� InputStream - standardowe wej�cie - klawiatura 
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
		
		// System.err - podstawowy strumie� b��d�w PrintStream - standardowe wyj�cie b��d�w:
		
		byte[] inputerr=null;
		
		try {
			System.in.read(inputerr);
		} catch (Exception e) {
			System.err.println("Z�apa�em wyjatek, wyrzucam na System.err");
			System.err.print(e.toString());
		}
	}

}
