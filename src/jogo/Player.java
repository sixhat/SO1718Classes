package jogo;

import java.util.Scanner;

public class Player {
	private String nome;
	private int numTentativas = 0;
	private long tempo;

	public Player() {

	}

	public void getName() {
		Scanner in = new Scanner(System.in);
		System.out.print("Nome? ");
		nome = in.nextLine();
//		in.close();
		System.out.println("Welcome " + nome);
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
	
		return nome+" : "+numTentativas+", "+tempo;
	}

}
