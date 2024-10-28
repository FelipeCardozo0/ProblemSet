import java.util.Scanner;

public class ProblemSet7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // to get input from players

        char[][] grid = createGrid();

        int turn = 1;
        String player = "Red";
        boolean winner = false;

        //while loop to play the game until either there is a winner or the board is full
        while (winner == false && turn <= 42){
            boolean validPlay = false;
            int play = -1;
            while(!validPlay){
                displayGrid(grid);
                System.out.print("Player " + player + ", choose a column: ");
                play = in.nextInt(); // receive input from player

                // validate play
                validPlay = validate(grid, play);

            }

            // place the token
            placeToken(grid, play, player);

            //determine if there is a winner
            winner = isWinner(grid, player);

            //switch players
            if (player.equals("Red")){
                player = "Blue";
            }else{
                player = "Red";
            }

            turn++;
        }
        displayGrid(grid);

        if (winner){
            if (player.equals("Red")){
                System.out.println("Player 2 (Blue) won");
            }else{
                System.out.println("Player 1 (Red) won");
            }
        }else{
            System.out.println("Tie game");
        }




    }
    public static char[][] createGrid() {
        char[][] grid = new char[6][7];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = ' ';
            }
        }

        return grid;
    }

    public static void displayGrid(char[][] grid) {
        // Display column numbers
        System.out.println("1 2 3 4 5 6 7");


        for (int i = 0; i < grid.length; i++) {
            System.out.println("---------------"); // dashed line for each row
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print("|" + (grid[i][j] == ' ' ? " " : grid[i][j])); // use space for empty cells
            }
            System.out.println("|"); // End of row
        }
        System.out.println("---------------"); // Final dashed line below the grid
    }

    public static boolean validate(char[][] grid, int play) {
        // Check if play is within the valid column range (1 to 7)
        if (play < 1 || play > 7) {
            return false;
        }

        // Check if there is an empty space in the specified column
        int column = play - 1; // Adjust for zero-based index
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][column] == ' ') { // Assuming ' ' represents an empty space
                return true;
            }
        }

        return false; // No empty spaces in the column
    }

    public static void placeToken(char[][] grid, int play, String player) {
        // Determine the token based on the player
        char token = player.equals("Red") ? 'R' : 'B';

        int column = play - 1; // Adjust for zero-based index

        // Place the token in the lowest empty position in the specified column
        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][column] == ' ') { // Assuming ' ' represents an empty space
                grid[row][column] = token;
                break;
            }
        }
    }

    public static boolean winHorizontal(char[][] grid, String player) {
        char token = player.equals("Red") ? 'R' : 'B';

        // Check each row for four consecutive tokens
        for (int row = 0; row < grid.length; row++) {
            int count = 0;
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == token) {
                    count++;
                    if (count == 4) return true; // Found 4 in a row
                } else {
                    count = 0; // Reset count if sequence breaks
                }
            }
        }
        return false; // No horizontal win found
    }

    public static boolean winVertical(char[][] grid, String player) {
        char token = player.equals("Red") ? 'R' : 'B';

        // Check each column for four consecutive tokens
        for (int col = 0; col < grid[0].length; col++) {
            int count = 0;
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == token) {
                    count++;
                    if (count == 4) return true; // Found 4 in a row
                } else {
                    count = 0; // Reset count if sequence breaks
                }
            }
        }
        return false; // No vertical win found
    }

    public static boolean winDiagonal(char[][] grid, String player) {
        char token = player.equals("Red") ? 'R' : 'B';

        // Check for right diagonal (bottom-left to top-right)
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[row].length - 3; col++) {
                if (grid[row][col] == token && grid[row + 1][col + 1] == token &&
                        grid[row + 2][col + 2] == token && grid[row + 3][col + 3] == token) {
                    return true;
                }
            }
        }

        // Check for left diagonal (bottom-right to top-left)
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 3; col < grid[row].length; col++) {
                if (grid[row][col] == token && grid[row + 1][col - 1] == token &&
                        grid[row + 2][col - 2] == token && grid[row + 3][col - 3] == token) {
                    return true;
                }
            }
        }

        return false; // No diagonal win found
    }

    public static boolean isWinner(char[][] grid, String player) {
        // Check for horizontal, vertical, or diagonal win
        return winHorizontal(grid, player) || winVertical(grid, player) || winDiagonal(grid, player);
    }






}
