package jogo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the main entry point of the Game. The Engine controls the mechanics
 * of the game.
 * 
 * @author "David Sousa-Rodrigues"
 *
 */
public class Engine {

	private Random rng;
	private Player p1;
	private int numeroSecreto;
	private long startTime;
	private long finalTime;
	private Scanner in;
	private TopTen tt;

	public Engine() {
		this.rng = new Random();
		in = new Scanner(System.in);

		System.out.print("Nome? ");
		p1 = new Player(in.nextLine());
		System.out.println("Welcome " + p1.getNome());

		startTime = System.currentTimeMillis();
	}

	/**
	 * This class runs a new Game for the Player initialized in the constructor.
	 */
	public void newGame() {
		// Sortear um número

		numeroSecreto = rng.nextInt(100);
		System.out.println(numeroSecreto);

		int tentativa = -1;

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

		File fichTopTen = new File("topten.top");

		if (fichTopTen.exists()) {
			try (ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(fichTopTen));){				
				tt = (TopTen) in2.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			tt = new TopTen();
		}

		tt.addPlayer(p1);

		tt.printSorted();

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichTopTen));) {
			out.writeObject(tt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		in.close();
		// Save Top 10
	}

	public static void main(String[] args) {
		Engine e = new Engine();
		e.newGame();
	}

}
