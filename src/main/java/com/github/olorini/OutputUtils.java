package com.github.olorini;

public class OutputUtils {

	public static void showGameField(char[] game) {
		System.out.println("---------");
		System.out.print("|");
		for (int i = 0; i < 9; i++) {
			if ( i > 0 && i % 3 == 0) {
				System.out.print(" |\n|");
			}
			System.out.print(" " + game[i]);
		}
		System.out.println(" |\n---------");
	}
}
