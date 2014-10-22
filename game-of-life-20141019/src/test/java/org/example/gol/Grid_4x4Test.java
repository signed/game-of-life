package org.example.gol;

import static org.example.gol.CellBuilder.*;
import static org.example.gol.CellBuilder.x;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;

public class Grid_4x4Test {

    private final GridBuilder grid = new GridBuilder().width(2).height(2);

    @Test
    public void findNeighboursRightBelow() throws Exception {
        grid.add(o, o);
        grid.add(o, x);

        assertThat(firstHabitat().numberOfAliveNeighbours(), is(1));
    }

    @Test
    public void findNeighboursLeftAbove() throws Exception {
        grid.add(x, o);
        grid.add(o, o);

        assertThat(fourthHabitat().numberOfAliveNeighbours(), is(1));
    }

    @Test
    public void findNeighboursRightAbove() throws Exception {
        grid.add(o, x);
        grid.add(o, o);

        assertThat(thirdHabitat().numberOfAliveNeighbours(), is(1));
    }

    @Test
    public void findNeighboursLeftBelow() throws Exception {
        grid.add(o, o);
        grid.add(x, o);

        assertThat(secondHabitat().numberOfAliveNeighbours(), is(1));
    }

    private Habitat secondHabitat() {
        return habitats().get(1);
    }


    private Habitat thirdHabitat() {
        return habitats().get(2);
    }

    private Habitat fourthHabitat() {
        return habitats().get(3);
    }

    private Habitat firstHabitat() {
        return habitats().get(0);
    }

    private List<Habitat> habitats() {
        return grid.build().habitats();
    }
}
