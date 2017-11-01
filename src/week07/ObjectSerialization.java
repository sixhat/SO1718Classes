package week07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerialization implements Serializable {
	/**
	 * Generated Serial Number..
	 */
	private static final long serialVersionUID = 2455495852041045117L;

	private String name;
	private int size;

	public ObjectSerialization(String name) {
		// This is the constructor
		this.name = name;
		this.size = this.name.length();
	}

	@Override
	public String toString() {
		return name + " : " + size;
	}

	public static void main(String[] args) {
		ObjectSerialization objectToSendToDisk = new ObjectSerialization("David Sousa-Rodrigues");
		System.out.println(String.format("%1$13s = %2$20s", "Before Saving", objectToSendToDisk));

		try {

			// let's write the object to file
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ClassData.dat"));
			out.writeObject(objectToSendToDisk);
			out.close();

			// Let's read the Object from file
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("ClassData.dat"));
			ObjectSerialization newObject = (ObjectSerialization) in.readObject();
			System.out.println(String.format("%1$13s = %2$20s", "From File", newObject));
			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// This Exception occurs when reading from the serialized file if the JVM can't
			// find a corresponding class.
			e.printStackTrace();
		}

	}
}
