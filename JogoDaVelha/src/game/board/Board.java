package game.board;

import game.computer.Computer;
import game.player.Player;

public class Board {
	//Tabuleiro
	private String[][] board = new String[3][3];

	public Board() {
	}
	//M?todo usado para iniciar a partida
	public String gameplay(Player player,Computer comput) {
		//Este bloco constitui a primeira jogada da partida.
		if(player.getCountPLays()==0) {
			Boolean validPlay=Play(player.play(),"player");
			while(!validPlay) {
				validPlay=Play(player.play(),"player");
			}
			player.setCountPLays(player.getCountPLays()+1);
		}
		//Este bloco constitui o decorrer do jogo.
		while(checkSituation()=="continue") {
			//Jogada do computador
			if(player.getCountPLays()>comput.getCountPLays()) {
				Play(comput.Play(board),"computer");
			}/*Jogada do player*/ else {
				//Valida??o de que a jogada n?o 
				Boolean validPlay=Play(player.play(),"player");
				while(!validPlay) {
					validPlay=Play(player.play(),"player");
				}
				player.setCountPLays(player.getCountPLays()+1);
			}
			System.out.println(seeGame());;
		}
		return checkSituation();
	}
	//M?todo usado para settar uma nova jogada
	private boolean Play(String play, String identify) {
		play = decipherPlay(play);
		if (checkPlay(play)) {
			if (identify == "player") {
				board[Integer.parseInt(play.split("")[1])-1][Integer.parseInt(play.split("")[0])-1] = "X";
			} else if (identify == "computer") {
				board[Integer.parseInt(play.split("")[1])-1][Integer.parseInt(play.split("")[0])-1] = "O";
			}

			return true;
		} else {
			return false;
		}
	}
	//M?todo usado para compreender qual posi??o ? A,B ou C
	private String decipherPlay(String play) {
		String[] caracts = play.split("");
		if (caracts[0].equals("A") || caracts[0].equals("a")) {
			return "1" + caracts[1];
		} else if (caracts[0].equals("B") || caracts[0].equals("b")) {
			return "2" + caracts[1];
		} else if (caracts[0].equals("C") || caracts[0].equals("c")) {
			return "3" + caracts[1];
		} else {
			return null;
		}
	}
	//M?todo usado para conferir se a jogada est? disponivel
	private boolean checkPlay(String play) {
		if(play!=null) {
			Integer column = Integer.parseInt(play.split("")[0]);
			Integer line = Integer.parseInt(play.split("")[1]);
			
			try {
				if (board[line-1][column-1] != null) {
					return false;
				} else {
					return true;
				}
			}catch(Exception e) {
				System.out.println("Ocorreu um erro inesperado.");
			}
		}else {
			System.out.println("Ocorreu um erro inesperado.");
		}
		return false;
	}
	//M?todo usado para checar o estado do jogo.
	private String checkSituation() {
		for (int i = 1; i < 3; i++) {
			String mark = null;
			if (i == 1)
				mark = "X";
			if (i == 2)
				mark = "O";
			// Check Lines
			for (int line = 0; line < 3; line++) {
				if (board[line][0] == mark && board[line][1] == mark && board[line][2] == mark) {
					if (mark == "X") {
						return "Vit?ria do Jogador";
					} else {
						return "Vit?ria do Computador";
					}
				}
			}
			// Check Columns
			for (int column = 0; column < 3; column++) {
				if (board[0][column] == mark && board[1][column] == mark && board[2][column] == mark) {
					if (mark == "X") {
						return "Vit?ria do Jogador";
					} else {
						return "Vit?ria do Computador";
					}
				}
			}
			// Check diagonals
			if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) {
				if (mark == "X") {
					return "Vit?ria do Jogador";
				} else {
					return "Vit?ria do Computador";
				}
			}
			if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) {
				if (mark == "X") {
					return "Vit?ria do Jogador";
				} else {
					return "Vit?ria do Computador";
				}
			}
		}
		// Check all spaces
		for (int line = 0; line < 3; line++) {
			for (int column = 0; column < 3; column++) {
				if (board[line][column] == null) {
					return "continue";
				}
			}
		}
		return "Empate";
	}
	//M?todo usado para imprimir o tabuleiro
	public String seeGame() {
		StringBuilder str = new StringBuilder();
		str.append((board[0][0] == null) ? "  | " : board[0][0] + " | ");
		str.append((board[0][1] == null) ? "  | " : board[0][1] + " | ");
		str.append((board[0][2] == null) ? "  |\n" : board[0][2] + " |\n");
		str.append((board[1][0] == null) ? "  | " : board[1][0] + " | ");
		str.append((board[1][1] == null) ? "  | " : board[1][1] + " | ");
		str.append((board[1][2] == null) ? "  |\n" : board[1][2] + " |\n");
		str.append((board[2][0] == null) ? "  | " : board[2][0] + " | ");
		str.append((board[2][1] == null) ? "  | " : board[2][1] + " | ");
		str.append((board[2][2] == null) ? "  |\n" : board[2][2] + " |\n");
		return str.toString();
	}
	//M?todo usado para retornar o tabuleiro
	public String[][] getBoard() {
		return board;
	}
	
	
}
