import java.util.ArrayList;

public class Jornal {
	ArrayList<String> filaDeEspera;

	public Jornal() {
		filaDeEspera = new ArrayList<String>();
	}

	public synchronized void addNoticia(String noticia) {
		// Se a fila estiver cheia espera.
		while (filaDeEspera.size() >= 40) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Agora sabemos que podemos adicionar uma notícia (size < 40)
		filaDeEspera.add(noticia);
		// Se se tratar da primeira noticia devemos acordar um editor.
		if (filaDeEspera.size() == 1) {
			notify();
		}
	}

	public synchronized String removeNoticia() {
		// Se a fila estiver vazia temos que esperar por uma notificação.
		while (filaDeEspera.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Vamo remover o elemento de id mais baixo (0)
		String noticia = filaDeEspera.remove(0);

		// Vamos notificar o jornalista que possa eventualmente estar a dormir...
		if (filaDeEspera.size() == 39) {
			notify();
		}
		return noticia;
	}

	public static void main(String[] args) {
		Jornal jn = new Jornal();

		// Neste exemplo vamos ter apenas 1 editor e 1 jornalista, mas podem-se ter N de
		// cada.
		Jornalista jj = new Jornalista(jn);
		Editor ed = new Editor(jn);

		// Arrancam-se as threads;
		jj.start();
		ed.start();
	}
}
