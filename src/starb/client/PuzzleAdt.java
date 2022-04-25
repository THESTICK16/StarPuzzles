package starb.client;

public class PuzzleAdt{

    private int width;
    private int height;
    private int[][] board = new int[width][height];

    public PuzzleAdt(){
        width = 10;
        height = 10;

        //TODO add parser initialization and read file to create board
    }

    public int[][] getBoard() {
        return board;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < width; i++){
            sb.append("__");
        }

        return sb.toString();
    }

}