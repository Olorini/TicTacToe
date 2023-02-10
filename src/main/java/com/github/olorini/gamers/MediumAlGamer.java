package com.github.olorini.gamers;

import com.github.olorini.gameProcesses.Game;
import com.github.olorini.gameProcesses.GameResult;

import java.util.Optional;

/**
 *
 * The class make moves from Artificial intelligence
 * which has medium level of mental activity
 *
 */
public class MediumAlGamer extends AIGamer {

	private final Game game;
	private final char symbol;

	public MediumAlGamer(Game game, char symbol) {
		super(game, "medium", symbol);
		this.game = game;
		this.symbol = symbol;
	}

	/**
	 * Check whether the adversary may win
	 * make a confronted move
	 */
	@Override
	public void makeMove() {
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

	private Optional<Integer> findWinningPosition() {
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
