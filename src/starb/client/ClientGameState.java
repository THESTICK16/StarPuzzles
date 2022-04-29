package starb.client;

import starb.puzzle.Parser;

import java.util.Arrays;

/**
 * A client end representation of the game state
 */
public class ClientGameState {

//    /**
//     * The puzzle containing the game state
//     */
//    private PuzzleAdt game;

    /**
     * the array containing the representation of the game state
     * ' ' represents an empty square
     * '.' represents a square that has been marked as unusable by the player
     * '*' represents a star that has been placed by the player on that square
     */
    private char[][] game;

    /**
     * A representation of the solved puzzle
     * to be checked against the current game state to determine if the puzzle has been solved
     */
    private char[][] victoryConditions;

    /**
     * The size of the square board
     * measured in length/width, which are equal
     */
    private int boardSize;

    private Parser parser;

    /**
     * constants that contain the values that can be represented in 'game'
     */
    static final char STAR = '*';
    static final char SPACE = ' ';
    static final char CIRCLE = '.';



    /**
     * The game state of the star puzzle
     */
    public ClientGameState() {
        parser = new Parser();
//        game = parser. FIXME what method to call to get the game state as an array
    }

    /**
     * The game state of the star puzzle
     * @param puzzleFilePath a text representation of the file containg the data for the Puzzle
     */
    public ClientGameState(String puzzleFilePath) {
        parser = new Parser(puzzleFilePath);
//        game = parser. FIXME what method to call to get the game state as an array
    }

/*
    public ClientGameState(String boardFilePath, int boardSize) {
        game = new char[boardSize][boardSize];
        this.boardSize = boardSize;
        loadBoard(boardFilePath);
    }
 */

    /**
     * Alters the game state representation to represent an action taken by the player at the indicated location
     * @param action the char that represents the intended state of the altered square, must be one of STAR, SPACE, or DOT
     * @param locationX the x-coordinate at which the star will be added
     * @param locationY the y-coordinate at which the star will be added
     * @return true if the add was successful, false if the add was unsuccessful due to incompatible types
     *      or trying to access an out-of-bounds index on the array
     */
    public boolean alterBoard(char action, int locationX, int locationY) {
        if ((action != STAR && action != SPACE && action != CIRCLE) || locationX >= boardSize || locationY >= boardSize || locationX < 0 || locationY < 0) {
            return false;
        }

        game[locationX][locationY] = action;
        checkVictory(game);

        return true;
    }

    public char[][] getGame() {
        return game;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Game State:\n");

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                s.append(game[i][j] + " ");
                if (j >= boardSize - 1) {
                    s.append("\n");
                }
            }
        }

        return s.toString();
    }

    /**
     * Checks to see if the current state of the board meets the victory conditions
     * @param board the game state to check for victory conditions
     * @return true if puzzle is solved, else false
     */
    public boolean checkVictory(char[][] board) {
        if (Arrays.equals(board, victoryConditions)) {
            return true;
        }

        return false;
    }


//    /**
//     * Sets up the game representation to reflect the initial game state given by the file found at boardFilePath
//     * Called only once from the constructor
//     * @param boardFilePath the name of the file containing the data for the initial state of the desired board
//     * @return true if board is loaded successfully, false if failed
//     */
//    public boolean loadBoard(String boardFilePath) {
//        return false;
//    }
}
