package tests;

import org.junit.jupiter.api.Test;
import starb.puzzle.Coordinate;
import starb.puzzle.Parser;
import starb.puzzle.PuzzleAdt;

import java.util.ArrayList;

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
    void stringToBoardSolution() {
        PuzzleAdt result = p.stringToBoard(boardRep);

        ArrayList<Coordinate> resultSolution = result.getSolution();

        assertEquals("[0,1, 0,4, 1,6, 1,8, 2,1, 2,3, 3,7, 3,9, 4,3, 4,5, 5,0, 5,7, 6,2, 6,4, 7,6, 7,8, 8,0, 8,2, 9,5, 9,9]",resultSolution.toString());
    }

    @Test
    void boardToString() {
        PuzzleAdt result = p.stringToBoard(boardRep);
        String resultString = p.boardToString(result);

        assertEquals(boardRep, resultString);
    }

    @Test
    void fileToStringExample(){
        String example = p.puzzleFileToString(boardRep);
        System.out.println(example);
    }

    @Test
    void stringToBoard(){
        PuzzleAdt puzzle = p.stringToBoard(boardRep);
        String puzzleString = p.boardToString(puzzle);
        System.out.println(puzzleString);
    }
}