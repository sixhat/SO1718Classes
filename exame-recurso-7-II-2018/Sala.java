import java.util.ArrayList;

public class Sala {
	private static int capacidade = 50;
	private ArrayList<Jogador> jogadores;

	public Sala() {
		this.jogadores = new ArrayList<Jogador>();
	}

	public synchronized void adicionarJogador(Jogador j1) {
		if (jogadores.size() < capacidade) {
			jogadores.add(j1);
		}
	}

	public synchronized void removerJogador(Jogador j2) {
		jogadores.remove(j2);
	}
}
