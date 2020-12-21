package com.github.olorini.gamers;

import com.github.olorini.OutputUtils;
import com.github.olorini.gameProcesses.Game;
import com.github.olorini.gameProcesses.GameResult;

import java.util.Optional;
import java.util.Scanner;

/**
 * Artificial intelligence
 */
public class MediumAlGamer extends AIGamer implements IGamer {

	private final Game game;
	private final char symbol;

	public MediumAlGamer(Game game, char symbol) {
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
		int i = calculateMoveBetterThanRandom();
		game.fillCell(i, symbol);
	}

	private int calculateMoveBetterThanRandom() {
		Optional<Integer> possibleMove = findWinningPosition();
		if (possibleMove.isPresent()) {
			return possibleMove.get();
		} else {
			game.changeCurrentSymbol();
			Optional<Integer> possibleEnemyMove = findWinningPosition();
			game.changeCurrentSymbol();
			return possibleEnemyMove.orElse(calculateRandomMove());
		}
	}

	Optional<Integer> findWinningPosition() {
		for (int cellId : game.getEmptyCells()) {
			game.fillCell(cellId, game.getCurrentSymbol());
			GameResult gameState = game.checkGameState();
			game.fillCell(cellId, Game.EMPTY);
			if (gameState.isEveryoneWon()) {
				return Optional.of(cellId);
			}
		}
		return Optional.empty();
	}
}
