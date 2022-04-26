package tests;

import starb.client.ClientGameState;

import static org.junit.Assert.*;

public class ClientGameStateTest {
    ClientGameState cgs;
    char[][] testGame;

    @org.junit.Before
    public void setUp() throws Exception {
        cgs = new ClientGameState();
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
    }
}