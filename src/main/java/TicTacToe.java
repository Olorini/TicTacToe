public class TicTacToe {

	public static final char X = 'X';
	public static final char O = 'O';
	public static final char EMPTY = '_';

	private char[][] field;

	public void setField(char[][] field) {
		this.field = field;
	}

	public char[][] getField() {
		return field;
	}

	public boolean isEmptyCell(int i, int j) {
		return field[i][j] == EMPTY;
	}
	
	public void fillCell(int i, int j, char symbol) {
		field[i][j] = symbol;
	}

	public GameResult checkGame() {
		for (int i = 0; i < 3; i ++) {
			if (field[i][0] != EMPTY && field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
				return getVictoryResult(field[i][0]);
			}
		}
		for (int i = 0; i < 3; i ++) {
			if (field[0][i] != EMPTY && field[0][i] == field[1][i] && field[1][i] == field[2][i]) {
				return getVictoryResult(field[0][i]);
			}
		}
		if (field[0][0] != EMPTY && field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
			return getVictoryResult(field[0][0]);
		}
		if (field[0][2] != EMPTY && field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
			return getVictoryResult(field[0][2]);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (field[i][j] == EMPTY) {
					return GameResult.NOT_FINISHED;
				}
			}
		}

		return GameResult.DRAW;
	}

	private GameResult getVictoryResult(char symbol) {
		return (symbol == X) ? GameResult.X_WINS : GameResult.O_WINS;
	}

}
