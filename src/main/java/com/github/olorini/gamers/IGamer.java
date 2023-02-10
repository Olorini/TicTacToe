package com.github.olorini.gamers;

import java.util.Scanner;

/**
 * An interface describes the gamer
 */
public interface IGamer {

	/**
	 * Make a next move in the game
	 * @param scanner command text scanner
	 */
	void play(Scanner scanner);

}
