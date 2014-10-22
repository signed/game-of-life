package org.example.gol;

public class CellBuilder {

    public static Cell x = aliveCell();
    public static Cell o = deadCell();

    public static Cell anyCell() {
        return Cell.CreateAliveCell();
    }


    public static Cell aliveCell() {
        return Cell.CreateAliveCell();
    }

    private static Cell deadCell() {
        return Cell.CreateDeadCell();
    }
}
