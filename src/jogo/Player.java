package jogo;

import java.io.Serializable;

/**
 * This is the Player class. It is the object that holds the characteristics of
 * each player.
 * 
 * @author "David Sousa-Rodrigues"
 *
 */
public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4120063933855521706L;
	
	private String nome;
	private int numTentativas = 0;
	private long tempo;

	public Player(String name) {
		this.setNome(name);
	}

	public int getTentativas() {
		return numTentativas;
	}

	/**
	 * Increments the number of tries of the player.
	 */
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
