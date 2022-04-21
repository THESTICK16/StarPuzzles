package tests;

import starb.Coordinate;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    Coordinate c = new Coordinate(1,1);

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("(1,1)", c.toString());
    }
}