package org.example.gol;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class GridBuilder {
    private final List<Cell> cells = Lists.newArrayList();
    private int width;
    private int height;

    public GridBuilder add(Cell... cells){
        Collections.addAll(this.cells, cells);
        return this ;
    }

    public GridBuilder width(int width){
        this.width = width;
        return this;
    }

    public GridBuilder height(int height){
        this.height = height;
        return this;
    }

    public Grid build() {
        return new Grid(width, height, cells);
    }
}
