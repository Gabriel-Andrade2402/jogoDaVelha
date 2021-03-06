package game;

import java.util.Scanner;

import game.board.Board;
import game.computer.Computer;
import game.computer.ComputerEasy;
import game.computer.ComputerHard;
import game.computer.ComputerMedium;
import game.player.Player;

public class Game {
	public static Board board;
	public static Computer computer;
	public static Player player;
	//M?todo que inicia um jogo
	public static void startGame() {
		Scanner sc = new Scanner(System.in);

		System.out.println("JOGO DA VELHA");
		System.out.println("Para iniciar o jogo escolha o n?mero de uma dificuldade :");
		System.out.println("1.F?cil   2.M?dio   3.Dif?cil");
		Integer difficulty = sc.nextInt();
		//Seleciona uma Dificuldade valida
		while(difficulty!=1&&difficulty!=2&&difficulty!=3) {
			System.out.println("Dificuldade n?o encontrada, Digite o n?mero da dificuldade:");
			System.out.println("1.Fac?l   2.M?dio   3.Dif?cil");
			difficulty = sc.nextInt();
		}
		//Dificuldades
		switch(difficulty) {
		case 1:
			System.out.println("Dificuldade f?cil selecionada.");
			System.out.println("As leituras das jogadas s?o baseadas em linhha e coluna.");
			System.out.println("Ex de jogada:  A1 ou B3 ou C2");
			Board boardEasy = new Board();
			ComputerEasy compEasy = new ComputerEasy();
			Player playerEasy = new Player();
			board = boardEasy;
			computer = compEasy;
			player = playerEasy;
			System.out.println(boardEasy.seeGame());
			System.out.println("Come?e o jogo");
			System.out.println(boardEasy.gameplay(playerEasy, compEasy));
			break;
		case 2:
			System.out.println("Dificuldade M?dio selecionada.");
			System.out.println("As leituras das jogadas s?o baseadas em linhha e coluna.");
			System.out.println("Ex de jogada:  A1 ou B3 ou C2");
			Board boardMedium = new Board();
			ComputerMedium compMedium = new ComputerMedium();
			Player playerMedium = new Player();
			board = boardMedium;
			computer = compMedium;
			player = playerMedium;
			System.out.println(boardMedium.seeGame());
			System.out.println("Come?e o jogo");
			System.out.println(boardMedium.gameplay(playerMedium, compMedium));;
			break;
		case 3:
			System.out.println("Dificuldade Dif?cil selecionada.");
			System.out.println("As leituras das jogadas s?o baseadas em linhha e coluna.");
			System.out.println("Ex de jogada:  A1 ou B3 ou C2");
			Board boardHard = new Board();
			ComputerHard compHard = new ComputerHard();
			Player playerHard = new Player();
			board = boardHard;
			computer = compHard;
			player = playerHard;
			System.out.println(boardHard.seeGame());
			System.out.println("Come?e o jogo");
			System.out.println(boardHard.gameplay(playerHard, compHard));
			break;
		}
	}
}
