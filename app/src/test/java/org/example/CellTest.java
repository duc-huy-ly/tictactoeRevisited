package org.example;

import org.junit.Test;

public class CellTest {
    @Test
    public void testGetMarker() {
        Cell cell = new Cell();
        assert (cell.getMarker() == Marker.NONE);
    }

    @Test
    public void testToString() {
        Cell cell = new Cell();
        System.out.println(cell.getMarker().toString());
        System.out.println(cell.toString());
        assert (true);
    }
}
