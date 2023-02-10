package com.github.olorini.gamers;

import com.github.olorini.gameProcesses.Game;

/**
 *
 * The class make moves from Artificial intelligence
 * which has low level of mental activity
 *
 */
public class EasyAlGamer extends AIGamer {

	private final Game game;
	private final char symbol;

	public EasyAlGamer(Game game, char symbol) {
		super(game, "easy", symbol);
		this.game = game;
		this.symbol = symbol;
	}

	/**
	 * Plays completely random moves.
	 */
	@Override
	public void makeMove() {
		int moveCoordinate = calculateRandomMove();
		game.fillCell(moveCoordinate, symbol);
	}
}
