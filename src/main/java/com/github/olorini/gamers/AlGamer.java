package com.github.olorini.gamers;

import com.github.olorini.OutputUtils;
import com.github.olorini.TicTacToe;

import java.util.Random;
import java.util.Scanner;

/**
 * Artificial intelligence
 */
public class AlGamer implements IGamer {

	private final TicTacToe game;
	private final char symbol;

	public AlGamer(TicTacToe game, char symbol) {
		this.game = game;
		this.symbol = symbol;
	}

	@Override
	public void play(Scanner scanner) {
		System.out.println("Making move level \"easy\"");
		makeMove();
		OutputUtils.showGameField(game.getField());
	}

	public void makeMove() {
		int i, j;
		Random random = new Random();
		do {
			i = random.nextInt(3);
			j = random.nextInt(3);
		} while (game.isNotEmptyCell(i, j));
		game.fillCell(i, j, symbol);
	}
}
