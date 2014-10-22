package org.example.gol;

import com.google.common.collect.Iterables;

public class Habitat {
    private final Cell hosted;
    private final Iterable<Cell> neighbours;

    public Habitat(Cell hosted, Iterable<Cell> neighbours) {
        this.hosted = hosted;
        this.neighbours = neighbours;
    }

    public boolean alive() {
        return hosted.alive();
    }

    public int aliveNeighbourCount() {
        return Iterables.size(neighbours);
    }
}
