package tests;

import org.junit.jupiter.api.Test;
import starb.Coordinate;
import starb.PuzzleAdt;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class PuzzleAdtTest {
    PuzzleAdt pFile = new PuzzleAdt("puzzles/puzzle-1-1-1.txt");



    @Test
    void toStringTest(){
        String expected = """
                [1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,2 ,2 ]
                [1 ,1 ,1 ,1 ,1 ,1 ,5 ,1 ,2 ,2 ]
                [3 ,4 ,4 ,4 ,1 ,5 ,5 ,5 ,2 ,2 ]
                [3 ,3 ,3 ,3 ,6 ,7 ,7 ,5 ,2 ,2 ]
                [3 ,3 ,3 ,6 ,6 ,6 ,7 ,7 ,2 ,2 ]
                [3 ,3 ,8 ,6 ,6 ,6 ,7 ,7 ,2 ,2 ]
                [3 ,3 ,8 ,8 ,8 ,7 ,7 ,7 ,9 ,2 ]
                [3 ,3 ,3 ,3 ,3 ,3 ,7 ,7 ,9 ,2 ]
                [3 ,10,10,10,10,10,10,10,9 ,9 ]
                [10,10,10,10,10,10,10,10,10,9 ]
                """;

        assertEquals(expected,pFile.toString());
    }
}