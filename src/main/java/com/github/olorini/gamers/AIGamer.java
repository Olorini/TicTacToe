package com.github.olorini.gamers;

import com.github.olorini.gameProcesses.Game;

import java.util.Random;

public class AIGamer {

	private final Game game;

	public AIGamer(Game game) {
		this.game = game;
	}

	protected int calculateRandomMove() {
		int i;
		Random random = new Random();
		do {
			i = random.nextInt(9);
		} while (game.isNotEmptyCell(i));
		return i;
	}
}
