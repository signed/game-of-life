package org.example.gol;

import java.util.List;

public class Grid {
    private final List<Cell> cells;
    private final int width;

    public Grid(List<Cell> cells, int width) {
        this.cells = cells;
        this.width = width;
    }

    public Cell getAt(int x, int y) {
        int index = y * width + x;
        return cells.get(index);
    }
}
