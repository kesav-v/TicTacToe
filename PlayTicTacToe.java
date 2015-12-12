public class PlayTicTacToe {
	public static void main(String[] args) {
		int turns = 0;
		boolean xTurn = true;
		int[][] board = new int[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
		while (turns < 9 && TicTacToe.evaluate(board, xTurn, turns) == 0) {
			System.out.println();
			for (int[] row : board) {
				for (int j : row) {
					switch (j) {
						case -1: System.out.print("O "); break;
						case 0: System.out.print("- "); break;
						case 1: System.out.print("X "); break;
					}
				}
				System.out.println("\n");
			}
			int x = Prompt.getInt("Enter an x-coordinate -> ", 0, 2);
			int y = Prompt.getInt("Enter an y-coordinate -> ", 0, 2);
			turns++;
			if (xTurn) board[x][y] = 1;
			else board[x][y] = -1;
			xTurn = !xTurn;
			int result = TicTacToe.addPiece(board, xTurn, turns);
			switch (result) {
				case -1: System.out.println("\nO is winning"); break;
				case 0: System.out.println("\nIt's a tie"); break;
				case 1: System.out.println("\nX is winning"); break;
			}
		}
	}
}