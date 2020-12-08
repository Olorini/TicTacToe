import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

	private static final Map<String, Integer[]> INDEXES = new HashMap<>(9);
	static {
		INDEXES.put("11", new Integer[]{2, 0});
		INDEXES.put("12", new Integer[]{1, 0});
		INDEXES.put("13", new Integer[]{0, 0});
		INDEXES.put("21", new Integer[]{2, 1});
		INDEXES.put("22", new Integer[]{1, 1});
		INDEXES.put("23", new Integer[]{0, 1});
		INDEXES.put("31", new Integer[]{2, 2});
		INDEXES.put("32", new Integer[]{1, 2});
		INDEXES.put("33", new Integer[]{0, 2});
	}
	private char currentSymbol = TicTacToe.X;

	public void start(Scanner scanner) {
		char[][] gameState = new char[3][3];
		fillGameField(gameState);
		OutputUtils.showGameField(gameState);
		TicTacToe game = new TicTacToe();
		game.setField(gameState);
		play(scanner, game);
	}

	private void fillGameField(char[][] gameState) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameState[i][j] = TicTacToe.EMPTY;
			}
		}
	}

	private void play(Scanner scanner, TicTacToe game) {
		GameResult result;
		do {
			System.out.println("Enter the coordinates:");
			String coordinatesLine = scanner.nextLine().trim().replace(" ", "");
			char[] userCoordinates = coordinatesLine.toCharArray();
			Integer[] realCoordinates = INDEXES.get(coordinatesLine);
			if (areDigits(userCoordinates)) {
				if (areInRange(userCoordinates)) {
					if (game.isEmptyCell(realCoordinates[0],realCoordinates[1])) {
						game.fillCell(realCoordinates[0], realCoordinates[1], currentSymbol);
						changeCurrentSymbol();
						OutputUtils.showGameField(game.getField());
					} else {
						System.out.println("This cell is occupied! Choose another one!");
					}
				} else {
					System.out.println("Coordinates should be from 1 to 3!");
				}
			} else {
				System.out.println("You should enter numbers!");
			}
			result = game.checkGame();
		} while ("Game not finished".equals(result.toString()));
		System.out.println(result);
	}

	private boolean areDigits(char[] coordinates) {
		return Character.isDigit(coordinates[0]) && Character.isDigit(coordinates[1]);
	}

	private boolean areInRange(char[] coordinates) {
		int x = coordinates[0] - '0';
		int y = coordinates[1] - '0';
		return x > 0 && x < 4 &&  y > 0 && y < 4;
	}

	private void changeCurrentSymbol() {
		if (currentSymbol == TicTacToe.X) {
			currentSymbol = TicTacToe.O;
		} else {
			currentSymbol = TicTacToe.X;
		}
	}

}
