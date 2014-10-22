package org.example.gol;


import com.google.common.collect.Iterables;

public class Habitat {
    private final Cell cell;
    private final Iterable<Cell> neighbours;

    public Habitat(Cell cell, Iterable<Cell> neighbours) {
        this.cell = cell;
        this.neighbours = neighbours;
    }

    public boolean alive() {
        return cell.isAlive();
    }

    public boolean dead() {
        return !alive();
    }

    public int numberOfAliveNeighbours() {
        Iterable<Cell> aliveOnly = Iterables.filter(neighbours, Cell::isAlive);
        return Iterables.size(aliveOnly);
    }
}
