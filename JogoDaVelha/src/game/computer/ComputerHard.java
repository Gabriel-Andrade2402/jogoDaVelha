package game.computer;

public class ComputerHard extends Computer{

	public ComputerHard(String[][] board) {
		super(board);
	}

	@Override
	public String Play() {
		if(caseDefence()!=null) {
			return caseDefence();
		}
		return "";
	}
	public String caseDefence() {
		// Check Lines
		for (int line = 0; line < 3; line++) {
			if (board[line][0] == "X" && board[line][1] == "X") {
				return "C"+line;
			}
			if (board[line][0] == "X" && board[line][2] == "X") {
				return "B"+line;
			}
			if (board[line][1] == "X" && board[line][2] == "X") {
				return "A"+line;
			}
		}
		// Check Columns
		for (int column = 0; column < 3; column++) {
			String columnName = "";
			switch(column) {
				case 0:
					columnName="A";
					break;
				case 1:
					columnName="B";
					break;
				case 2:
					columnName="C";
					break;
			}
			if (board[0][column] == "X" && board[1][column] == "X") {
				return columnName+2;
			}
			if (board[0][column] == "X" && board[2][column] == "X") {
				return columnName+1;
			}
			if (board[1][column] == "X" && board[2][column] == "X") {
				return columnName+0;
			}
		}
		// Check diagonals
		if (board[0][0] == "X" && board[1][1] == "X") {
			return "C2";
		}
		if (board[0][0] == "X" && board[2][2] == "X") {
			return "B1";	
		}
		if (board[1][1] == "X" && board[2][2] == "X") {
			return "A0";
		}
		if (board[0][2] == "X" && board[1][1] == "X") {
			return "A2";
		}
		if (board[0][2] == "X" && board[2][0] == "X") {
			return "B1";
		}
		if (board[2][0] == "X" && board[1][1] == "X") {
			return "C0";
		}
		return null;
	}

}