package org.example.gol;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class GridBuilder {
    public final List<Cell> cells = Lists.newArrayList();
    private int width = 1;

    public GridBuilder width(int width) {
        this.width = width;
        return this;
    }

    public GridBuilder add(Cell... row) {
        Collections.addAll(cells, row);
        return this;
    }

    public Grid grid() {
        return new Grid(cells, width);
    }
}