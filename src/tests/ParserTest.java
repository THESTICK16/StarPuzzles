package tests;

import org.junit.jupiter.api.Test;
import starb.Coordinate;
import starb.Parser;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    String unparsed = "0,0 1,1 2,2";
    String puzzleData = "10 2";

    Coordinate c = new Coordinate(0,0);
    Coordinate x = new Coordinate(1,1);
    Coordinate y = new Coordinate(2,2);

    ArrayList<Coordinate> list = new ArrayList<>();

    Parser p = new Parser();

    Parser parse = new Parser("puzzles/puzzle-1-1-1.txt");

    @Test
    void coordToList() {
        list.add(c);
        list.add(x);
        list.add(y);

        assertEquals(list.toString(), p.parseCoordinates(unparsed).toString());
    }

    @Test
    void parsePuzzleData() {
        p.parsePuzzleData(puzzleData);
        assertEquals(10,p.getDimension());
    }

    @Test
    void parsePuzzleData2() {
        p.parsePuzzleData(puzzleData);
        assertEquals(2,p.getStars());
    }

    @Test
    void numFileLines() {
        p.readFile("puzzles/puzzle-1-1-1.txt");
        assertEquals(14,p.numFileLines(p.getFile()));
    }

    @Test
    void parserDimensions(){
        assertEquals(10,parse.getDimension());
    }

    @Test
    void parserStars(){
        assertEquals(2,parse.getStars());
    }

    @Test
    void parserSolutions(){
        ArrayList<Coordinate> solutions;

        String solutionsString = "0,1 0,4 1,6 1,8 2,1 2,3 3,7 3,9 4,3 4,5 5,0 5,7 6,2 6,4 7,6 7,8 8,0 8,2 9,5 9,9";

        solutions = p.parseCoordinates(solutionsString);

        assertEquals(solutions.toString(),parse.getSolutions().toString());
    }

    @Test
    void parserData(){
        TreeMap<Integer, ArrayList<Coordinate>> data = new TreeMap<>();

        String data1 = "0,0 0,1 0,2 0,3 0,4 0,5 0,6 0,7 1,0 1,1 1,2 1,3 1,4 1,5 1,7 2,4";
        String data2 = "0,8 0,9 1,8 1,9 2,8 2,9 3,8 3,9 4,8 4,9 5,8 5,9 6,9 7,9";
        String data3 = "2,0 3,0 3,1 3,2 3,3 4,0 4,1 4,2 5,0 5,1 6,0 6,1 7,0 7,1 7,2 7,3 7,4 7,5 8,0";
        String data4 = "2,1 2,2 2,3";
        String data5 = "1,6 2,5 2,6 2,7 3,7";
        String data6 = "3,4 4,3 4,4 4,5 5,3 5,4 5,5";
        String data7 = "3,5 3,6 4,6 4,7 5,6 5,7 6,5 6,6 6,7 7,6 7,7";
        String data8 = "5,2 6,2 6,3 6,4";
        String data9 = "6,8 7,8 8,8 8,9 9,9";
        String data10 = "8,1 8,2 8,3 8,4 8,5 8,6 8,7 9,0 9,1 9,2 9,3 9,4 9,5 9,6 9,7 9,8";

        data.put(1,p.parseCoordinates(data1));
        data.put(2,p.parseCoordinates(data2));
        data.put(3,p.parseCoordinates(data3));
        data.put(4,p.parseCoordinates(data4));
        data.put(5,p.parseCoordinates(data5));
        data.put(6,p.parseCoordinates(data6));
        data.put(7,p.parseCoordinates(data7));
        data.put(8,p.parseCoordinates(data8));
        data.put(9,p.parseCoordinates(data9));
        data.put(10,p.parseCoordinates(data10));


        assertEquals(data.toString(),parse.getData().toString());
    }

}