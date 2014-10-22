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
        int y = 0;
        for(int x=0; x < cells.size(); ++x){
            Cell cell = cells.get(x);
            List<Cell> neighbours = Lists.newArrayList();
            if( cells.size() == 2){
                boolean istSecondCell = x == 1;
                if(istSecondCell){
                    Cell daCell = getAt(x - 1, y);
                    neighbours.add(daCell);
                }else{
                    Cell canndiate = getAt(x + 1, y);
                    neighbours.add(canndiate);
                }
            }
            habitats.add(new Habitat(cell, neighbours));
        }
        return habitats;
    }
}
