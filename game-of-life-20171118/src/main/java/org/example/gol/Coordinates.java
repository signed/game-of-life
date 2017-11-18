package org.example.gol;

import java.util.HashSet;
import java.util.Set;

class Coordinates {
    public static Coordinates xy(int x, int y) {
        return new Coordinates(x, y);
    }

    final int x;
    final int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Set<Coordinates> adjacentCoordinates() {
        HashSet<Coordinates> adjacentCoordinates = new HashSet<>();
        adjacentCoordinates.add(xy(x - 1, y - 1));
        adjacentCoordinates.add(xy(x, y - 1));
        adjacentCoordinates.add(xy(x + 1, y - 1));

        adjacentCoordinates.add(xy(x + 1, y));

        adjacentCoordinates.add(xy(x + 1, y + 1));
        adjacentCoordinates.add(xy(x, y + 1));
        adjacentCoordinates.add(xy(x - 1, y + 1));

        adjacentCoordinates.add(xy(x - 1, y));

        return adjacentCoordinates;
    }

    @Override
    public String toString() {
        return "(" + x + "/" + y + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
