package org.example.gol;

import java.util.List;

import com.google.common.collect.Lists;

public class GridBuilder {
    private int width;
    private int height;
    private List<Cell> cells = Lists.newArrayList();
    private boolean fill = false;

    public GridBuilder width(int width) {
        this.width = width;
        return this;
    }

    public GridBuilder height(int height) {
        this.height = height;
        return this;
    }

    public GridBuilder add(Cell... cells) {
        for (Cell cell : cells) {
            add(cell);
        }
        return this;
    }

    public GridBuilder add(Cell cell) {
        cells.add(cell);
        return this;
    }

    public GridBuilder fillWithAnyCells() {
        fill = true;
        return this;
    }

    public Grid build() {
        if (fill) {
            for (int i = cells.size(); i < width * height; ++i) {
                cells.add(Cell.CreateAliveCell());
            }
        }

        return new Grid(width, height, cells);
    }
}
