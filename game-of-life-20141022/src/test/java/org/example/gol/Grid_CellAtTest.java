package org.example.gol;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.example.gol.Cell.*;
import static org.example.gol.Cell.o;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Grid_CellAtTest {
    private final List<Cell> cells = Lists.newArrayList();
    private int width = 1;

    @Test
    public void placeTheFirstCellAt_0_0() throws Exception {
        cells.add(x);

        assertThat(grid().getAt(0, 0).alive(), is(true));
    }

    @Test
    public void placeTheTheSecondCellAt_1_0_inAGridWithWidth_2() throws Exception {
        width = 2;
        add(o, x);

        assertThat(grid().getAt(1, 0).alive(), is(true));
    }

    @Test
    public void placeTheTheSecondCellAt_0_1() throws Exception {
        cells.add(o);
        cells.add(x);

        assertThat(grid().getAt(0, 1).alive(), is(true));
    }

    private void add(Cell ... row) {
        Collections.addAll(cells, row);
    }

    private Grid grid() {
        return new Grid(cells, width);
    }


}
