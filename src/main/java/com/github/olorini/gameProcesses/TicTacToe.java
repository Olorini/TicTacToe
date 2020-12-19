package com.github.olorini.gameProcesses;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

	public static final char X = 'X';
	public static final char O = 'O';
	public static final char EMPTY = '_';

	private final char[][] board;
	private final List<Integer[]> movesHistory = new ArrayList<>();

	public TicTacToe() {
		this.board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.board[i][j] = TicTacToe.EMPTY;
			}
		}
	}

	public char[][] getBoard() {
		return board;
	}

	public boolean isNotEmptyCell(int i, int j) {
		return board[i][j] != EMPTY;
	}

	public void fillCell(int i, int j, char symbol) {
		board[i][j] = symbol;
		movesHistory.add(new Integer[] {i, j});
	}

	public List<Integer[]> getMovesHistory() {
		return movesHistory;
	}

	public GameResult checkGame() {
		for (int i = 0; i < 3; i ++) {
			if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return getVictoryResult(board[i][0]);
			}
		}
		for (int i = 0; i < 3; i ++) {
			if (board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return getVictoryResult(board[0][i]);
			}
		}
		if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return getVictoryResult(board[0][0]);
		}
		if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return getVictoryResult(board[0][2]);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == EMPTY) {
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
