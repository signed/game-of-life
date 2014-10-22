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
        List<Habitat> habitats = Lists.newArrayList();
        for (Cell cell : cells) {

            List<Cell> neighbours = Lists.newArrayList();
            if( cells.size() == 2){
                if(cell.alive()){
                    neighbours.add(Cell.o);
                }else{
                    neighbours.add(Cell.x);

                }
            }
            habitats.add(new Habitat(cell, neighbours));
        }
        return habitats;
    }
}
