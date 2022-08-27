
public class Loader {

	public static void main(String[] args) {
		SeaBoard board = new SeaBoard();
		board.shoot(0, 0, "m");
		board.shoot(2, 0, "h");
		board.shoot(6, 9, "h");
		board.shoot(2, 1, "d");
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(board.getField()[i][j]);
			}
			System.out.println("");
		}
	}

}
