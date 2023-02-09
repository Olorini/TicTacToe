package com.github.olorini.gameProcesses;

/**
 * The {@Code GameResult} class represents enums for result of
 * the Tic-Tac-Toe game. It's possible create four variants of result
 * NOT_FINISHED - game continue
 * DRAW - nobody won or lost
 * X_WINS - gamer used the symbol 'X' has won
 * O_WINS - gamer used the symbol 'O' has won
 */
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

	/**
	 * Checks that result equals 'DRAW'
	 * @return boolean value
	 */
	public boolean isDraw() {
		return this == DRAW;
	}

	/**
	 * Checks that any gamer has won
	 * @return boolean value
	 */
	public boolean isEveryoneWon() {
		return this == X_WINS || this == O_WINS;
	}

	/**
	 * Checks that the gamer is over
	 * @return boolean value
	 */
	public boolean isNotGameOver() {
		return !isGameOver;
	}

	@Override
	public String toString() {
		return caption;
	}
}
