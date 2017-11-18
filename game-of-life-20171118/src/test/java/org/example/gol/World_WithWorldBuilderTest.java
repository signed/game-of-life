package org.example.gol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.gol.Coordinates.xy;
import static org.example.gol.WorldBuilder.o;
import static org.example.gol.WorldBuilder.x;

public class World_WithWorldBuilderTest {

    private final WorldBuilder world = new WorldBuilder();

    @Test
    public void cellWithoutNeighboursDies() throws Exception {
        row(x);

        assertThat(evolvedWorld().isAliveAt(xy(0, 0))).isFalse();
    }

    @Test
    public void theWorldProvidesTheNumberOfAliveAdjacentCells() throws Exception {
        row(o, x, o);
        row(o, x, o);
        row(o, o, x);

        assertThat(world().aliveNeighbourCount(xy(1, 1))).isEqualTo(2);
    }

    @Test
    public void theWorldProvidesInformationIfACellAtGivenCoordinatesIsAlive() throws Exception {
        row(x);

        assertThat(world().isAliveAt(xy(0, 0))).isTrue();
        assertThat(world().isAliveAt(xy(1, 1))).isFalse();
    }

    @Test
    public void cellWithTwoNeighboursStaysAlive() throws Exception {
        row(x, x);
        row(x, o);

        assertThat(evolvedWorld().isAliveAt(xy(0, 0))).isTrue();
    }

    @Test
    public void cellWithThreeNeighboursStaysAlive() throws Exception {
        row(x, x);
        row(x, x);

        assertThat(evolvedWorld().isAliveAt(xy(0, 0))).isTrue();
    }

    @Test
    public void aPreviouslyDeadCellBecomesAliveIfThereAreExactlyThreeNeighbours() throws Exception {
        row(o, x);
        row(x, x);

        assertThat(evolvedWorld().isAliveAt(xy(0, 0))).isTrue();
    }

    @Test
    public void anAliveCellWithMoreThanThreeNeighboursDies() throws Exception {
        row(x, x, x);
        row(x, x, x);

        assertThat(evolvedWorld().isAliveAt(xy(1, 0))).isFalse();
    }

    private void row(Boolean... cells) {
        world.row(cells);
    }

    private World evolvedWorld() {
        return world().evolve();
    }

    private World world() {
        return world.build();
    }

}
