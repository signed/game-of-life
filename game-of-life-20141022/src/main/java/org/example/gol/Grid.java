package org.example.gol;

import java.util.List;

public class Grid {
    private final List<Cell> cells;

    public Grid(List<Cell> cells) {
        this.cells = cells;
    }

    public Cell getAt(int x, int y) {
        return cells.get(y);
    }
}
