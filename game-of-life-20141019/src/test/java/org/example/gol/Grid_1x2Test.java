package org.example.gol;

import static org.example.gol.CellBuilder.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

import java.util.List;

import org.junit.Test;

public class Grid_1x2Test {

    private final GridBuilder grid = new GridBuilder().width(1).height(2);

    @Test
    public void producesTwoHabitats() throws Exception {
        grid.add(anyCell());
        grid.add(anyCell());

        assertThat(habitats(), hasSize(2));
    }

    @Test
    public void returnHabitatsInOrderTheCellWasPassed() throws Exception {
        grid.add(x);
        grid.add(o);

        assertThat("the first habitat should be for the alive cell", firstHabitat().alive());
        assertThat("the second habitat should be for the dead cell", secondHabitat().dead());
    }

    @Test
    public void theFirstHabitatShouldHaveZeroAliveNeighbours() throws Exception {
        grid.add(x);
        grid.add(o);

        assertThat(firstHabitat().numberOfAliveNeighbours(), is(0));
    }

    @Test
    public void theSecondHabitatShouldHaveOneAliveNeighbour() throws Exception {
        grid.add(x);
        grid.add(o);

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
