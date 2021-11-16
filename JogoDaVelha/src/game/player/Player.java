package game.player;

import java.util.Scanner;

public class Player {
	private Integer countPLays=0;
	
	public Player() {
		
	}
	
	public String play() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public Integer getCountPLays() {
		return countPLays;
	}

	public void setCountPLays(Integer countPLays) {
		this.countPLays = countPLays;
	}
	
}
