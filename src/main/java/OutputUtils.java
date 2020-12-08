public class OutputUtils {

	public static void showGameField(char[][] game) {
		System.out.println("---------");
		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + game[i][j]);
			}
			System.out.print(" |\n");
		}
		System.out.println("---------");
	}
}
