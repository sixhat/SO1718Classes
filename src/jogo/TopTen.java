package jogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

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
		
		Collections.sort(players);
		
		ArrayList<Player> aRemover = new ArrayList<Player>();
		
		for (int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			if (i<10) {
				System.out.println((i+1) +":\t"+p);
				
			} else {
				aRemover.add(p);
			}
		}
		
		players.removeAll(aRemover);
	}
	

}
