package jogo;

import java.io.Serializable;
import java.util.ArrayList;

public class TopTen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Player> players;
	
	public TopTen() {
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	} 
	
	public void printSorted() {
		for (Player player : players) {
			System.out.println(player);
		}
	}
	

}
