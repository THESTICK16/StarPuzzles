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

    /**
     * Note: to get board dimension, call getBoard()
     * @return 2d array of the current board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * @return numStars for victory condition for a given puzzle
     */
    public int getNumStars() {
        return numStars;
    }

    /**
     * @return Arraylist<Coordinate> of the solution star locations
     */
    public ArrayList<Coordinate> getSolution() {
        return solution;
    }



}