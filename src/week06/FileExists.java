package week06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileExists {
	public static void main(String[] args) {
		File f = new File("/tmp/test.txt");
		if (f.exists()) {
			System.out.println("The File exists.");
			
		} else {
			System.out.println("No file");
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			try {
				while ((line = br.readLine())!=null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
	}
}
