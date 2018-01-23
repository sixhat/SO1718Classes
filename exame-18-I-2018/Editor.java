
public class Editor extends Thread {
	private Jornal jn;

	public Editor(Jornal jn) {
		this.jn = jn;
	}
	@Override
	public void run() {
		while (true) {
			// os editores removem uma notícia
			String noticia = jn.removeNoticia();
			// E calculam o seu tamanho.
			System.out.println(noticia.length() + " "+ noticia);
		}
	}
}
