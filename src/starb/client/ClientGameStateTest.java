package starb.client;

import static org.junit.Assert.*;

public class ClientGameStateTest {

    ClientGameState cGS;
    ClientGameState cGS2;
    ClientGameState stringCGS;
    Puzzle puz;
    Puzzle puz2;
    String puzPath = "puzzle-1-1-1.txt";

    @org.junit.Before
    public void setUp() throws Exception {
        cGS = new ClientGameState(puz);
        cGS2 = new ClientGameState(puz2);
        stringCGS = new ClientGameState(puzPath);
    }

    @org.junit.Test
    public void alterBoard() {
        assertTrue(cGS.alterBoard('*', 1, 1));
        asserFalse(cGS.alterBoard('$', 1, 1));
    }

    @org.junit.Test
    public void getGame() {
    }

    @org.junit.Test
    public void testToString() {
        System.out.println(cGS.toString());
        System.out.println(cGS2.toString());
        System.out.println(stringCGS.toString());
    }
}