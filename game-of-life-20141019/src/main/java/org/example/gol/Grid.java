package org.example.gol;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;


public class Grid {

    private static class Coordinates {
        public final int x;
        public final int y;

        private Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final int width;
    private final int height;
    private final List<Cell> cells;

    public Grid(int width, int height, List<Cell> cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public List<Habitat> habitats() {
        List<Habitat> habitats = Lists.newArrayList();
        for (int i = 0; i < cells.size(); ++i) {
            Coordinates currentCellsCoordinates = new Coordinates(i % width, i / width);
            List<Cell> neighbours = neighboursOf(currentCellsCoordinates);
            habitats.add(new Habitat(cells.get(i), neighbours));
        }
        return habitats;
    }

    private List<Cell> neighboursOf(Coordinates pivot) {
        List<Cell> neighbours = Lists.newArrayList();

        List<Coordinates> candidates = Lists.newArrayList();
        Coordinates above_left = new Coordinates(pivot.x - 1, pivot.y - 1);
        Coordinates above = new Coordinates(pivot.x, pivot.y - 1);
        Coordinates above_right = new Coordinates(pivot.x + 1, pivot.y - 1);
        Coordinates left = new Coordinates(pivot.x - 1, pivot.y);
        Coordinates right = new Coordinates(pivot.x + 1, pivot.y);
        Coordinates below_left = new Coordinates(pivot.x - 1, pivot.y + 1);
        Coordinates below = new Coordinates(pivot.x, pivot.y + 1);
        Coordinates below_right = new Coordinates(pivot.x + 1, pivot.y + 1);
        candidates.add(above_left);
        candidates.add(above);
        candidates.add(above_right);
        candidates.add(left);
        candidates.add(right);
        candidates.add(below_left);
        candidates.add(below);
        candidates.add(below_right);

        for (Coordinates candidate : candidates) {
            if(withinGrid(candidate)) {
                neighbours.add(cellAt(candidate));
            }
        }

        return neighbours;
    }

    public Cell cellAt(int x, int y) {
        return cellAt(new Coordinates(x, y));
    }

    private Cell cellAt(Coordinates candidate) {
        int linearized = linearized(candidate);
        return cells.get(linearized);
    }


    private boolean withinGrid(Coordinates below) {
        return below.x >= 0 && below.x < width && below.y >= 0 && below.y < height;
    }

    private int linearized(Coordinates below) {
        return below.x + width * below.y;
    }

    @Override
    public String toString() {
        Collection<String> lines = Lists.newArrayList();
        for (int height = 0; height < this.height; ++height) {
            Collection<String> columns = Lists.newArrayList();
            for (int width = 0; width < this.width; ++width) {
                Cell cell = cellAt(width, height);
                columns.add((cell.isAlive()? "x": "o"));
            }
            lines.add(Joiner.on("").join(columns));
        }
        return Joiner.on("\n").join(lines);
    }
}
