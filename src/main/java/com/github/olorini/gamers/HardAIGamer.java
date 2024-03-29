package com.github.olorini.gamers;

import com.github.olorini.gameProcesses.Game;
import com.github.olorini.gameProcesses.GameResult;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * The class make moves from Artificial intelligence
 * which has high level of mental activity
 *
 */
public class HardAIGamer extends AIGamer {

	private final Game game;
	private final char symbol;

	public HardAIGamer(Game game, char symbol) {
		super(game, "hard", symbol);
		this.game = game;
		this.symbol = symbol;
	}

	@Override
	public void makeMove() {
		int i;
		if (game.getEmptyCells().size() == 9) {
			i = calculateRandomMove();
		} else {
			i = calculateTheBestMove(0, new HashMap<>());
		}
		game.fillCell(i, symbol);
	}

	private int calculateTheBestMove(int depth, Map<Integer, Integer> levelOutcomes) {
		GameResult gameState = game.checkGameState();
		if (gameState.isDraw()) {
			return 0;
		}
		if (gameState.isEveryoneWon()) {
			return -1;
		}
		checkAllPossibilities(depth, levelOutcomes);
		if (depth == 0) {
			return getTheBestCellIndex(levelOutcomes);
		} else {
			return getMaxLevelResult(levelOutcomes);
		}
	}

	private void checkAllPossibilities(int depth, Map<Integer, Integer> levelOutcomes) {
		for (int cellId : game.getEmptyCells()) {
			game.fillCell(cellId, game.getCurrentSymbol());
			game.changeCurrentSymbol();
			int score = -1 * calculateTheBestMove(depth + 1, new HashMap<>());
			levelOutcomes.put(cellId, score);
			game.fillCell(cellId, Game.EMPTY);
			game.changeCurrentSymbol();
		}
	}

	private int getTheBestCellIndex(Map<Integer, Integer> levelOutcomes) {
		return levelOutcomes.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();
	}

	private int getMaxLevelResult(Map<Integer, Integer> levelOutcomes) {
		return levelOutcomes.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getValue();
	}
}
