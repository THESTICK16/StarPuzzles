package tests;

import org.junit.jupiter.api.Test;
import starb.Coordinate;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    Coordinate c = new Coordinate(1,2);

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("(1,2)", c.toString());
    }

    @Test
    void getX() {
        assertEquals(1,c.getX());
    }

    @Test
    void getY() {
        assertEquals(2,c.getY());
    }
}