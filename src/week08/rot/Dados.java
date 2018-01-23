package week08.rot;

import java.io.Serializable;

public class Dados implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String[] str;

	public Dados(String[] array) {
		this.str = array;

	}

	public void encriptar(int rot) {

		for (int j = 0; j < str.length; j++) {

			String string = str[j];

			StringBuilder aux = new StringBuilder();

			for (int i = 0; i < string.length(); i++) {
				char ch = string.charAt(i);

				if (ch < 'a') {
					ch = (char) ((ch - 'A' + rot) % 26 + 'A');
				} else {
					ch = (char) ((ch - 'a' + rot) % 26 + 'a');
				}

				aux.append(ch);
			}
			

			str[j] = aux.toString();

		}
	}

	public void desencriptar(int i) {
		encriptar(26-i);
	}
}
