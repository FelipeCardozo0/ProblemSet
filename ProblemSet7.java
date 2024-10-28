import java.util.Scanner;

public class ProblemSet7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] grid = createGrid();
        int turn = 1;
        String player = "Red";
        boolean winner = false;

        while (winner == false && turn <= 42){
            boolean validPlay = false;
            int play = -1;
            while(!validPlay){
                displayGrid(grid);
                System.out.print("Player " + player + ", choose a column: ");
                play = in.nextInt();
                validPlay = validate(grid, play);
            }

            placeToken(grid, play, player);
            winner = isWinner(grid, player);

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
                grid[i][j] = '-';
            }
        }
        return grid;
    }

    public static void displayGrid(char[][] grid) {
        System.out.println("1 2 3 4 5 6 7");
        for (int i = 0; i < grid.length; i++) {
            System.out.println("---------------");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print("|" + (grid[i][j] == '-' ? " " : grid[i][j]));
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }

    public static boolean validate(char[][] grid, int play) {
        if (play < 1 || play > 7) {
            return false;
        }
        int column = play - 1;
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][column] == '-') {
                return true;
            }
        }
        return false;
    }

    public static void placeToken(char[][] grid, int play, String player) {
        char token = player.equals("Red") ? 'R' : 'B';
        int column = play - 1;
        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][column] == ' ') {
                grid[row][column] = token;
                break;
            }
        }
    }

    public static boolean winHorizontal(char[][] grid, String player) {
        char token = player.equals("Red") ? 'R' : 'B';
        for (int row = 0; row < grid.length; row++) {
            int count = 0;
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == token) {
                    count++;
                    if (count == 4) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public static boolean winVertical(char[][] grid, String player) {
        char token = player.equals("Red") ? 'R' : 'B';
        for (int col = 0; col < grid[0].length; col++) {
            int count = 0;
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == token) {
                    count++;
                    if (count == 4) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public static boolean winDiagonal(char[][] grid, String player) {
        char token = player.equals("Red") ? 'R' : 'B';
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[row].length - 3; col++) {
                if (grid[row][col] == token && grid[row + 1][col + 1] == token &&
                        grid[row + 2][col + 2] == token && grid[row + 3][col + 3] == token) {
                    return true;
                }
            }
        }
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 3; col < grid[row].length; col++) {
                if (grid[row][col] == token && grid[row + 1][col - 1] == token &&
                        grid[row + 2][col - 2] == token && grid[row + 3][col - 3] == token) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWinner(char[][] grid, String player) {
        return winHorizontal(grid, player) || winVertical(grid, player) || winDiagonal(grid, player);
    }
}

