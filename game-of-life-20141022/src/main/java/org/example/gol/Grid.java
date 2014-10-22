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
                if(istSecondCell) {
                    int left_x = x - 1;
                    int left_y = y;
                    if (left_x >= 0) {
                        Cell candidate = getAt(left_x, left_y);
                        neighbours.add(candidate);
                    }
                }else {
                    int right_x = x + 1;
                    int right_y = y;
                    if (right_y < width) {
                        Cell candiate = getAt(right_x, right_y);
                        neighbours.add(candiate);
                    }
                }
            }
            habitats.add(new Habitat(cell, neighbours));
        }
        return habitats;
    }
}
