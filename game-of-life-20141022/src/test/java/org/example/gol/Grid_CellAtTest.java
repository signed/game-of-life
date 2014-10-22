package org.example.gol;

import org.junit.Test;

import static org.example.gol.Cell.*;
import static org.example.gol.Cell.o;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Grid_CellAtTest {
    private final GridBuilder gridBuilder = new GridBuilder();

    @Test
    public void placeTheFirstCellAt_0_0() throws Exception {
        gridBuilder.cells.add(x);

        assertThat(gridBuilder.grid().getAt(0, 0).alive(), is(true));
    }

    @Test
    public void placeTheTheSecondCellAt_1_0_inAGridWithWidth_2() throws Exception {
        gridBuilder.width(2);
        gridBuilder.add(o, x);

        assertThat(gridBuilder.grid().getAt(1, 0).alive(), is(true));
    }

    @Test
    public void placeTheTheSecondCellAt_0_1() throws Exception {
        gridBuilder.cells.add(o);
        gridBuilder.cells.add(x);

        assertThat(gridBuilder.grid().getAt(0, 1).alive(), is(true));
    }


}
