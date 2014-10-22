package org.example.gol;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Habitat_Test {
    private final List<Cell> neighbours = Lists.newArrayList();
    private Cell hosted = CellBuilder.anyCell();

    @Test
    public void aHabitatIsAliveIfTheHostedCellIsAlive() throws Exception {
        hosted = Cell.x;
        assertThat(habitat().alive(), is(true));
    }

    @Test
    public void aHabitatIsDeadIfTheHostedCellIsDead() throws Exception {
        hosted = Cell.o;
        assertThat(habitat().alive(), is(false));
    }

    @Test
    public void withOneAliveNeighbour() throws Exception {
        neighbours.add(Cell.x);

        assertThat(habitat().aliveNeighbourCount(), is(1));
    }

    private Habitat habitat() {
        return new Habitat(hosted, neighbours);
    }
}
