package org.example.gol;

import static org.example.gol.CellBuilder.o;
import static org.example.gol.CellBuilder.x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class Grid_CellAtTest {
    private final GridBuilder grid = new GridBuilder();

    @Test
    public void firstCellInTheListRepresentsOrigin() throws Exception {
        grid.width(1).height(1);
        grid.add(x);

        assertThat(grid().cellAt(0, 0).alive(), is(true));
    }

    @Test
    public void heightGrowsDownwardsInGrid() throws Exception {
        grid.width(1).height(2);
        grid.add(x);
        grid.add(o);

        assertThat(grid().cellAt(0, 1).dead(), is(true));
    }

    @Test
    public void widthGrowsToTheRight() throws Exception {
        grid.width(2).height(2);
        grid.add(o, o);
        grid.add(o, x);

        assertThat(grid().cellAt(1, 1).alive(), is(true));
    }

    private Grid grid() {
        return grid.build();
    }

}
