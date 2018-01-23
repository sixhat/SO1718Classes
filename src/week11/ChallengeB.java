package week11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChallengeB {

	private String contents;
	public String test;

	public ChallengeB(String file) {
		try {
			contents = new String(Files.readAllBytes(Paths.get(file)));
			test = contents;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChallengeB b = new ChallengeB("challengeB.txt");
		b.frequencyAnalisys();
		b.replace('L', 'e');
		b.replace('M', 't');
		b.replace('H', 'a');
		b.replace('V', 'o');
		b.replace('U', 'n');
		b.replace('P', 'i');
		b.replace('D', 'w');
		b.replace('Z', 's');
		b.replace('Y', 'r');
		b.replace('K', 'd');
		b.replace('N', 'g');
		b.replace('O', 'h');
		b.replace('S', 'l');
		b.replace('T', 'm');
		b.replace('F', 'y');
		b.replace('C', 'v');
		b.replace('B', 'u');
		b.replace('I', 'b');
		b.replace('J', 'c');
		b.replace('R', 'k');
		b.replace('X', 'q');
		
		
		System.out.println(b.test);
		
	}

	private void frequencyAnalisys() {
		int[] count = new int[26];

		String keys = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		

		System.out.println(contents);
		for (int i = 0; i < contents.length(); i++) {
			int id = keys.indexOf(contents.charAt(i));
			if (id > -1) {
				count[id]++;
			}
		}
		
		for (int i = 0; i < keys.length(); i++) {
			System.out.println(keys.substring(i, i + 1) + " : " + count[i]);
		}
	}

	private String replace(char A, char B) {
		
		char[] t  = test.toCharArray();
		for (int i = 0; i < contents.length(); i++) {
			if (contents.charAt(i)==A) {
				t[i]=B;
			} else {
				t[i]=test.charAt(i);
			}
		}
		test = String.copyValueOf(t);
		
		return test;
	}
}
