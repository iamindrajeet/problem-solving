package backtracking;

import java.util.Arrays;

public class KnightsTour {
    static final int N = 5;

    // Helper function to print the board
    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    // Helper function to check if the move is safe
    static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // Main backtracking function to solve Knight's Tour problem
    static boolean knightsTour(int x, int y, int move, int[][] board, int[] xMove, int[] yMove) {
        // If all squares are visited
        if (move == N * N) {
            return true;
        }

        // Try all next moves from the current coordinate x, y
        for (int i = 0; i < 8; i++) {
            int newX = x + xMove[i];
            int newY = y + yMove[i];

            if (isSafe(newX, newY, board)) {
                board[newX][newY] = move;

                if (knightsTour(newX, newY, move + 1, board, xMove, yMove)) {
                    return true;
                }

                // Backtrack
                board[newX][newY] = -1;
            }
        }

        return false;
    }

    // Main method
    public static void main(String[] args) {
        int[][] board = new int[N][N];
        
        // Initialize the board
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], -1);
        }

        // Moves for the knight
        int[] xMove = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] yMove = {1, -1, 1, -1, 2, 2, -2, -2};

        // Start the tour from cell (0, 0)
        board[0][0] = 0;

        // Check if solution exists
        if (!knightsTour(0, 0, 1, board, xMove, yMove)) {
            System.out.println("Solution doesn't exist");
        } else {
            printSolution(board);
        }
    }
}
