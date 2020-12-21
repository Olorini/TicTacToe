package com.github.olorini.gamers;

import com.github.olorini.gameProcesses.Game;

public class GamerFactory {

	public static IGamer create(String type, Game game, char symbol) {
		switch (type) {
			case "user":
				return new HumanGamer(game, symbol);
			case "easy":
				return new EasyAlGamer(game, symbol);
			case "medium":
				return new MediumAlGamer(game, symbol);
			case "hard":
				return new HardAIGamer(game, symbol);
			default: throw new RuntimeException("Unknown");
		}
	}
}
