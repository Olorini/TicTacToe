package com.github.olorini.gamers;

import com.github.olorini.OutputUtils;
import com.github.olorini.gameProcesses.TicTacToe;

import java.util.Scanner;

/**
 * Artificial intelligence
 */
public class EasyAlGamer extends AIGamer implements IGamer {

	private final TicTacToe game;
	private final char symbol;

	public EasyAlGamer(TicTacToe game, char symbol) {
		super(game);
		this.game = game;
		this.symbol = symbol;
	}

	@Override
	public void play(Scanner scanner) {
		System.out.println("Making move level \"easy\"");
		makeMove();
		OutputUtils.showGameField(game.getBoard());
	}

	private void makeMove() {
		Integer[] moveCoordinate = getRandomCoordinate();
		game.fillCell(moveCoordinate[0], moveCoordinate[1], symbol);
	}
}
