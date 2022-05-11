package starb.client;

import java.util.HashMap;

public class ClientInteraction {

    private ClientGameState g;

    public ClientInteraction(){

    }

    /*
    *
    */
    public int cellLength(int x, int y)
    {
        //write code here that does the math, and when you call it from the puzzle drawing panel it will
        //have the location automatically.
        //getWidth
        //getHeight / pixels

        //Dimensions of the board.
        int xDim = 550/10; //width of board divided by how many grids gives cell length by pix.
        int yDim = 550/10; //height of board divided by how many grids

        //xcord of mouse click / the length of the cell which will give u what grid youre in.

        return 0;
    }
    /*
    * Determines if the user adds a star to the grid or not based on mouse click.
    * @Param: grid location? call alterboard. gamestate.star or whatever
    */
    public void boardClick() {
        /* TODO get coordinate x and y of board click in relation to grid coordinate
        int x
        int y
        if(g.getSquare(x,y) == SPACE){
            g.setStar(x,y)
            draw g.getGameState()
        }else if(g.getSquare(x,y) == STAR){
            g.setPoint(x,y)
            draw g.getGameState()
        }else{
            g.setSpace(x,y)
            draw g.getGameState()
        */

    }

    /*
    * This will load a puzzle in. If the user mouse click on the button to load a puzzle in, this method
    * will send a request to the server to load a new puzzle in.
    */
    public void loadPuzzle() {
        // String puzzleString = TODO Get puzzle from server
        // g = new ClientGameState(puzzleString);
        // draw g.getBoard() TODO draw method
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
            sectionsCol.put(j, row1);
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

}
