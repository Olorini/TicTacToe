package com.github.olorini.gameProcesses;

public enum GameResult {

	NOT_FINISHED("Game not finished", false),
	DRAW("Draw", true),
	X_WINS("X wins", true),
	O_WINS("O wins", true);

	private final String caption;
	private final boolean isGameOver;

	GameResult(String caption, boolean isGameOver) {
		this.caption = caption;
		this.isGameOver = isGameOver;
	}

	public boolean isDraw() {
		return this == DRAW;
	}

	public boolean isEveryoneWon() {
		return this == X_WINS || this == O_WINS;
	}

	public boolean isNotGameOver() {
		return !isGameOver;
	}

	@Override
	public String toString() {
		return caption;
	}
}
