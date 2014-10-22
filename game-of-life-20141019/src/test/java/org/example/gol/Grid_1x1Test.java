package org.example.gol;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class Grid_1x1Test {

    private final GridBuilder grid = new GridBuilder().width(1).height(1);

    @Test
    public void aGridOfSize_1x1_ProducesOneHabitat() throws Exception {
        grid.add(CellBuilder.anyCell());

        assertThat(grid.build().habitats(), Matchers.hasSize(1));
    }

    @Test
    public void putThePassedCellIntoTheHabitat() throws Exception {
        grid.add(Cell.CreateDeadCell());

        assertThat("should be dead because the cell that inhabits it is dead", soleHabitat().dead());
    }

    @Test
    public void hasNoAliveNeighbours() throws Exception {
        grid.add(Cell.CreateDeadCell());

        assertThat(soleHabitat().numberOfAliveNeighbours(), is(0));
    }

    private Habitat soleHabitat() {
        return grid.build().habitats().get(0);
    }
}
