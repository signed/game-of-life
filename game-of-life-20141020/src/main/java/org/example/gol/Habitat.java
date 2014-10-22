package org.example.gol;

import java.util.Collection;

public class Habitat {

    private final Cell cell;
    private final Collection<Cell> neighbours;

    public Habitat(Cell cell, Collection<Cell> neighbours) {
        this.cell = cell;
        this.neighbours = neighbours;
    }

    public boolean alive() {
        return cell.alive();
    }

    public int numberOfAliveNeighbours() {
        return neighbours.stream().filter(Cell::alive).toArray().length;
    }
}
