package tests;

import org.junit.jupiter.api.Test;
import starb.Coordinate;
import starb.PuzzleAdt;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class PuzzleAdtTest {

    PuzzleAdt p = new PuzzleAdt();
    PuzzleAdt pFile = new PuzzleAdt("puzzles/puzzle-1-1-1.txt");

    @Test
    void convertData() {
        TreeMap<Integer, ArrayList<Coordinate>> test = new TreeMap<>();

        ArrayList<Coordinate> l = new ArrayList<>();

        Coordinate c = new Coordinate(0,0);
        Coordinate x = new Coordinate(1,1);
        Coordinate y = new Coordinate(2,2);

        l.add(c);
        l.add(x);
        l.add(y);

        test.put(1, l);


        p.convertData(test,3);
        System.out.println(p.getBoard().toString());

    }

    @Test
    void convertData2(){
        System.out.println(pFile.toString());
    }

}