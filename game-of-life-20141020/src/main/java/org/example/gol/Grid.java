package org.example.gol;

import java.util.List;

import com.google.common.collect.Lists;

public class Grid {
    private final int width;
    private final int height;
    private final List<Cell> cells;

    public Grid(int width, int height, List<Cell> cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    public Cell cellAt(int x, int y) {
        int index = x + width * y;
        return cells.get(index);
    }

    public List<Habitat> toHabitats() {
        return Lists.newArrayList(new Habitat(cells.get(0), null));
    }
}
