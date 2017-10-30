package week07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinaryFileIO {
	public static void main(String[] args) {
		
		// Let's first write something
		String str = "This is a String Field";
		int numbr1 = 42;
		double numbr2 = 4.5;
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dados.dat"));
			out.writeUTF(str);
			out.writeInt(numbr1);
			out.writeDouble(numbr2);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Let's read and print it.
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("dados.dat"));
			System.out.println(in.readUTF());
			System.out.println(in.readInt());
			System.out.println(in.readDouble());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
