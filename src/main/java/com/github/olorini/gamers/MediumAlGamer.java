package com.github.olorini.gamers;

import com.github.olorini.OutputUtils;
import com.github.olorini.gameProcesses.TicTacToe;
import com.github.olorini.gamers.results.PossibleMoveResult;

import java.util.List;
import java.util.Scanner;

/**
 * Artificial intelligence
 */
public class MediumAlGamer extends AIGamer implements IGamer {

	private final TicTacToe game;
	private final char symbol;

	public MediumAlGamer(TicTacToe game, char symbol) {
		super(game);
		this.game = game;
		this.symbol = symbol;
	}

	@Override
	public void play(Scanner scanner) {
		System.out.println("Making move level \"medium\"");
		makeMove();
		OutputUtils.showGameField(game.getBoard());
	}

	private void makeMove() {
		Integer[] moveCoordinate = findVictoryCell();
		game.fillCell(moveCoordinate[0], moveCoordinate[1], symbol);
	}

	private Integer[] findVictoryCell() {
		List<Integer[]> history = game.getMovesHistory();
		if (!history.isEmpty()) {
			if (history.size() > 1) {
				Integer[] lastOwnMove = history.get(history.size() - 2);
				PossibleMoveResult result = searchMoveCell(game.getBoard(), lastOwnMove, symbol);
				if (result.isVictoryMove()) {
					return result.getEmptyCellCoordinate();
				}
			}
			Integer[] lastOpponentMove = history.get(history.size() - 1);
			PossibleMoveResult result = searchMoveCell(game.getBoard(), lastOpponentMove, getOpponentSymbol());
			if (result.isVictoryMove()) {
				return result.getEmptyCellCoordinate();
			}
		}
		return getRandomCoordinate();
	}

	PossibleMoveResult searchMoveCell(char[][] board, Integer[] lastOwnMove, char s) {
		int x = lastOwnMove[0];
		int y = lastOwnMove[1];
		PossibleMoveResult rowResult = new PossibleMoveResult();
		PossibleMoveResult columnResult = new PossibleMoveResult();
		PossibleMoveResult firstDiagonalResult = new PossibleMoveResult();
		PossibleMoveResult secondDiagonalResult = new PossibleMoveResult();
		for (int i = 0; i < 3; i++) {
			if (board[i][y] == s) {
				rowResult.incrementSymbolCounter();
			} else if (board[i][y] == TicTacToe.EMPTY) {
				rowResult.setEmptyCellCoordinate(new Integer[]{i, y});
			}
			if (board[x][i] == s) {
				columnResult.incrementSymbolCounter();
			} else if (board[x][i] == TicTacToe.EMPTY) {
				columnResult.setEmptyCellCoordinate(new Integer[]{x, i});
			}
			if (board[i][i] == s) {
				firstDiagonalResult.incrementSymbolCounter();
			} else if (board[i][i] == TicTacToe.EMPTY) {
				firstDiagonalResult.setEmptyCellCoordinate(new Integer[]{i, i});
			}
			if (board[2 - i][i] == s) {
				secondDiagonalResult.incrementSymbolCounter();
			} else if (board[2 - i][i] == TicTacToe.EMPTY) {
				secondDiagonalResult.setEmptyCellCoordinate(new Integer[]{2 - i, i});
			}
		}
		if (rowResult.isVictoryMove()) {
			return rowResult;
		}
		if (columnResult.isVictoryMove()) {
			return columnResult;
		}
		if (firstDiagonalResult.isVictoryMove()) {
			return firstDiagonalResult;
		}
		return secondDiagonalResult;
	}

	private char getOpponentSymbol() {
		return (symbol == TicTacToe.X) ? TicTacToe.O : TicTacToe.X;
	}
}
