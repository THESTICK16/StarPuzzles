package starb.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class PuzzleADTClient {
    private int x;
    private int y;
    private HashMap<Integer, boolean[]> sectionsRow = new HashMap<>();
    private HashMap<Integer, boolean[]> sectionsCol = new HashMap<>();

    public PuzzleADTClient(){

        String s1 = "0,0,0,0,0,0,0,0,1,1\n"+
                    "0,0,0,0,0,0,4,0,1,1\n"+
                    "2,3,3,3,0,4,4,4,1,1\n"+
                    "2,2,2,2,5,6,6,4,1,1\n"+
                    "2,2,2,5,5,5,6,6,1,1\n"+
                    "2,2,7,5,5,5,6,6,1,1\n"+
                    "2,2,7,7,7,6,6,6,8,1\n"+
                    "2,2,2,2,2,2,6,6,8,1\n"+
                    "2,9,9,9,9,9,9,9,8,8\n"+
                    "9,9,9,9,9,9,9,9,9,8";

        Scanner scan = new Scanner(s1);
        int colIndex =0;
        char[][] grid = new char[10][10];
        int index = 0;
        while(scan.hasNextLine()){
            
            String line = scan.nextLine();
            for(int i =0; i <line.length(); i = i +2){
                //every other char
                char curr = line.charAt(i);
                //add to row array
                grid[index][colIndex] = curr;
                colIndex++;
            }
            index++;
            colIndex=0;
        }
        scan.close();

        
        
        //ROWS ARRAY
        for(int j =0; j < grid.length ; j++){ //rows
            boolean[] row1 = new boolean[10];
            for(int k =0; k < grid.length ; k++){ //columns
                char cur = grid[j][k];
                char next;
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

        //COLUMNS ARRAY
        for(int j =0; j < grid.length ; j++){ //columns
            boolean[] col1 = new boolean[10];
            for(int k =0; k < grid.length ; k++){ //rows
                char cur = grid[k][j];
                char next;
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
        


        
    }

    public int size(){
        int size = sectionsRow.size();
        return size;
    }

    public boolean getBoldRows(int row, int index){
        boolean[] result = sectionsRow.get(row);
        return result[index];
    }

    public boolean getBoldCols(int col, int index){
        boolean[] result = sectionsCol.get(col);
        return result[index];
    }

}
