public enum GameResult {

	NOT_FINISHED("Game not finished"),
	DRAW("Draw"),
	X_WINS("X wins"),
	O_WINS("O wins");

	private final String caption;

	GameResult(final String caption) {
		this.caption = caption;
	}

	@Override
	public String toString() {
		return caption;
	}
}
