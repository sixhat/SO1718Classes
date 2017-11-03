package jogo;

import java.io.Serializable;
import java.util.ArrayList;

public class TopTen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5620132132506050602L;
	
	
	private ArrayList<Player> players;
	
	public TopTen() {
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	} 
	
	public void printSorted() {
		System.out.println("======================================");
		System.out.println("|| TOP TEN                          ||");
		System.out.println("======================================");
		for (Player player : players) {
			System.out.println(player);
		}
	}
	

}
