package org.example.gol;

import com.google.common.collect.Lists;

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

    public List<Habitat> habitats() {
        return Lists.newArrayList(new Habitat(cells.get(0), null));
    }
}
