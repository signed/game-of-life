package org.example.gol;

import static org.example.gol.CellBuilder.o;
import static org.example.gol.CellBuilder.x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;

import org.junit.Test;

public class Grid_2x1Test {

    private final GridBuilder grid = new GridBuilder().width(2).height(1);

    @Test
    public void theFirstHabitatShouldHaveZeroAliveNeighbours() throws Exception {
        grid.add(o, x);

        assertThat(firstHabitat().numberOfAliveNeighbours(), is(1));
    }

    @Test
    public void theSecondHabitatShouldHaveOneAliveNeighbour() throws Exception {
        grid.add(x, o);

        assertThat(secondHabitat().numberOfAliveNeighbours(), is(1));
    }

    private Habitat secondHabitat() {
        return habitats().get(1);
    }

    private Habitat firstHabitat() {
        return habitats().get(0);
    }

    private List<Habitat> habitats() {
        return grid.build().habitats();
    }
}
