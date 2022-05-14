package starb.client;

import starb.puzzle.Coordinate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static starb.client.ClientGameState.SPACE;
import static starb.client.ClientGameState.STAR;

public class ClientInteraction {

    private ClientGameState g;

    public ClientInteraction(){

    }


    /*
    * Determines if the user adds a star to the grid or not based on mouse click.
    * @Param: grid location? call alterboard. gamestate.star or whatever
    */
    public void boardClick(int x, int y) {
        x = convertCoordinate(x);
        y = convertCoordinate(y);

        if(g.getSquare(x,y) == SPACE){
            g.setStar(x,y);
        }else if(g.getSquare(x,y) == STAR){
            g.setPoint(x,y);
        }else{
            g.setSpace(x,y);
        }
    }

    /*
    * This will load a puzzle in. If the user mouse click on the button to load a puzzle in, this method
    * will send a request to the server to load a new puzzle in.
    */
    public void loadPuzzle() {
        //TODO Implement server function
        HttpRequestGenerator generator = new HttpRequestGenerator();
        String puzzleString;

        try {
            puzzleString = generator.getNewPuzzle();
        } catch (IOException e) {
            puzzleString = "10 2\n\n" +"0,0,0,0,0,0,0,0,1,1\n"+
                    "0,0,0,0,0,0,4,0,1,1\n"+
                    "2,3,3,3,0,4,4,4,1,1\n"+
                    "2,2,2,2,5,6,6,4,1,1\n"+
                    "2,2,2,5,5,5,6,6,1,1\n"+
                    "2,2,7,5,5,5,6,6,1,1\n"+
                    "2,2,7,7,7,6,6,6,8,1\n"+
                    "2,2,2,2,2,2,6,6,8,1\n"+
                    "2,9,9,9,9,9,9,9,8,8\n"+
                    "9,9,9,9,9,9,9,9,9,8" + "\n\n0,1 0,4 1,6 1,8 2,1 2,3 3,7 3,9 4,3 4,5 5,0 5,7 6,2 6,4 7,6 7,8 8,0 8,2 9,5 9,9";
//            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            puzzleString = "10 2\n\n" +"0,0,0,0,0,0,0,0,1,1\n"+
                    "0,0,0,0,0,0,4,0,1,1\n"+
                    "2,3,3,3,0,4,4,4,1,1\n"+
                    "2,2,2,2,5,6,6,4,1,1\n"+
                    "2,2,2,5,5,5,6,6,1,1\n"+
                    "2,2,7,5,5,5,6,6,1,1\n"+
                    "2,2,7,7,7,6,6,6,8,1\n"+
                    "2,2,2,2,2,2,6,6,8,1\n"+
                    "2,9,9,9,9,9,9,9,8,8\n"+
                    "9,9,9,9,9,9,9,9,9,8" + "\n\n0,1 0,4 1,6 1,8 2,1 2,3 3,7 3,9 4,3 4,5 5,0 5,7 6,2 6,4 7,6 7,8 8,0 8,2 9,5 9,9";
//            throw new RuntimeException(e);
        }

        g = new ClientGameState(puzzleString);
    }

    public boolean checkInit(){
        if(g!=null){
            return true;
        }
        return false;
    }

    public boolean checkWin(){
        return g.checkWin();
    }

    public HashMap<Integer, boolean[]> getSectionRow(){
        //get intial client game state for sections
        int[][] grid = g.getBoard();

        HashMap<Integer, boolean[]> sectionsRow = new HashMap<>();

        //ROWS ARRAY
        for(int j =0; j < grid.length ; j++){ //rows
            boolean[] row1 = new boolean[10];
            for(int k =0; k < grid.length ; k++){ //columns
                int cur = grid[j][k];
                int next;
                if(j==grid.length-1){
                    next = grid[j][k];
                }else{
                    next = grid[j+1][k];
                }
                
                if( cur != next){
                    row1[k] = true;
                }
                else{
                    row1[k] = false;
                }
            }
            sectionsRow.put(j, row1);
        }

        return sectionsRow;

    }

    public HashMap<Integer, boolean[]> getSectionCol(){
        //get intial client game state for sections
        int[][] grid = g.getBoard();

        HashMap<Integer, boolean[]> sectionsCol = new HashMap<>();

        //COLUMNS ARRAY
        for(int j =0; j < grid.length ; j++){ //columns
            boolean[] col1 = new boolean[10];
            for(int k =0; k < grid.length ; k++){ //rows
                int cur = grid[k][j];
                int next;
                if(j==grid.length-1){
                    next = grid[k][j];
                }
                else{
                    next = grid[k][j+1];
                }
                if( cur != next){
                    col1[k] = true;
                }
                else{
                    col1[k] = false;
                }
            }
            sectionsCol.put(j, col1);
        }

        return sectionsCol;

    }

    public int size( HashMap<Integer, boolean[]> dim){
        int size = dim.size();
        return size;
    }

    public boolean getBoldRows(int row, int index, HashMap<Integer, boolean[]> rowsMap){
        boolean[] result = rowsMap.get(row);
        return result[index];
    }

    public boolean getBoldCols(int col, int index, HashMap<Integer, boolean[]> colMap){
        boolean[] result = colMap.get(col);
        return result[index];
    }


    /**
     * @return the list of stars currently placed on the board
     */
    public ArrayList<Coordinate> getPlacedStars() {
        return g.getPlacedStars();
    }

    /**
     * @return the list of points currently placed on the board
     */
    public ArrayList<Coordinate> getPlacedPoints() {
        return g.getPlacedPoints();
    }

    /**
     * @return the size of one side of the square board
     */
    public int getBoardSize() {
        return g.getBoard().length;
    }

    private int convertCoordinate(int val){
        final int width = 500;
        int dim = g.getGameState().length;
        int threshold = width/dim;

        return val/threshold;
    }
}