package game.computer;

import java.util.Random;

public class ComputerEasy extends Computer{

	public ComputerEasy() {
	}

	@Override
	public String Play(String[][] board) {
		this.board= board;
		countPLays+=1;
		return gererRandomPlay();
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
}
