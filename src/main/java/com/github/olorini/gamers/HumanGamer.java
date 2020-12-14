package com.github.olorini.gamers;

import com.github.olorini.OutputUtils;
import com.github.olorini.TicTacToe;

import java.util.Scanner;

public class HumanGamer implements IGamer {

	private final TicTacToe game;
	private final char symbol;

	public HumanGamer(TicTacToe game, char symbol) {
		this.game = game;
		this.symbol = symbol;
	}

	@Override
	public void play(Scanner scanner) {
		System.out.println("Enter the coordinates:");
		String coordinatesLine = scanner.nextLine().trim().replace(" ", "");
		char[] userCoordinates = coordinatesLine.toCharArray();
		int i = userCoordinates[0] - '0';
		int j = userCoordinates[1] - '0';
		int[] digitCoordinates = new int[] {i - 1, j - 1};

		ValidationResult validationResult = isValidCoordinates(game, userCoordinates, digitCoordinates);
		if (validationResult == ValidationResult.OK) {
			makeMove(digitCoordinates[0], digitCoordinates[1]);
			OutputUtils.showGameField(game.getBoard());
		} else {
			System.out.println(validationResult);
			play(scanner);
		}
	}

	public void makeMove(int i, int j) {
		game.fillCell(i, j, symbol);
	}

	private ValidationResult isValidCoordinates(TicTacToe game,
	                                            char[] userCoordinates,
	                                            int[] realCoordinates) {
		if (!areDigits(userCoordinates)) {
			return ValidationResult.NOT_NUMBER;
		}
		if (!areInRange(userCoordinates)) {
			return ValidationResult.NOT_IN_RANGE;
		}
		if (game.isNotEmptyCell(realCoordinates[0], realCoordinates[1])) {
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
