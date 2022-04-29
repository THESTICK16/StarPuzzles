package tests;

import starb.client.ClientGameState;
import starb.puzzle.Coordinate;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ClientGameStateTest {
    ClientGameState cgs;
    char[][] testGame;

    @org.junit.Before
    public void setUp() throws Exception {
        cgs = new ClientGameState("puzzles/puzzle-1-1-1.txt");
        testGame = new char[10][10];
    }

    @org.junit.Test
    public void alterBoard() {
    }

    @org.junit.Test
    public void testToString() {
    }

    @org.junit.Test
    public void checkVictory() {
        ArrayList<Coordinate> tS = new ArrayList<>();
        ArrayList<Coordinate> tP = new ArrayList<>();
        tS.add(new Coordinate(3, 4));
        tS.add(new Coordinate(2, 2));
        tS.add(new Coordinate(1, 5));
        tP.add(new Coordinate(2, 2));
        tP.add(new Coordinate(1, 5));
        tP.add(new Coordinate(3, 4));
        assertTrue(cgs.checkVictory(tP, tS));
        tP.add(new Coordinate(7, 0));
        assertFalse(cgs.checkVictory(tP, tS));
        tS.add(new Coordinate(7, 0));
        assertTrue(cgs.checkVictory(tP, tS));
        tS.add(new Coordinate(1, 1));
        assertFalse(cgs.checkVictory(tP, tS));
    }
}