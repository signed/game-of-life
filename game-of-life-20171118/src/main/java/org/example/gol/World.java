package org.example.gol;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

class World {

    private final Set<Coordinates> aliveCells;

    World(Set<Coordinates> aliveCells) {
        this.aliveCells = aliveCells;
    }

    boolean isAliveAt(Coordinates coordinates) {
        return aliveCells.contains(coordinates);
    }

    World evolve() {
        Set<Coordinates> allCoordinatesAdjacentToALivingCell = aliveCells.stream()
                .map(Coordinates::adjacentCoordinates)
                .flatMap(Collection::stream).collect(Collectors.toSet());

        Set<Coordinates> newWorldPopulation = allCoordinatesAdjacentToALivingCell.stream()
                .filter(this::hostsLifeInNewWorld)
                .collect(toSet());
        return new World(newWorldPopulation);
    }

    private boolean hostsLifeInNewWorld(Coordinates c) {
        long aliveNeighbours = aliveNeighbourCount(c);
        if (isAliveAt(c)) {
            return aliveNeighbours == 2 || aliveNeighbours == 3;
        }
        return aliveNeighbours == 3;
    }

    long aliveNeighbourCount(Coordinates center) {
        return center.adjacentCoordinates().stream()
                .filter(this::isAliveAt)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        return aliveCells.equals(world.aliveCells);
    }

    @Override
    public int hashCode() {
        return aliveCells.hashCode();
    }

    @Override
    public String toString() {

        if (aliveCells.isEmpty()) {
            return "";
        }
        List<Integer> xValues = aliveCells.stream().map(c -> c.x).distinct().sorted().collect(toList());
        List<Integer> yValues = aliveCells.stream().map(c -> c.y).distinct().sorted().collect(toList());

        List<String> rows = new LinkedList<>();
        Integer minY = yValues.get(0);
        Integer maxY = yValues.get(yValues.size() - 1);
        Integer minX = xValues.get(0);
        Integer maxX = xValues.get(xValues.size() - 1);
        for (int rowIndex = minY; rowIndex <= maxY; rowIndex++) {
            List<String> columnValues = new LinkedList<>();
            for (int columnIndex = minX; columnIndex <= maxX; columnIndex++) {
                String cellAsString = isAliveAt(Coordinates.xy(columnIndex, rowIndex)) ? "x" : "o";
                columnValues.add(cellAsString);
            }
            rows.add(columnValues.stream().collect(Collectors.joining("")));
        }

        String coordinates = "(" + minX + "/" + minY + ") -> (" + maxX + "/" + maxY + ")";
        String board = rows.stream().collect(Collectors.joining("\n"));
        return coordinates + "\n" + board;
    }
}
