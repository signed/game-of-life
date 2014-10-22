package org.example.gol;

public class Cell {
    private final boolean alive;

    public static Cell CreateAliveCell() {
        return new Cell(Constants.Alive);
    }

    public static Cell CreateDeadCell() {
        return new Cell(Constants.Dead);
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean alive() {
        return alive;
    }

    public boolean dead() {
        return !alive();
    }
}
