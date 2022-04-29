package starb.puzzle;

import java.util.ArrayList;

public class PuzzleAdt {

    private int[][] board;
    private int numStars;
    private ArrayList<Coordinate> solution;

    public PuzzleAdt(int[][] board, int numStars, ArrayList<Coordinate> solution){
        this.board = board;
        this.numStars = numStars;
        this.solution = solution;
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