package org.example.gol;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Cell_Test {

    @Test
    public void aliveCellShouldBeAlive() throws Exception {
       assertThat(Cell.x.alive(), is(true));
    }

    @Test
    public void deadCellShouldNotBeAlive() throws Exception {
        assertThat(Cell.o.alive(), is(false));
    }
}