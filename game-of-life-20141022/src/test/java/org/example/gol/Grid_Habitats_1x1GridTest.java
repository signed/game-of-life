package org.example.gol;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class Grid_Habitats_1x1GridTest {
    private final GridBuilder grid = new GridBuilder().width(1);

    @Test
    public void returnOneHabitat() throws Exception {
        grid.add(Cell.x);

        assertThat(habitats(), hasSize(1));
    }

    private List<Habitat> habitats() {
        return grid.grid().habitats();
    }

}