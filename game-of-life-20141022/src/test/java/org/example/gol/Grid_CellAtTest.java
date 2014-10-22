package org.example.gol;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Grid_CellAtTest {
    List<Cell> cells = Lists.newArrayList();
    private int width = 1;

    @Test
    public void placeTheFirstCellAt_0_0() throws Exception {
        cells.add(Cell.x);

        assertThat(grid().getAt(0, 0).alive(), is(true));
    }

    @Test
    public void placeTheTheSecondCellAt_1_0_inAGridWithWidth_2() throws Exception {
        width = 2;
        cells.add(Cell.o);
        cells.add(Cell.x);

        assertThat(grid().getAt(1, 0).alive(), is(true));
    }

    @Test
    public void placeTheTheSecondCellAt_0_1() throws Exception {
        cells.add(Cell.o);
        cells.add(Cell.x);

        assertThat(grid().getAt(0, 1).alive(), is(true));
    }

    private Grid grid() {
        return new Grid(cells, width);
    }


}
