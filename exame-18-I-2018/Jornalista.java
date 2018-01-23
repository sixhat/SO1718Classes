
public class Jornalista extends Thread {

	private Jornal jn;

	public Jornalista(Jornal jn) {
		this.jn = jn;
	}

	@Override
public void run() {
		while (true) {
			// A string pode ser sempre igual ou poderia ser gerada aleatoriamente
			
			String noticia = "";
			int strSize = (int) (1+Math.random()*100);
			while (noticia.length()<strSize) {
				noticia += (char) ((int) (65 + Math.random()*26));
			}
			
			// Adiciona-se a notícia ao jornal
			jn.addNoticia(noticia);
			try {
				sleep((long) (100+Math.random()*400));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
}
