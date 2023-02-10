package com.github.olorini.gamers;

import com.github.olorini.OutputUtils;
import com.github.olorini.gameProcesses.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The class carries out commands from human
 */
public class HumanGamer implements IGamer {

	public static final List<String> GAME_COORDINATES = new ArrayList<>(
			Arrays.asList("11", "12", "13", "21", "22", "23", "31", "32", "33")
	);

	private final Game game;
	private final char symbol;

	public HumanGamer(Game game, char symbol) {
		this.game = game;
		this.symbol = symbol;
	}

	/**
	 * Read coordinates, check them
	 * Make a next move on the game board or display an error message
	 * @param scanner command text scanner
	 */
	@Override
	public void play(Scanner scanner) {
		System.out.println("Enter the coordinates:");
		String coordinatesLine = scanner.nextLine().trim().replace(" ", "");
		char[] userCoordinates = coordinatesLine.toCharArray();
		int gameCoordinate = GAME_COORDINATES.indexOf(coordinatesLine);

		ValidationResult validationResult = isValidCoordinates(game, userCoordinates, gameCoordinate);
		if (validationResult == ValidationResult.OK) {
			makeMove(gameCoordinate);
			OutputUtils.showGameField(game.getBoard());
		} else {
			System.out.println(validationResult);
			play(scanner);
		}
	}

	private void makeMove(int coordinate) {
		game.fillCell(coordinate, symbol);
	}

	private ValidationResult isValidCoordinates(Game game,
	                                            char[] userCoordinates,
	                                            int coordinate) {
		if (!areDigits(userCoordinates)) {
			return ValidationResult.NOT_NUMBER;
		}
		if (!areInRange(userCoordinates)) {
			return ValidationResult.NOT_IN_RANGE;
		}
		if (game.isNotEmptyCell(coordinate)) {
			return ValidationResult.OCCUPIED;
		}
		return ValidationResult.OK;
	}

	private boolean areDigits(char[] coordinates) {
		return Character.isDigit(coordinates[0]) && Character.isDigit(coordinates[1]);
	}

	private boolean areInRange(char[] coordinates) {
		int x = coordinates[0] - '0';
		int y = coordinates[1] - '0';
		return x > 0 && x < 4 && y > 0 && y < 4;
	}
}
