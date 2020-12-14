package com.github.olorini;

import com.github.olorini.gameProcesses.GameProcess;
import com.github.olorini.gameProcesses.GameProcessFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static final List<String> USER_TYPES = Arrays.asList("user", "easy", "medium");

	public void start(Scanner scanner) {
		do {
			System.out.println("Input command: ");
			String[] commands = scanner.nextLine().trim().split(" ");
			if (commands.length > 0) {
				String action = commands[0];
				if ("exit".equals(action)) {
					return;
				}
				if (commands.length == 3) {
					String firstGamer = commands[1];
					String secondGamer = commands[2];
					if (!"start".equals(action)
							|| !USER_TYPES.contains(firstGamer)
							|| !USER_TYPES.contains(secondGamer)) {
						System.out.println("Bad parameters!");
						continue;
					}
					char[][] gameState = new char[3][3];
					fillGameField(gameState);
					OutputUtils.showGameField(gameState);
					TicTacToe game = new TicTacToe();
					game.setBoard(gameState);
					String gamersType = firstGamer + " " + secondGamer;
					GameProcess process = GameProcessFactory.getProcess(gamersType, game);
					process.play(scanner);
				} else {
					System.out.println("Bad parameters!");
				}
			} else {
				System.out.println("Bad parameters!");
			}
		} while (true);
	}

	private void fillGameField(char[][] gameState) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameState[i][j] = TicTacToe.EMPTY;
			}
		}
	}

}
