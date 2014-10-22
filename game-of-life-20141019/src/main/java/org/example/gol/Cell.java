package org.example.gol;

public class Cell {
    private final boolean alive;

    public static Cell CreateAliveCell() {
        return new Cell(true);
    }

    public static Cell CreateDeadCell() {
        return new Cell(false);
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return !isAlive();
    }
}
