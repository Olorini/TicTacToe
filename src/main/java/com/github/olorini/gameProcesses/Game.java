package com.github.olorini.gameProcesses;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Game {

	public static final char X = 'X';
	public static final char O = 'O';
	public static final char EMPTY = '_';

	private final char[] board;
	private char currentSymbol;

	public Game() {
		this.board = new char[9];
		for (int i = 0; i < 9; i++) {
			fillCell(i, EMPTY);
		}
	}

	public Game(char[] board) {
		this.board = board;
	}

	public char[] getBoard() {
		return board;
	}

	public List<Integer> getEmptyCells() {
		List<Integer> emptyIndexes = new LinkedList<>();
		for (int i = 0; i < 9; i++) {
			if (isEmptyCell(i)) {
				emptyIndexes.add(i);
			}
		}
		return emptyIndexes;
	}

	public boolean isNotEmptyCell(int i) {
		return board[i] != EMPTY;
	}

	public boolean isEmptyCell(int i) {
		return board[i] == EMPTY;
	}

	public void fillCell(int i, char symbol) {
		board[i] = symbol;
	}

	public boolean areEqualsCells(int i, int j) {
		return board[i] == board[j];
	}

	public Optional<Character> getWinnerSymbol() {
		for (int i = 0; i < 3; i++) {
			if (isNotEmptyCell(i) && areEqualsCells(i, i + 3) && areEqualsCells(i + 3, i + 6)) {
				return Optional.of(board[i]);
			}
		}
		for (int i = 0; i < 9; i+=3) {
			if (isNotEmptyCell(i) && areEqualsCells(i, i + 1) && areEqualsCells(i + 1, i + 2)) {
				return Optional.of(board[i]);
			}
		}
		if (isNotEmptyCell(0) && areEqualsCells(0, 4) && areEqualsCells(4, 8)) {
			return Optional.of(board[0]);
		}
		if (isNotEmptyCell(2) && areEqualsCells(2, 4) && areEqualsCells(4, 6)) {
			return Optional.of(board[2]);
		}
		return Optional.empty();
	}

	public GameResult checkGameState() {
		Optional<Character> winnerSymbol = getWinnerSymbol();
		if (winnerSymbol.isPresent()) {
			return getVictoryResult(winnerSymbol.get());
		}
		for (int i = 0; i < 9; i++) {
			if (isEmptyCell(i)) {
				return GameResult.NOT_FINISHED;
			}
		}
		return GameResult.DRAW;
	}

	private GameResult getVictoryResult(char symbol) {
		return (symbol == X) ? GameResult.X_WINS : GameResult.O_WINS;
	}

	public char getCurrentSymbol() {
		return currentSymbol;
	}

	public void setCurrentSymbol(char currentSymbol) {
		this.currentSymbol = currentSymbol;
	}

	public void changeCurrentSymbol() {
		this.currentSymbol = (currentSymbol == X) ? O : X;
	}
}
