package org.example.gol;

import org.junit.Test;

import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.gol.Coordinates.xy;

public class WorldTest {

    private final LinkedHashSet<Coordinates> aliveCells = new LinkedHashSet<>();

    @Test
    public void cellWithoutNeighboursDies() throws Exception {
        cellAliveAt(xy(0, 0));

        assertThat(evolvedWorld().isAliveAt(xy(0, 0))).isFalse();
    }

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

    @Test
    public void cellWithTwoNeighboursStaysAlive() throws Exception {
        cellAliveAt(xy(-1, -1));
        cellAliveAt(xy(0, 0));
        cellAliveAt(xy(1, 1));

        assertThat(evolvedWorld().isAliveAt(xy(0, 0))).isTrue();
    }

    @Test
    public void cellWithThreeNeighboursStaysAlive() throws Exception {
        cellAliveAt(xy(-1, -1));
        cellAliveAt(xy(1, -1));
        cellAliveAt(xy(0, 0));
        cellAliveAt(xy(1, 1));

        assertThat(evolvedWorld().isAliveAt(xy(0, 0))).isTrue();
    }

    @Test
    public void aPreviouslyDeadCellBecomesAliveIfThereAreExactlyThreeNeighbours() throws Exception {
        cellAliveAt(xy(-1, -1));
        cellAliveAt(xy(0, -1));
        cellAliveAt(xy(1, -1));

        assertThat(evolvedWorld().isAliveAt(xy(0, 0))).isTrue();
    }

    @Test
    public void anAliveCellWithMoreThanThreeNeighboursDies() throws Exception {
        cellAliveAt(xy(-1, -1));
        cellAliveAt(xy(0, -1));
        cellAliveAt(xy(1, -1));
        cellAliveAt(xy(0, 0));
        cellAliveAt(xy(-1, 0));

        assertThat(evolvedWorld().isAliveAt(xy(0, 0))).isFalse();
    }

    private void cellAliveAt(Coordinates coordinates) {
        aliveCells.add(coordinates);
    }

    private World evolvedWorld() {
        return world().evolve();
    }

    private World world() {
        return new World(aliveCells);
    }

}
