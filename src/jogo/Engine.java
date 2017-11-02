package jogo;

import java.util.Random;
import java.util.Scanner;

public class Engine {

	private Random rng;
	private Player p1;
	private int numeroSecreto;
	private long startTime;
	private long finalTime;
	private Scanner in;

	public Engine() {
		this.rng = new Random();
		in = new Scanner(System.in);

		System.out.print("Nome? ");
		p1 = new Player(in.nextLine());
		System.out.println("Welcome " + p1.getNome());

		startTime = System.currentTimeMillis();
	}

	public void newGame() {
		// Sortear um número

		numeroSecreto = rng.nextInt(100);
		System.out.println(numeroSecreto);

		int tentativa = -1;

		// System.out.println("Adivinha o número?");

		while (tentativa != numeroSecreto) {
			tentativa = in.nextInt();
			p1.incTentativas();
			System.out.println(tentativa);
			if (tentativa < numeroSecreto) {
				System.out.println("Tentativa abaixo");
			}
			if (tentativa > numeroSecreto) {
				System.out.println("Tentativa acima");
			}
		}
		System.out.println("Parabéns");

		finalTime = System.currentTimeMillis();

		p1.setTempo(finalTime - startTime);

		System.out.println(p1);

		in.close();
		// Save Top 10
	}

	public static void main(String[] args) {
		Engine e = new Engine();
		e.newGame();
	}

}
