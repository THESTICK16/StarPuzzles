package starb.puzzle;

import com.sun.source.tree.Tree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Parser {

    public Parser(){}

    public String puzzleFileToString(String fileName){
        StringBuilder finalString = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        // Reading File
        File puzzle = new File(fileName);
        try {
            Scanner scan = new Scanner(puzzle);
            while(scan.hasNextLine()){
                sb.append(scan.nextLine());
                sb.append("\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        String unformatted = sb.toString();
        sb.setLength(0);

        // Dividing by line into array
        String[] line = unformatted.split("\n");

        // Pulling dimension and star data
        finalString.append(line[1]);

        finalString.append("\n\n");

        // Pulling Board
        int [][] board = new int[Integer.parseInt(line[1].split(" ")[0])][Integer.parseInt(line[1].split(" ")[0])];

        int count = 0;
        for(int i = 2; i < line.length-2; i++){
            String[] currCoordinates = line[i].split(" ");
            for(int j = 0; j < currCoordinates.length; j++){
                int x = Integer.parseInt(currCoordinates[j].split(",")[0]);
                int y = Integer.parseInt(currCoordinates[j].split(",")[1]);
                board[x][y] = count;
            }
            count++;
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                finalString.append(board[i][j]);
                finalString.append(",");
            }
            finalString.deleteCharAt(finalString.length()-1);
            finalString.append("\n");
        }


        finalString.append("\n");

        // Pulling Solution
        finalString.append(line[line.length-1]);


        return finalString.toString();
    }

    public String boardToString(PuzzleAdt p){
        int[][] board = p.getBoard();
        ArrayList<Coordinate> solution = p.getSolution();
        int numStars = p.getNumStars();
        int dimension = board.length;

        StringBuilder sb = new StringBuilder();

        // Handles first line (dimension and number of stars)
        sb.append(dimension);
        sb.append(" ");
        sb.append(numStars);

        sb.append("\n\n");

        // Handles the board portion of the puzzle
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }

        sb.append("\n");

        //Handles the solution part of the puzzle
        for(int i = 0; i < solution.size(); i++){
            sb.append(solution.get(i).toString());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public PuzzleAdt stringToBoard(String boardString){
        PuzzleAdt p = new PuzzleAdt(boardString);
        return p;
    }




    public int getNumStars(String boardString){

        return Integer.parseInt(boardString.split("\n\n")[0].split(" ")[1]);
    }

    public int[][] getBoard(String boardString){
        String[] board = boardString.split("\n\n")[1].split("\n");
        int[][] b = new int[board.length][board.length];

        for(int i = 0; i < board.length; i++){
            String[] values = board[i].split(",");
            for(int j = 0; j < values.length; j++){
                b[i][j] = Integer.parseInt(values[j]);
            }
        }
        return b;
    }

    public ArrayList<Coordinate> getSolution(String boardString){
        String[] solution = boardString.split("\n\n")[2].split(" ");
        ArrayList<Coordinate> l = new ArrayList<>();
        for(int i = 0; i < solution.length; i++){
            Coordinate c = new Coordinate(Integer.parseInt(solution[i].split(",")[0]),Integer.parseInt(solution[i].split(",")[1]));
            l.add(c);
        }
        return l;
    }

}
