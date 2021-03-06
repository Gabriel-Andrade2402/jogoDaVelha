package game.computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerHard extends Computer {
	private String lastPLay;

	public ComputerHard() {
	}

	@Override
	public String Play(String[][] board) {
		this.countPLays += 1;
		this.board = board;
		if (caseDefenceOrAtack("O") != null) {
			String play = caseDefenceOrAtack("O");
			lastPLay = play;
			System.out.println(play);
			return play;
		}
		if (caseDefenceOrAtack("X") != null) {
			String play = caseDefenceOrAtack("X");
			lastPLay = play;
			System.out.println(play);
			return play;
		}
		Random generator = new Random();
		if(generator.nextInt(2)+1==1 && lastPLay!=null) {
			String play = attackTwo();
			lastPLay = play;
			System.out.println(play);
			return play;
		}else {
			String play = gererRandomPlay();
			lastPLay = play;
			System.out.println(play);
			return play;
		}
	}

	// Esse m?todo checa se ? preciso fazer uma defesa para n?o perder
	// Ou se ? possivel gerar um ataque final
	public String caseDefenceOrAtack(String player) {
		// Check Lines
		for (int line = 0; line < 3; line++) {
			if (board[line][0] == player && board[line][1] == player) {
				// Confirma que o espa?o que pode gerar uma vit?ria esteja vazio
				if (board[line][2] == null) {
					return "C" + (line + 1);
				}
			}
			if (board[line][0] == player && board[line][2] == player) {
				if (board[line][1] == null) {
					return "B" + (line + 1);
				}
			}
			if (board[line][1] == player && board[line][2] == player) {
				if (board[line][0] == null) {
					return "A" + (line + 1);
				}
			}
		}
		// Check Columns
		for (int column = 0; column < 3; column++) {
			String columnName = convertNumberToColumn(column + 1);
			if (board[0][column] == player && board[1][column] == player) {
				if (board[2][column] == null) {
					return columnName + 3;
				}
			}
			if (board[0][column] == player && board[2][column] == player) {
				if (board[1][column] == null) {
					return columnName + 2;
				}
			}
			if (board[1][column] == player && board[2][column] == player) {
				if (board[0][column] == null) {
					return columnName + 1;
				}
			}
		}
		// Check diagonals
		if (board[0][0] == player && board[1][1] == player) {
			if (board[2][2] == null) {
				return "C3";
			}
		}
		if (board[0][0] == player && board[2][2] == player) {
			if (board[1][1] == null) {
				return "B2";
			}
		}
		if (board[1][1] == player && board[2][2] == player) {
			if (board[0][0] == null) {
				return "A1";
			}
		}
		if (board[0][2] == player && board[1][1] == player) {
			if (board[0][2] == null) {
				return "A3";
			}
		}
		if (board[0][2] == player && board[2][0] == player) {
			if (board[1][1] == null) {
				return "B2";
			}
		}
		if (board[2][0] == player && board[1][1] == player) {
			if (board[2][0] == null) {
				return "C1";
			}
		}
		return null;
	}

	// M?todo de ataque 1
	/*
	 * Esse m?todo consiste em jogar sempre pulando uma casa deixando um v?o entre
	 * as duas jogadas com condi??o de vit?ria
	 
	public String attackOne() {
		String last = decipherPlay(lastPLay);

		return "";
	}
	*/
	// M?todo de ataque 2
	/*
	 * Esse m?todo consiste em jogar sempre na casa mais pr?xima com condi??o de
	 * vit?ria
	 */
	public String attackTwo() {
		String last = decipherPlay(lastPLay);
		Integer lastColumn = Integer.parseInt(last.split("")[0])-1;
		Integer lastLine = Integer.parseInt(last.split("")[1])-1;
		List<String> fullPlays = new ArrayList();
		// Checa campos a esquerda
		for (int i = lastLine - 1; i < (lastLine+2); i++) {
			String play = checkPossibilityPlay(lastColumn - 1, i,board);
			if (play != "" && play != null) {
				fullPlays.add(play);
			}
		}
		// Checa campos acima e abaixo
		for (int i = lastLine-1; i < (lastLine+3);i+=2) {
			String play = checkPossibilityPlay(lastColumn, i,board);
			if (play != "" && play != null) {
				fullPlays.add(play);
			}
		}
		// Checa campos a direita
		for (int i = lastLine - 1; i < lastLine+2; i++) {
			String play = checkPossibilityPlay(lastColumn + 1, i,board);
			if (play != "" && play != null) {
				fullPlays.add(play);
			}
		}
		Random generator = new Random();
		String play=fullPlays.get(generator.nextInt(fullPlays.size()));
		return convertNumberToColumn(Integer.parseInt(play.split("")[1])+1)+play.split("")[0];
	}

	// M?todo de auxilio para retornar uma possivel jogada no tabuleiro
	// Evitando o nullpointer,Index of array etc...
	public String checkPossibilityPlay(Integer column, Integer line,String[][] board) {
		try {
			String camp = board[line][column];
			return column + ""+ line;
		} catch (Exception e) {
			return "";
		}

	}

	// M?todo que gera uma jogada aleat?ria valida
	public String gererRandomPlay() {
		Random generator = new Random();
		Integer column = generator.nextInt(3) + 1;
		Integer line = generator.nextInt(3) + 1;
		while (board[line - 1][column - 1] != null) {
			column = generator.nextInt(3) + 1;
			line = generator.nextInt(3) + 1;
		}
		String play = convertNumberToColumn(column) + line;
		return play;
	}

	// M?todo auxiliar para ler uma jogada
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

}
