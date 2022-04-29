package tests;

import org.junit.jupiter.api.Test;
import starb.puzzle.Parser;
import starb.puzzle.PuzzleAdt;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    Parser p = new Parser();
    String boardRep = "10 2\n" +
            "\n" +
            "0,0,0,0,0,0,0,0,1,1\n" +
            "0,0,0,0,0,0,4,0,1,1\n" +
            "2,3,3,3,0,4,4,4,1,1\n" +
            "2,2,2,2,5,6,6,4,1,1\n" +
            "2,2,2,5,5,5,6,6,1,1\n" +
            "2,2,7,5,5,5,6,6,1,1\n" +
            "2,2,7,7,7,6,6,6,8,1\n" +
            "2,2,2,2,2,2,6,6,8,1\n" +
            "2,9,9,9,9,9,9,9,8,8\n" +
            "9,9,9,9,9,9,9,9,9,8\n" +
            "\n" +
            "0,1 0,4 1,6 1,8 2,1 2,3 3,7 3,9 4,3 4,5 5,0 5,7 6,2 6,4 7,6 7,8 8,0 8,2 9,5 9,9";


    @Test
    void puzzleFileToString() {
        String result = p.puzzleFileToString("puzzles/puzzle-1-1-1.txt");

        String expected = boardRep;

        assertEquals(expected,result);

    }

    @Test
    void boardToString() {
        PuzzleAdt puzzle = new PuzzleAdt();
        puzzle.initializePuzzle(boardRep);

        String result = p.boardToString(puzzle);

        String expected = boardRep;

        assertEquals(expected, result);
    }

    @Test
    void stringToBoard() {
        PuzzleAdt puzzle = new PuzzleAdt();

        assertNotEquals(puzzle, p.stringToBoard(boardRep));
    }

    //TODO add test to check for board similarity in string to board conversion

    @Test
    void getNumStars() {
        assertEquals(2, p.getNumStars(boardRep));
    }

    //TODO add test for getSolution and getBoard (Methods working just not tested)

    @Test
    void getSolution(){
        System.out.println(p.getSolution(boardRep));
    }

    @Test
    void getBoard() {
        int[][] boardTest = p.getBoard(boardRep);

        for(int i = 0; i < boardTest.length; i++){
            for(int j = 0; j < boardTest.length; j++){
                System.out.print(boardTest[i][j] + " ");
            }
            System.out.println();
        }

    }
}