package week07;

import java.util.Scanner;

/**
 * A simple example of how to use a Scanner to read input from the System.in
 * stream
 * 
 * @author "David Sousa-Rodrigues"
 */
public class GetUserInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Welcome, please tell me your name: ");
		String name = sc.nextLine();
		System.out.println("Welcome " + name);
		sc.close();
	}
}
