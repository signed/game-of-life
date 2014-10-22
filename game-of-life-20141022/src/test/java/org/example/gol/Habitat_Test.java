package org.example.gol;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.example.gol.Cell.o;
import static org.example.gol.Cell.x;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Habitat_Test {
    private final List<Cell> neighbours = Lists.newArrayList();
    private Cell hosted = CellBuilder.anyCell();

    @Test
    public void aHabitatIsAliveIfTheHostedCellIsAlive() throws Exception {
        hosted = x;
        assertThat(habitat().alive(), is(true));
    }

    @Test
    public void aHabitatIsDeadIfTheHostedCellIsDead() throws Exception {
        hosted = o;
        assertThat(habitat().alive(), is(false));
    }

    @Test
    public void withOneAliveNeighbour() throws Exception {
        neighbours.add(x);
        assertThat(habitat().aliveNeighbourCount(), is(1));
    }

    @Test
    public void withTwoAliveAndOneDeadeNeighbour() throws Exception {
        neighbours.add(x);
        neighbours.add(o);
        neighbours.add(x);
        assertThat(habitat().aliveNeighbourCount(), is(2));
    }



    private Habitat habitat() {
        return new Habitat(hosted, neighbours);
    }
}
