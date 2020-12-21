package com.github.olorini;

import com.github.olorini.gameProcesses.GameProcess;
import com.github.olorini.gameProcesses.Game;
import com.github.olorini.gamers.GamerFactory;
import com.github.olorini.gamers.IGamer;

import java.util.Scanner;

import static com.github.olorini.gameProcesses.Game.O;
import static com.github.olorini.gameProcesses.Game.X;

public class Menu {

	public void start(Scanner scanner) {
		do {
			System.out.println("Input command: ");
			String commandsLine = scanner.nextLine().trim();
			String[] commands = commandsLine.split(" ");
			if (commands.length > 0) {
				String action = commands[0];
				if ("exit".equals(action)) {
					return;
				}
				if (commandsLine.matches("start( user| easy| medium| hard){2}")) {
					String firstGamerType = commands[1];
					String secondGamerType = commands[2];
					Game game = new Game();
					OutputUtils.showGameField(game.getBoard());
					IGamer firstGamer = GamerFactory.create(firstGamerType, game, X);
					IGamer secondGamer = GamerFactory.create(secondGamerType, game, O);
					GameProcess process = new GameProcess(game, firstGamer, secondGamer);
					process.play(scanner);
				} else {
					System.out.println("Bad parameters!");
				}
			} else {
				System.out.println("Bad parameters!");
			}
		} while (true);
	}

}
