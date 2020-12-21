package com.github.olorini.gameProcesses;

import com.github.olorini.gamers.IGamer;

import java.util.Scanner;

public class GameProcess {

	private final Game gameState;
	private final IGamer firstGamer;
	private final IGamer secondGamer;

	public GameProcess(Game gameState, IGamer firstGamer, IGamer secondGamer) {
		this.gameState = gameState;
		this.firstGamer = firstGamer;
		this.secondGamer = secondGamer;
	}

	public void play(Scanner scanner) {
		GameResult gameResult;
		do {
			firstGamer.play(scanner);
			GameResult firstUserResult = gameState.checkGameState();
			if (firstUserResult.isNotGameOver()) {
				secondGamer.play(scanner);
			}
			gameResult = gameState.checkGameState();
		} while (gameResult.isNotGameOver());
		System.out.println(gameResult);
	}

}
