package week06;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyScanner {
	public MyScanner() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static void main(String[] args) {		
		
		Scanner sc;
		try {
			sc = new Scanner(new File("myNumbers.txt"));
			long sum=0;
			
			while (sc.hasNextLong()) {
				long aLong = sc.nextLong();
				sum+=aLong;
				System.out.println(sum);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
};
