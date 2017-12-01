package week08.rot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
	public static void main(String[] args) {
		String[] ar = new String[2];
		ar[0] = "David";
		ar[1] = "SO";
		Dados d = new Dados(ar);
		d.encriptar(5);
		System.out.println(d.str[0] + " " + d.str[1]);

		try (ObjectOutputStream outF = new ObjectOutputStream(new FileOutputStream("dadosRot.dat"));) {
			outF.writeObject(d);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (ObjectInputStream inF = new ObjectInputStream(new FileInputStream("dadosRot.dat"));){
			Dados nova = (Dados) inF.readObject();
			nova.desencriptar(5);
			System.out.println(nova.str[0] + " " + nova.str[1]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
