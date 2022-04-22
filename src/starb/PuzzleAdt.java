package starb;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PuzzleAdt{

    private int dimension;
    private int[][] board;
    private int numStars;
    private ArrayList<Coordinate> solution;

    public PuzzleAdt(){
        Parser p = new Parser();
    }

    public PuzzleAdt(String fileString){
        Parser p = new Parser(fileString);

        dimension = p.getDimension();
        numStars = p.getStars();
        board = convertData(p.getData(),dimension);
    }

    public int[][] getBoard() {
        return board;
    }

    public int getDimension() {
        return dimension;
    }

    public int getNumStars() {
        return numStars;
    }

    public ArrayList<Coordinate> getSolution() {
        return solution;
    }

    public int[][] convertData(TreeMap<Integer,ArrayList<Coordinate>> map, int dim){
        int[][] b = new int[dim][dim];

        for(Map.Entry<Integer,ArrayList<Coordinate>> entry: map.entrySet()){
            int currEntry = entry.getKey();
            ArrayList<Coordinate> currList = entry.getValue();

            for(int i = 0; i < currList.size(); i++){
                b[currList.get(i).getX()][currList.get(i).getY()] = currEntry;
            }
        }
        return b;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            sb.append('[');
            for(int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
                sb.append(',');
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}