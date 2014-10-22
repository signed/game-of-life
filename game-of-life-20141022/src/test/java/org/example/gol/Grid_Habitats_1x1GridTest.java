package org.example.gol;

import org.junit.Test;

import java.util.List;

import static org.example.gol.Cell.x;
import static org.example.gol.CellBuilder.anyCell;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class Grid_Habitats_1x1GridTest {
    private final GridBuilder grid = new GridBuilder().width(1);

    @Test
    public void returnOneHabitat() throws Exception {
        grid.add(anyCell());

        assertThat(habitats(), hasSize(1));
    }

    @Test
    public void habitatIsAlive() throws Exception {
        grid.add(x);

        assertThat(habitats().get(0).alive(), is(true));
    }

    private List<Habitat> habitats() {
        return grid.grid().habitats();
    }

}