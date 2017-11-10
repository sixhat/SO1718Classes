package week8;

/**
 * A simple Rotate 13 encryption class.
 * 
 * @author "David Sousa-Rodrigues"
 *
 */
public class Rot13 {
	private int rotateBy;

	public Rot13() {
		this(13);
	}

	public Rot13(int rotateBy) {
		this.rotateBy = rotateBy;
	}

	public String encode(String str) {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch > 96) {
				ch = (char) ('a' + (ch + this.rotateBy - 'a') % 26);
			} else {
				ch = (char) ('A' + (ch + this.rotateBy - 'A') % 26);
			}
			out.append(ch);
		}

		return out.toString();

	}

	public String decode(String str) {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch > 96) {
				ch = (char) ('a' + (ch - this.rotateBy - 'a' + 26) % 26);
			} else {
				ch = (char) ('A' + (ch - this.rotateBy - 'A' + 26) % 26);
			}
			out.append(ch);
		}

		return out.toString();
	}

	public static void main(String[] args) {
		Rot13 rt = new Rot13();
		String enc = rt.encode("aAbbCzzXZ");
		System.out.println(enc);
		System.out.println(rt.decode(enc));

	}

}
