package starb.client;

/**
 * A client end representation of the game state
 */
public class ClientGameState {

    /**
     * The puzzle containing the game state
     */
    private PuzzleAdt game;

//    /**
//     * the array containing the representation of the game state
//     * ' ' represents an empty square
//     * '.' represents a square that has been marked as unusable by the player
//     * '*' represents a star that has been placed by the player on that square
//     */
//    private char[][] game;

    /**
     * constants that contain the values that can be represented in 'game'
     */
    //Whoever is making the Puzzle ADT could make these static constants to increase encapsulation (i.e. accessing Puzzle.STAR)
    static final char STAR = '*';
    static final char SPACE = ' ';
    static final char CIRCLE = '.';
    private int boardSize;

    /**
     * The game state of the star puzzle
     * @param game the puzzle containg the game board representation
     */
    public ClientGameState(PuzzleAdt game) {
        this.game = game;
    }

    /**
     * The game state of the star puzzle
     * @param puzzleFilePath a text representation of the file containg the data for the Puzzle
     */
    public ClientGameState(String puzzleFilePath) {
        game = new PuzzleAdt(/*puzzleFilePath*/);
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
        if ((action != STAR && action != SPACE && action != CIRCLE) || locationX >= boardSize || locationY >= boardSize) {
            return false;
        }


        return true;
    }

    public PuzzleAdt getGame() {
        return game;
    }

    public String toString() {
        return null;
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
