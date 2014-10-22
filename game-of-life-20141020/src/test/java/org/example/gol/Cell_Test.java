package org.example.gol;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class Cell_Test {

    @Test
    public void anAliveCellShouldStateSo() throws Exception {
        assertThat(Cell.CreateAliveCell().alive(), is(Constants.Alive));
    }

    @Test
    public void aDeadCellShouldStateSo() throws Exception {
        assertThat(Cell.CreateDeadCell().alive(), is(Constants.Dead));
    }
}
