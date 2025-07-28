package TicTacToesimple;

import java.util.Scanner;

public class SimpleTicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create 3x3 board
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentPlayer = 'X'; // Player X starts first
        boolean gameOver = false;

        while (!gameOver) {
            // Print the board
            printBoard(board);

            // Take input
            System.out.println("Player " + currentPlayer + " turn");
            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = sc.nextInt();

            // Check valid input
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move! Try again.");
                continue; // Skip this loop and ask again
            }

            // Place the player's mark
            board[row][col] = currentPlayer;

            // Check if current player wins
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                gameOver = true;
            } 
            // Check if board is full
            else if (isFull(board)) {
                printBoard(board);
                System.out.println("😐 It's a draw!");
                gameOver = true;
            } 
            else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    // Function to print the board
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check if the player wins
    public static boolean checkWin(char[][] board, char p) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;

        return false;
    }

    // Check if the board is full
    public static boolean isFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
