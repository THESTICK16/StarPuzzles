package starb.client;

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
        x = x/550/10;
        y = y/550/10;

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
        // String puzzleString = TODO Get puzzle from server

        String puzzleString = "10 2 \n \n" +"0,0,0,0,0,0,0,0,1,1\n"+
                "0,0,0,0,0,0,4,0,1,1\n"+
                "2,3,3,3,0,4,4,4,1,1\n"+
                "2,2,2,2,5,6,6,4,1,1\n"+
                "2,2,2,5,5,5,6,6,1,1\n"+
                "2,2,7,5,5,5,6,6,1,1\n"+
                "2,2,7,7,7,6,6,6,8,1\n"+
                "2,2,2,2,2,2,6,6,8,1\n"+
                "2,9,9,9,9,9,9,9,8,8\n"+
                "9,9,9,9,9,9,9,9,9,8" + "\n\n ";

        g = new ClientGameState(puzzleString);
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
