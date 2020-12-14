package com.github.olorini.gameProcesses;

import com.github.olorini.TicTacToe;
import com.github.olorini.gamers.AlGamer;
import com.github.olorini.gamers.HumanGamer;

import static com.github.olorini.TicTacToe.O;
import static com.github.olorini.TicTacToe.X;

public class GameProcessFactory {

	public static GameProcess getProcess(String type, TicTacToe game) {
		switch (type) {
			case "user medium":
				return new GameProcess(game, new HumanGamer(game, X), new AlGamer(game, O));
			case "medium user":
				return new GameProcess(game, new AlGamer(game, X), new HumanGamer(game, O));
			case "user user":
				return new GameProcess(game, new HumanGamer(game, X), new HumanGamer(game, O));
			case "medium medium":
				return new GameProcess(game, new AlGamer(game, X), new AlGamer(game, O));
			default: throw new RuntimeException("Unknown");
		}
	}
}
