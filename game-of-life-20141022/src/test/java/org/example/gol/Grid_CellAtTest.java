package org.example.gol;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Grid_CellAtTest {

    @Test
    public void placeTheFirstCellAt_0_0() throws Exception {
        List<Cell> cells = Lists.newArrayList();
        cells.add(Cell.x);

        Grid grid = new Grid(cells);
        assertThat(grid.getAt(0, 0).alive(), is(true));
    }

    @Test
    public void placeTheTheSecondCellAt_0_1() throws Exception {
        List<Cell> cells = Lists.newArrayList();
        cells.add(Cell.o);
        cells.add(Cell.x);

        Grid grid = new Grid(cells);
        assertThat(grid.getAt(0, 1).alive(), is(true));
    }


}
