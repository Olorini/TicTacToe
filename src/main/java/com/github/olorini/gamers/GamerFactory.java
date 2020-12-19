package com.github.olorini.gamers;

import com.github.olorini.gameProcesses.TicTacToe;

public class GamerFactory {

	public static IGamer create(String type, TicTacToe game, char symbol) {
		switch (type) {
			case "user":
				return new HumanGamer(game, symbol);
			case "easy":
				return new EasyAlGamer(game, symbol);
			case "medium":
				return new MediumAlGamer(game, symbol);
			default: throw new RuntimeException("Unknown");
		}
	}
}
