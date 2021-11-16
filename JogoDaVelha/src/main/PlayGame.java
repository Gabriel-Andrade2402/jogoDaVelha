package main;

import game.board.Board;
import game.computer.ComputerHard;
import game.computer.ComputerMedium;
import game.player.Player;

public class PlayGame {

	public static void main(String[] args) {
		/*Board board = new Board();
		ComputerMedium comp = new ComputerMedium();
		Player player = new Player();
		System.out.println(board.gameplay(player, comp));;
		*/
		Board board = new Board();
		ComputerHard comp = new ComputerHard();
		Player player = new Player();
		System.out.println(board.gameplay(player, comp));
	}

}
