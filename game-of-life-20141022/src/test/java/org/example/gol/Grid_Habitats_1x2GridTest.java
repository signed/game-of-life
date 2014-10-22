package org.example.gol;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.example.gol.Cell.o;
import static org.example.gol.Cell.x;
import static org.example.gol.CellBuilder.anyCell;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class Grid_Habitats_1x2GridTest {
    private final GridBuilder grid = new GridBuilder().width(1);

    @Test
    public void returnOneHabitat() throws Exception {
        grid.add(anyCell(), anyCell());

        assertThat(habitats(), hasSize(2));
    }

    @Test
    public void firstHabitatHasOneAliveNeighbour() throws Exception {
        grid.add(o);
        grid.add(x);

        assertThat(habitats().get(0).aliveNeighbourCount(), is(1));
    }

    @Test
    @Ignore
    public void secondHabitatHasZeroAliveNeighbour() throws Exception {
        grid.add(o, x);

        assertThat(habitats().get(1).aliveNeighbourCount(), is(0));
    }

    private List<Habitat> habitats() {
        return grid.grid().habitats();
    }

}