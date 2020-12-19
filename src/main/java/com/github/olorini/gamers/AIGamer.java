package com.github.olorini.gamers;

import com.github.olorini.gameProcesses.TicTacToe;

import java.util.Random;

public class AIGamer {

	private final TicTacToe game;

	public AIGamer(TicTacToe game) {
		this.game = game;
	}

	protected Integer[] getRandomCoordinate() {
		int i, j;
		Random random = new Random();
		do {
			i = random.nextInt(3);
			j = random.nextInt(3);
		} while (game.isNotEmptyCell(i, j));
		return new Integer[]{i, j};
	}
}
