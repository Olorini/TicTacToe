import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

	private static final Map<String, Integer[]> INDEXES = new HashMap<>(9);
	private static char currentSymbol = 'X';

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

	public static void start() {
		Scanner scanner = new Scanner(System.in);
		char[][] gameState = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameState[i][j] = '_';
			}
		}
		showGame(gameState);
		enterCoordinates(scanner, gameState);
	}

	public static void enterCoordinates(Scanner scanner, char[][] gameState) {
		String result;
		do {
			System.out.println("Enter the coordinates:");
			String coordinatesLine = scanner.nextLine().trim().replace(" ", "");
			char[] coordinates = coordinatesLine.toCharArray();
			Integer[] realCoordinates = INDEXES.get(coordinatesLine);
			if (areDigits(coordinates)) {
				if (areInRange(coordinates)) {
					if (gameState[realCoordinates[0]][realCoordinates[1]] == '_') {
						gameState[realCoordinates[0]][realCoordinates[1]] = currentSymbol;
						changeCurrentSymbol();
						showGame(gameState);
					} else {
						System.out.println("This cell is occupied! Choose another one!");
					}
				} else {
					System.out.println("Coordinates should be from 1 to 3!");
				}
			} else {
				System.out.println("You should enter numbers!");
			}
			result = checkGame(gameState);

		} while ("Game not finished".equals(result));
		System.out.println(result);
	}

	public static void showGame(char[][] game) {
		System.out.println("---------");
		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + game[i][j]);
			}
			System.out.print(" |\n");
		}
		System.out.println("---------");
	}

	public static boolean areDigits(char[] coordinates) {
		return Character.isDigit(coordinates[0]) && Character.isDigit(coordinates[1]);
	}

	public static boolean areInRange(char[] coordinates) {
		int x = coordinates[0] - '0';
		int y = coordinates[1] - '0';
		return x > 0 && x < 4 &&  y > 0 && y < 4;
	}

	private static void changeCurrentSymbol() {
		if (currentSymbol == 'X') {
			currentSymbol = 'O';
		} else {
			currentSymbol = 'X';
		}
	}

	private static String getVictoryText(char symbol) {
		return (symbol == 'X') ? "X wins" : "O wins";
	}

	public static String checkGame(char[][] state) {

		for (int i = 0; i < 3; i ++) {
			if (state[i][0] != '_' && state[i][0] == state[i][1] && state[i][1] == state[i][2]) {
				return getVictoryText(state[i][0]);
			}
		}
		for (int i = 0; i < 3; i ++) {
			if (state[0][i] != '_' && state[0][i] == state[1][i] && state[1][i] == state[2][i]) {
				return getVictoryText(state[0][i]);
			}
		}
		if (state[0][0] != '_' && state[0][0] == state[1][1] && state[1][1] == state[2][2]) {
			return getVictoryText(state[0][0]);
		}
		if (state[0][2] != '_' && state[0][2] == state[1][1] && state[1][1] == state[2][0]) {
			return getVictoryText(state[0][2]);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (state[i][j] == '_') {
					return "Game not finished";
				}
			}
		}

		return "Draw";
	}
}
