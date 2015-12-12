public class PlayTicTacToe {
	public static void main(String[] args) {
		int turns = 0;
		boolean xTurn = true;
		int[][] board;
		if (args.length == 0)
			board = new int[3][3];
		else {
			int s;
			try {
				s = Integer.parseInt(args[0]);
			} catch (Exception e) {
				s = 3;
			}
			board = new int[s][s];
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
		while (turns < board.length * board[0].length && TicTacToe.evaluate(board, xTurn, turns) == 0) {
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
			int x = Prompt.getInt("Enter an x-coordinate -> ", 0, board.length - 1);
			int y = Prompt.getInt("Enter an y-coordinate -> ", 0, board[0].length - 1);
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