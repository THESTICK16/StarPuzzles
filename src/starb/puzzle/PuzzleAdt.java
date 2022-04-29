package starb.puzzle;

import java.util.ArrayList;

public class PuzzleAdt {

    private int[][] board;
    private int numStars;
    private ArrayList<Coordinate> solution;
    private Parser p = new Parser();

    public PuzzleAdt(){}

    public PuzzleAdt(String boardRepresentation){
        board = p.getBoard(boardRepresentation);
        numStars = p.getNumStars(boardRepresentation);
        solution = p.getSolution(boardRepresentation);
    }

    public void initializePuzzle(String boardRepresentation) {
        board = p.getBoard(boardRepresentation);
        numStars = p.getNumStars(boardRepresentation);
        solution = p.getSolution(boardRepresentation);
    }

    public int[][] getBoard() {
        return board;
    }

    public int getNumStars() {
        return numStars;
    }

    public ArrayList<Coordinate> getSolution() {
        return solution;
    }

}