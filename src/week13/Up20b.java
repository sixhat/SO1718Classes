package week13;

import java.math.BigInteger;

public class Up20b {
	BigInteger n;

	public Up20b(String i) throws NumberFormatException {
		n = new BigInteger(i);
	}

	public static void main(String[] args) {
		try {
			Up20b a = new Up20b("0");
			a.printAll("2000000000000000000000", 2);
		} catch (NumberFormatException e) {
			System.out.println("Number Format was not correct... we are working with big integers here");
		}
		
	}

	private void printAll(String upLimit, int nBit) throws NumberFormatException {
		BigInteger limit = new BigInteger(upLimit);
		BigInteger acum = new BigInteger("0");
		while (n.compareTo(limit)<0) {
			if (n.testBit(nBit)) {
				acum = acum.add(n);
				System.out.println("Using "+n.toString());
				System.out.println("Acum  "+acum.toString());
			}
			n = n.multiply(n);
			n = n.multiply(new BigInteger("3"));
			n = n.add(new BigInteger("1"));
		
		}
		System.out.println("Total: "+acum.toString() +" using "+  acum.bitLength()+" bits");
	}
}
