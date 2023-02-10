package com.github.olorini.gamers;

import com.github.olorini.OutputUtils;
import com.github.olorini.gameProcesses.Game;

import java.util.Random;
import java.util.Scanner;

/**
 * An abstract class describes the artificial intelligence as a gamer
 */
public abstract class AIGamer implements IGamer {

	private final Game game;
	private final String level;
	private final char symbol;

	public AIGamer(Game game, String level, char symbol) {
		this.game = game;
		this.level = level;
		this.symbol = symbol;
	}

	@Override
	public void play(Scanner scanner) {
		System.out.printf("Making move level \"%s\"", level);
		if (!"medium".equals(level)) {
			game.setCurrentSymbol(symbol);
		}
		makeMove();
		OutputUtils.showGameField(game.getBoard());
	}

	public abstract void makeMove();

	/**
	 * Make random move on the game board
	 * @return random cell
	 */
	protected int calculateRandomMove() {
		int i;
		Random random = new Random();
		do {
			i = random.nextInt(9);
		} while (game.isNotEmptyCell(i));
		return i;
	}
}
