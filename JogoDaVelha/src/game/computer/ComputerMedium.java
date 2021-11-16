package game.computer;

import java.util.Random;

public class ComputerMedium extends Computer{

	public ComputerMedium() {
	}
	@Override
	public String Play(String[][] board) {
		this.countPLays+=1;
		this.board = board;
		if(caseDefenceOrAtack("X")!=null) {
			return caseDefenceOrAtack("X");
		}
		if(caseDefenceOrAtack("O")!=null) {
			return caseDefenceOrAtack("O");
		}
		
		return gererRandomPlay();
	}
	//Esse m�todo checa se � preciso fazer uma defesa para n�o perder
	//Ou se � possivel gerar um ataque final
	public String caseDefenceOrAtack(String player) {
		System.out.println("Check line");
		// Check Lines
		for (int line = 0; line < 3; line++) {
			if (board[line][0] == player && board[line][1] == player) {
				//Confirma que o espa�o que pode gerar uma vit�ria esteja vazio
				if(board[line][2]==null) {
					System.out.println("Entrou C");
					return "C"+(line+1);
				}
			}
			if (board[line][0] == player && board[line][2] == player) {
				if(board[line][1]==null) {
					System.out.println("Entrou B");
					return "B"+(line+1);
				}
			}
			if (board[line][1] == player && board[line][2] == player) {
				if(board[line][0]==null) {
					System.out.println("Entrou A");
					return "A"+(line+1);
				}
			}
		}
		System.out.println("Check columns");
		// Check Columns
		for (int column = 0; column < 3; column++) {
			String columnName = convertNumberToColumn(column+1);
			if (board[0][column] == player && board[1][column] == player) {
				if(board[2][column]==null) {
					return columnName+3;
				}
			}
			if (board[0][column] == player && board[2][column] == player) {
				if(board[1][column]==null) {
					return columnName+2;
				}
			}
			if (board[1][column] == player && board[2][column] == player) {
				if(board[0][column]==null) {
					return columnName+1;
				}
			}
		}
		System.out.println("Check diagonals");
		// Check diagonals
		if (board[0][0] == player && board[1][1] == player) {
			if(board[2][2]==null){
				return "C3";
			}
		}
		if (board[0][0] == player && board[2][2] == player) {
			if(board[1][1]==null){
				return "B2";	
			}
		}
		if (board[1][1] == player && board[2][2] == player) {
			if(board[0][0]==null){
				return "A1";
			}
		}
		if (board[0][2] == player && board[1][1] == player) {
			if(board[0][2]==null){
				return "A3";
			}
		}
		if (board[0][2] == player && board[2][0] == player) {
			if(board[1][1]==null){
				return "B2";
			}
		}
		if (board[2][0] == player && board[1][1] == player) {
			if(board[2][0]==null){
				return "C1";
			}
		}
		return null;
	}

	public String gererRandomPlay() {
		Random generator = new Random();
		Integer column=generator.nextInt(3)+1;
		Integer line=generator.nextInt(3)+1;
		while(board[line-1][column-1]!=null) {
			column = generator.nextInt(3)+1;
			line = generator.nextInt(3)+1;
		}
		String play = convertNumberToColumn(column)+line;
		return play;
	}

}
