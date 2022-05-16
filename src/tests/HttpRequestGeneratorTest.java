package tests;

import org.junit.Before;
import org.junit.Test;
import starb.client.HttpRequestGenerator;
import starb.server.StarbServer;

import java.io.IOException;

import static org.junit.Assert.*;

public class HttpRequestGeneratorTest {
    HttpRequestGenerator hrg;

    @Before
    public void setUp() throws Exception {
        hrg = new HttpRequestGenerator();
    }

    @Test
    public void getNewPuzzle() throws IOException, InterruptedException {
        String puzzle1 = "10 2\n" +
                "0,0 0,1 0,2 0,3 0,4 0,5 0,6 0,7 1,0 1,1 1,2 1,3 1,4 1,5 1,7 2,4\n" +
                "0,8 0,9 1,8 1,9 2,8 2,9 3,8 3,9 4,8 4,9 5,8 5,9 6,9 7,9\n" +
                "2,0 3,0 3,1 3,2 3,3 4,0 4,1 4,2 5,0 5,1 6,0 6,1 7,0 7,1 7,2 7,3 7,4 7,5 8,0\n" +
                "2,1 2,2 2,3\n" +
                "1,6 2,5 2,6 2,7 3,7\n" +
                "3,4 4,3 4,4 4,5 5,3 5,4 5,5\n" +
                "3,5 3,6 4,6 4,7 5,6 5,7 6,5 6,6 6,7 7,6 7,7\n" +
                "5,2 6,2 6,3 6,4\n" +
                "6,8 7,8 8,8 8,9 9,9\n" +
                "8,1 8,2 8,3 8,4 8,5 8,6 8,7 9,0 9,1 9,2 9,3 9,4 9,5 9,6 9,7 9,8\n" +
                "\n" +
                "0,1 0,4 1,6 1,8 2,1 2,3 3,7 3,9 4,3 4,5 5,0 5,7 6,2 6,4 7,6 7,8 8,0 8,2 9,5 9,9";
        String puzzle2 = "10 2\n" +
                "0,0 0,1 0,2 0,3 0,4 0,5 1,0 1,2 1,3 1,4 1,5 1,6 2,0 2,3 2,4 3,4\n" +
                "0,6 0,7 0,8 0,9 1,7 1,8 2,5 2,6 2,7 3,5 3,6 3,7\n" +
                "1,1 2,1 2,2 3,1\n" +
                "1,9 2,8 2,9 3,8 3,9\n" +
                "3,0 4,0 4,1 5,0 5,1 6,0 6,1 7,0 7,1 8,0 8,1\n" +
                "3,2 3,3 4,2 4,3 4,4 5,2 5,3 5,4 5,5 6,2 6,3 7,2 7,3 7,4\n" +
                "4,5 4,6 4,7 4,8 4,9 5,6 5,7 5,8 5,9 6,6 6,7 6,8 6,9 7,7 7,8\n" +
                "6,4 6,5 7,5 8,2 8,3 8,4 8,5 9,0 9,1 9,2 9,3 9,4 9,5\n" +
                "7,6 8,6 9,6 9,7\n" +
                "7,9 8,7 8,8 8,9 9,8 9,9\n" +
                "\n" +
                "0,4 0,7 1,1 1,9 2,3 2,5 3,1 3,8 4,3 4,5 5,0 5,7 6,2 6,4 7,6 7,9 8,0 8,2 9,6 9,8";
        System.out.println(hrg.getNewPuzzle()); //Manual Test. Verify that the right String format is being printed
        String serverResponse = hrg.getNewPuzzle();
//        assertTrue(serverResponse.equals(puzzle1) || serverResponse.equals(puzzle2));
//        assertEquals(serverResponse, puzzle2);
        assertFalse(hrg.getNewPuzzle().equals(""));
    }
}