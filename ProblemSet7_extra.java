/* This code is my own work. It was written without consulting code written by
        other students or code from online resources.   Felipe Cardozo */

// The game takes too long to end and declare a winner, I recommend changing "int[] ShipSizes = {2,3, 3, 4, 5};"
// to only one ship and test it

import java.util.Scanner;

public class ProblemSet7_extra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            char[][]player1ShipGrid =createGrid();
            char[][]player1AttackGrid =createGrid();
            char[][]player2ShipGrid =createGrid();
            char[][]player2AttackGrid =createGrid();

            placeShips(player1ShipGrid, "Player 1", scanner);

            placeShips(player2ShipGrid, "Player 2", scanner);

            boolean gameOver = false;
            while (!gameOver) {
                displayGrid(player1AttackGrid);
                if (attack(player2ShipGrid, player1AttackGrid, "Player 1", scanner)) {
                    if (isWinner(player2ShipGrid)) {
                        System.out.println("All enemy ships sank");
                        System.out.println("Player 1 wins!");
                        gameOver = true;
                    }
                }

                if (!gameOver) {
                    displayGrid(player2AttackGrid);
                    if (attack(player1ShipGrid, player2AttackGrid, "Player 2", scanner)) {
                        if (isWinner(player1ShipGrid)) {
                            System.out.println("All enemy ships sank");
                            System.out.println("Player 2 wins!");
                            gameOver = true;   }                    } } }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        scanner.close();
    }

    public static char[][] createGrid() {
        char[][] grid = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++){
                grid[i][j] = ' ';
            }
        }
        return grid;
    }

    public static void displayGrid(char[][] grid) {
        System.out.print("   ");
        for (int col = 1; col <= 10; col++) {
            System.out.print(" " + col + "  ");
        }
        System.out.println();

        char rowLabel = 'A';
        for (int i = 0; i < 10; i++) {
            System.out.print(rowLabel + " |");
            rowLabel++;
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + grid[i][j] + " |");
            }
            System.out.println();
        }
    }

    public static void placeShips(char[][] grid, String playerName, Scanner scanner) {
        int[] ShipSizes = {2,3, 3, 4, 5 };

        System.out.println(playerName + ", place your ships");
        for (int ShipSize : ShipSizes) {
            boolean placed = false;
            while (!placed) {
                System.out.println("Place size " + ShipSize + " ship:");
                System.out.print("Enter starting row (A-J): ");
                char rowChar = scanner.next().toUpperCase().charAt(0);
                int row = rowChar - 'A';

                System.out.print("Enter starting column (1-10): ");
                int col = scanner.nextInt() -1 ;

                System.out.print("Enter orientation (H for horizontal, V for vertical): ");
                char orientation = scanner.next().toUpperCase().charAt(0);

                placed = placeShipOnGrid(grid,row,col,ShipSize, orientation);
                if (!placed) {
                    System.out.println("Wrong, try again");
                }
            }
            displayGrid(grid);
        }
    }

    private static boolean placeShipOnGrid(char[][] grid, int row, int col, int size, char orientation) {
        if(orientation == 'H') {
            if (col + size > 10) return false;
            for (int i = 0; i < size; i++) {
                if (grid[row][col + i] != ' ') return false;
            }
            for (int i = 0; i < size; i++) {
                grid[row][col + i] = 'S';
            }
        } else if (orientation == 'V') {
            if (row + size > 10) return false;
            for (int i = 0; i < size; i++){
                if (grid[row + i][col] != ' ') return false;
            }
            for (int i = 0; i < size; i++){
                grid[row + i][col] = 'S';
            }
        } else {
            return false;
        }
        return true;
    }

    public static boolean attack(char[][] opponentGrid, char[][] attackGrid, String playerName, Scanner scanner) {
        System.out.println(playerName + ", it's time to attack!");

        System.out.print("Enter target row (A-J): ");
        char rowChar = scanner.next().toUpperCase().charAt(0);
        int row = rowChar - 'A';

        System.out.print("Enter target column (1-10): ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= 10 || col< 0 || col >= 10) {
            System.out.println("Coordinates out of bounds lol");
            return false;
        }

        if(opponentGrid[row][col] == 'S') {
            System.out.println("It's a hit!");
            opponentGrid[row][col] = 'X';
            attackGrid[row][col] = 'X';
            return true;
        }
        else if(opponentGrid[row][col]==' ') {
            System.out.println("Miss");
            opponentGrid[row][col]='O';
            attackGrid[row][col]='O'; return false;
        }
        else
        {
            System.out.println("Location already attacked");
            return false;
        }    }

    public static boolean isWinner(char[][] opponentGrid) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (opponentGrid[i][j] == 'S') {
                    return false;
                }
            }
        }
        return true;
    }
}
