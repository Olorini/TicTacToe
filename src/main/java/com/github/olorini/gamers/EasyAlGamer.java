package com.github.olorini.gamers;

import com.github.olorini.OutputUtils;
import com.github.olorini.gameProcesses.Game;

import java.util.Scanner;

/**
 * Artificial intelligence
 */
public class EasyAlGamer extends AIGamer implements IGamer {

	private final Game game;
	private final char symbol;

	public EasyAlGamer(Game game, char symbol) {
		super(game);
		this.game = game;
		this.symbol = symbol;
	}

	@Override
	public void play(Scanner scanner) {
		System.out.println("Making move level \"easy\"");
		game.setCurrentSymbol(symbol);
		makeMove();
		OutputUtils.showGameField(game.getBoard());
	}

	private void makeMove() {
		int moveCoordinate = calculateRandomMove();
		game.fillCell(moveCoordinate, symbol);
	}
}
