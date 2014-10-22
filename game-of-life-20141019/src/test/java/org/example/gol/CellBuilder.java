package org.example.gol;

public class CellBuilder {

    public static final Cell o = deadCell();
    public static final Cell x = aliveCell();

    public static Cell anyCell() {
        return Cell.CreateDeadCell();
    }

    public static Cell aliveCell() {
        return Cell.CreateAliveCell();
    }

    public static Cell deadCell() {
        return Cell.CreateDeadCell();
    }
}
