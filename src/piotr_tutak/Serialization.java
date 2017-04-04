package piotr_tutak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;  

class Student implements Serializable {
	//TODO: Dodaæ UID
	int id;  
	String name;
	// S³ówko kluczowe "transient" sprawia, ¿e dane pole nie jest serializowane.
	// transient int age;
	public Student(int id, String name) {  
		this.id = id;  
		this.name = name;
		//this.age=age;
	}  
}  


public class Serialization {

	public static void main(String[] args) {
		Student s1 =new Student(100,"ptutak");
		try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("f.txt"));  
			out.writeObject(s1);  
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		 
		System.out.println("success");
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
			Student s2=(Student)in.readObject();  
			System.out.println(s2.id+" "+s2.name);  
			in.close();  
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  

	}

}
