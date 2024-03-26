package backtracking;

import java.util.Arrays;

public class NQueensProblem {

	// Helper function to print the board
	private static void printSolution(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	// Helper function to check if a queen can be placed safely at board[row][col]
	private static boolean isSafe(int row, int col, char[][] board) {
		// Check if there is any queen in the same row of previous columns
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 'Q') {
				return false;
			}
		}
		// Check upper diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		// Check lower diagonal
		for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}

	// Main backtracking function to solve N-Queens problem
	private static boolean solveNQueens(int col, char[][] board) {
		// Base case: all queens are placed
		if (col >= board.length) {
			printSolution(board);
			return true;
		}

		boolean isValid = false;
		// Try placing queens in all possible rows for the current column
		for (int i = 0; i < board.length; i++) {
			if (isSafe(i, col, board)) {
				board[i][col] = 'Q'; // Place the queen
				// Recur for the next column
				if (solveNQueens(col + 1, board)) {
					isValid = true;
					// return isValid; // Uncomment for only one solution
				}
				// Backtrack: Remove the queen from current cell
				board[i][col] = '.';
			}
		}
		return isValid;
	}

	// Main method
	public static void main(String[] args) {
		int N = 4;
		char[][] board = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(board[i], '.'); // Initialize board with empty cells
		}

		if (!solveNQueens(0, board)) {
			System.out.println("Solution doesn't exist.");
		}
	}
}
