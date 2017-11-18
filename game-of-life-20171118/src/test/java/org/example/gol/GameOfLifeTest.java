package org.example.gol;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.gol.Coordinates.xy;

public class GameOfLifeTest {

    @Test
    public void twoCoordinatesAreEqualIfThereXandYvaluesMatch() throws Exception {
        Coordinates coordinate = xy(0, 0);
        Set<Coordinates> coordinates = new LinkedHashSet<>();
        coordinates.add(coordinate);

        assertThat(coordinates).contains(xy(0, 0)).doesNotContain(xy(1, 1));
    }

    @Test
    public void cellWithoutNeighboursDies() throws Exception {
        cellAliveAt(xy(0, 0));

        assertThat(world().evolve().isAliveAt(xy(0, 0))).isFalse();
    }

    @Test
    public void topLeftIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(-1, -1));
    }

    @Test
    public void topIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(0, -1));
    }

    @Test
    public void topRightIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(1, -1));
    }

    @Test
    public void rightIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(1, 0));
    }

    @Test
    public void bottomRightIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(1, 1));
    }

    @Test
    public void bottomIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(0, 1));
    }

    @Test
    public void bottomLeftIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(-1, 1));
    }

    @Test
    public void leftIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(-1, 0));
    }

    @Test
    public void cellWithTwoNeighboursStaysAlive() throws Exception {
        cellAliveAt(xy(-1, -1));
        cellAliveAt(xy(0, 0));
        cellAliveAt(xy(1, 1));

        assertThat(world().evolve().isAliveAt(xy(0, 0))).isTrue();
    }

    private final LinkedHashSet<Coordinates> aliveCells = new LinkedHashSet<>();

    @Test
    public void theWorldProvidesTheNumberOfAliveAdjacentCells() throws Exception {
        cellAliveAt(xy(0, 0));
        cellAliveAt(xy(1, 1));
        cellAliveAt(xy(1, 0));

        assertThat(world().aliveNeighbourCount(xy(0, 0))).isEqualTo(2);
    }

    @Test
    public void theWorldProvidesInformationIfACellAtGivenCoordinatesIsAlive() throws Exception {
        cellAliveAt(xy(0, 0));

        assertThat(world().isAliveAt(xy(0, 0))).isTrue();
        assertThat(world().isAliveAt(xy(1, 1))).isFalse();
    }

    private void cellAliveAt(Coordinates coordinates) {
        aliveCells.add(coordinates);
    }

    private World world() {
        return new World(aliveCells);
    }

    private class World {
        private Set<Coordinates> aliveCells;

        World(Set<Coordinates> aliveCells) {
            this.aliveCells = aliveCells;
        }

        boolean isAliveAt(Coordinates coordinates) {
            return aliveCells.contains(coordinates);
        }

        World evolve() {
            Set<Coordinates> set = new LinkedHashSet<>();
            if (aliveCells.size() == 3) {
                set.add(xy(0, 0));
            }
            return new World(set);
        }

        long aliveNeighbourCount(Coordinates center) {
            return center.adjacentCoordinates().stream()
                    .filter(this::isAliveAt)
                    .count();
        }
    }
}
