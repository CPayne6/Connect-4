import java.util.Scanner;

public class connectFour {

	public static void main(String[] args) {
		String play = "y";
		Scanner in = new Scanner(System.in);
		while (play.equals("y")) {
			int turn = 1;
			System.out.println("Welcome to connect four"
					+ "\n\nPlayer one is \"@\" and Player two is \"X\""
					+ "\n\nThe board looks like this:"
					+ "\n\n1 2 3 4 5 6 7\nv v v v v v v" + "\nO O O O O O O"
					+ "\nO O O O O O O" + "\nO O O O O O O" + "\nO O O O O O O"
					+ "\nO O O O O O O" + "\nO O O O O O O"
					+ "\n\nPlayer one goes first");
			int[][] board = new int[7][6];
			int win = 0;
			while (win == 0) {
				System.out
						.println("please enter which collum you want to play in:");
				int place = in.nextInt();
				while (place - 1 < -1 || place - 1 >= 7) {
					System.out
							.println("please enter a number from 1 to 7 (including 7): ");
					place = in.nextInt();
				}
				while (board[place - 1][5] != 0) {
					System.out
							.println("that collum is already full, please choose another collum: ");
					place = in.nextInt();
				}
				for (int i = 0; i <= 5; i++) {
					if (turn == 1 && board[place - 1][i] == 0) {
						board[place - 1][i] = 1;
						i = 5;
					} else if (board[place - 1][i] == 0) {
						board[place - 1][i] = 2;
						i = 5;
					}
				}
				System.out.println("\n" + outputBoard(board));

				win = findWinner(board);
				if (win == 1) {
					System.out.println("\n\n\nPLAYER 1 WINS!!!!!!!");
				} else if (win == 2) {
					System.out.println("\n\n\nPLAYER 2 WINS!!!!!!!\n");
				} else if (win == 4) {
					System.out.println("TIE GAME... THERE ARE NO MORE MOVES");
				} else {
					if (turn == 1) {
						turn = 2;
						System.out.println("it is now player 2's turn");
					} else {
						turn = 1;
						System.out.println("it is now player 1's turn");
					}
				}
			}
			System.out.println("want to play again? y=yes n=no");
			play = in.next();
			while (!play.equals("y") && !play.equals("n")) {
				System.out
						.println("please enter a 'y' for yes or a 'n' for no");
				play = in.next();
			}
		}
		System.out.println("\n\nthanks for playing");
		in.close();
	}

	public static String outputBoard(int[][] board) {
		String output = "1 2 3 4 5 6 7\nv v v v v v v\n";
		for (int i = 5; i >= 0; i--) {
			for (int num = 0; num <= 6; num++) {
				if (board[num][i] == 0)
					output += "O ";
				else if (board[num][i] == 1)
					output += "@ ";
				else
					output += "X ";
			}
			output += "\n";
		}
		return output;
	}

	public static int findWinner(int[][] board) {
		// check diagonal
		for (int i = 0; i <= 3; i++) {
			for (int num = 0; num <= 2; num++) {
				if (board[i][num] == 1 && board[i + 1][num + 1] == 1
						&& board[i + 2][num + 2] == 1
						&& board[i + 3][num + 3] == 1) {
					return 1;
				} else if (board[i][num] == 2 && board[i + 1][num + 1] == 2
						&& board[i + 2][num + 2] == 2
						&& board[i + 3][num + 3] == 2) {
					return 2;
				}
			}
		}
		// check diagonal
		for (int i = 6; i >= 3; i--) {
			for (int num = 0; num <= 2; num++) {
				if (board[i][num] == 1 && board[i - 1][num + 1] == 1
						&& board[i - 2][num + 2] == 1
						&& board[i - 3][num + 3] == 1) {
					return 1;
				} else if (board[i][num] == 2 && board[i - 1][num + 1] == 2
						&& board[i - 2][num + 2] == 2
						&& board[i - 3][num + 3] == 2) {
					return 2;
				}
			}
		}
		// check horizontal
		for (int i = 0; i <= 5; i++) {
			for (int num = 0; num <= 3; num++) {
				if (board[num][i] == 1 && board[num + 1][i] == 1
						&& board[num + 2][i] == 1 && board[num + 3][i] == 1) {
					return 1;
				} else if (board[num][i] == 2 && board[num + 1][i] == 2
						&& board[num + 2][i] == 2 && board[num + 3][i] == 2) {
					return 2;
				}
			}
		}
		// check vertical
		for (int i = 0; i <= 6; i++) {
			for (int num = 0; num <= 2; num++) {
				if (board[i][num] == 1 && board[i][num + 1] == 1
						&& board[i][num + 2] == 1 && board[i][num + 3] == 1) {
					return 1;
				} else if (board[i][num] == 2 && board[i][num + 1] == 2
						&& board[i][num + 2] == 2 && board[i][num + 3] == 2) {
					return 2;
				}
			}
		}
		if (board[0][5] != 0 && board[1][5] != 0 && board[2][5] != 0
				&& board[3][5] != 0 && board[4][5] != 0 && board[5][5] != 0
				&& board[6][5] != 0) {
			return 4;
		}
		return 0;
	}
}