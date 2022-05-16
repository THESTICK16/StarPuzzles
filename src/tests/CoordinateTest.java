package tests;

import org.junit.jupiter.api.Test;
import starb.puzzle.Coordinate;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    Coordinate c = new Coordinate(1,2);

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("1,2", c.toString());
    }

    @Test
    void getX() {
        assertEquals(1,c.getX());
    }

    @Test
    void getY() {
        assertEquals(2,c.getY());
    }

    @Test
    void testCompare(){
        Coordinate c2 = new Coordinate(1,2);
        Coordinate c3 = new Coordinate(5, 3);
        assertTrue(c.compareCoord(c2));
        assertFalse(c.compareCoord(c3));
    }
}