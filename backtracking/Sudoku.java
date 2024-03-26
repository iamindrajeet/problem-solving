package backtracking;

import java.util.*;

public class Sudoku {

    // Method to solve the Sudoku puzzle
    public boolean solveSudoku(List<List<String>> board) {
        int[][] sudokuBoard = new int[9][9];
        
        // Convert string board to integer board
        for (int i = 0; i < 9; i++) {
            List<String> row = board.get(i);
            for (int j = 0; j < 9; j++) {
                if (!row.get(j).equals(".")) {
                    sudokuBoard[i][j] = Integer.parseInt(row.get(j));
                } else {
                    sudokuBoard[i][j] = 0;
                }
            }
        }
        
        return solve(sudokuBoard, 0, 0); // Start solving from the top-left cell
    }

    // Recursive backtracking method to solve Sudoku
    private boolean solve(int[][] board, int row, int col) {
        // Base case: If all rows are processed, print the solution
        if (row == 9) {
            printSolution(board);
            return true;
        }

        // Move to the next row if current row is fully processed
        if (col == 9)
            return solve(board, row + 1, 0);

        // If the cell is not empty, move to the next column
        if (board[row][col] != 0)
            return solve(board, row, col + 1);

        boolean isValid = false;
        // Try placing numbers from 1 to 9 in the empty cell
        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num; // Place the number
                
                // Recursively solve for the next cell
                if (solve(board, row, col + 1)) {
                    isValid = true;
                    // return isValid; // Uncomment this line to find only one solution
                }
                // Backtrack if the solution couldn't be found
                board[row][col] = 0;
            }
        }
        return isValid;
    }

    // Check if a number can be placed in the given cell
    private boolean isValid(int[][] board, int row, int col, int num) {
        // Check the row, column, and subgrid for conflicts
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false; // Conflict found
            }
        }
        return true; // No conflict found
    }

    // Print the Sudoku board
    private void printSolution(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main method to test the Sudoku solver
    public static void main(String[] args) {
        List<List<String>> sudokuBoard = new ArrayList<>();
        sudokuBoard.add(Arrays.asList("5", "3", ".", ".", "7", ".", ".", ".", "."));
        sudokuBoard.add(Arrays.asList("6", ".", ".", "1", "9", "5", ".", ".", "."));
        sudokuBoard.add(Arrays.asList(".", "9", "8", ".", ".", ".", ".", "6", "."));
        sudokuBoard.add(Arrays.asList("8", ".", ".", ".", "6", ".", ".", ".", "3"));
        sudokuBoard.add(Arrays.asList("4", ".", ".", "8", ".", "3", ".", ".", "1"));
        sudokuBoard.add(Arrays.asList("7", ".", ".", ".", "2", ".", ".", ".", "6"));
        sudokuBoard.add(Arrays.asList(".", "6", ".", ".", ".", ".", "2", "8", "."));
        sudokuBoard.add(Arrays.asList(".", ".", ".", "4", "1", "9", ".", ".", "5"));
        sudokuBoard.add(Arrays.asList(".", ".", ".", ".", "8", ".", ".", "7", "9"));

        Sudoku solver = new Sudoku();
        solver.solveSudoku(sudokuBoard);
    }
}
