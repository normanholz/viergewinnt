public class Game {
    public static final int VIER_GEWINNT = 4;
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    public static final int NUMBER_OF_PLAYERS = 2;
    private static final int[][] EMPTY_BOARD = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };
    
    public static int[][] board = EMPTY_BOARD;

    public static int activePlayer = 1;
    public static int winner = 0;

    public static String statusMessage = "";

    public static void startNewGame() {
        activePlayer = 1;
        winner = 0;
        statusMessage = "";
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                board[row][column] = 0;
            }
        }

    }

    public static void playChip(int column) {
        if (winner > 0) {
            return;
        }

        int numberOfChipsInColumn = getNumberOfChipsInColumn(column);
        if (numberOfChipsInColumn < 6) {

            if (activePlayer == 1) {
                activePlayer = 2;
            } else {
                activePlayer = 1;
            }

            int rowForChip = 5 - numberOfChipsInColumn;
            board[rowForChip][column] = activePlayer;

            checkBoard();
        }
    }

    private static int getNumberOfChipsInColumn(int column) {
        int numberOfChipsInColumn = 0;
        for (int row = 5; row >= 0; row--) {
            if (board[row][column] > 0) {
                numberOfChipsInColumn = numberOfChipsInColumn + 1;
            }

        }
        return numberOfChipsInColumn;
    }

    private static int checkRowsForWinner() {

        // TODO check rows for a winner

        return 0;
    }

    private static int checkColumnsForWinner() {

        // TODO check columns for a winner

        return 0;
    }


    private static int checkUpperLeftToLowerRightForWinner() {

        // TODO check diagonals upper left to lower right for a winner

        return 0;
    }

    private static int checkLowerLeftToUpperRight() {

        // TODO check diagonals lower left to upper right for a winner


        return 0;
    }
    private static void checkBoard() {
        // check rows for a winner
        int winnerInRow = checkRowsForWinner();
        if (winnerInRow > 0) {
            statusMessage = "Spieler " + winnerInRow + " hat vier Steine in einer Reihe.";
            winner = winnerInRow;
            activePlayer = 0;
            return;
        }

        // check columns for a winner
        int winnerInColumns = checkColumnsForWinner();
        if (winnerInColumns > 0) {
            statusMessage = "Spieler " + winnerInColumns + " hat vier Steine in einer Spalte.";
            winner = winnerInColumns;
            activePlayer = 0;
            return;
        }

        // check diagonals for a winner
        int winnerInDiagonals = checkUpperLeftToLowerRightForWinner();
        if (winnerInDiagonals > 0) {
            statusMessage = "Spieler " + winnerInDiagonals + " hat vier Steine diagonal.";
            winner = winnerInDiagonals;
            activePlayer = 0;

            return;
        }

        winnerInDiagonals = checkLowerLeftToUpperRight();
        if (winnerInDiagonals > 0) {
            statusMessage = "Spieler " + winnerInDiagonals + " hat vier Steine diagonal.";
            winner = winnerInDiagonals;
            activePlayer = 0;
        }
    }
}
