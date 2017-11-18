package org.example.gol;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

class World {
    private Set<Coordinates> aliveCells;

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
}
