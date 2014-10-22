package org.example.gol;

public class Cell {
    public static Cell x = new Cell(true);
    public static Cell o = new Cell(false);

    private boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean alive() {
        return alive;
    }
}
