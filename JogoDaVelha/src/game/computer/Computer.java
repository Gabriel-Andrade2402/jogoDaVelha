package game.computer;

public class Computer {
	public Integer countPLays=0;
	public String[][] board;
	
	public Computer() {
	}
	
	public String Play(String[][] board) {
		return "";
	}
	public String convertNumberToColumn(Integer i) {
		String columnName = "";
		switch(i) {
			case 1:
				columnName="A";
				break;
			case 2:
				columnName="B";
				break;
			case 3:
				columnName="C";
				break;
		}
		return columnName;
	}
	public Integer convertColumnToNumber(String i) {
		Integer columnName=null;
		switch(i) {
			case "A":
				columnName=1;
				break;
			case "B":
				columnName=2;
				break;
			case "C":
				columnName=3;
				break;
		}
		return columnName;
	}
	public Integer getCountPLays() {
		return countPLays;
	}
	
}
