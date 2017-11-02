package jogo;

public class Player {
	private String nome;
	private int numTentativas = 0;
	private long tempo;

	public Player(String name) {
		this.setNome(name);
	}

	public int getTentativas() {
		return numTentativas;
	}

	public void incTentativas() {
		this.numTentativas++;
	}

	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo2) {
		tempo = tempo2;

	}

	@Override
	public String toString() {
		return getNome() + " : " + numTentativas + ", " + tempo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
